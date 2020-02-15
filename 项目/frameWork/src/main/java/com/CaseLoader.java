package com;

import com.annotations.BenchMark;
import com.annotations.Main;
import com.annotations.Measurement;
import sun.dc.pr.PRError;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner {
    //默认配置
    private final int DEFAULT_ITERATIONS = 10;
    private final int DEFAULT_GROUP = 5;
    //封装一个存放case类的集合
    private final List<Case> cases;
    public CaseRunner(List<Case> cases) {
        this.cases = cases;
    }
    //运行每一个case类
    public void run() throws InvocationTargetException, IllegalAccessException {
        for (Case bCase : cases) {
            int iterations = DEFAULT_ITERATIONS;
            int group = DEFAULT_GROUP;

            //先获取类级别的配置
            Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
            if (classMeasurement != null) {
                iterations = classMeasurement.iterations();
                group = classMeasurement.group();
            }


            for (Case bcase : cases) {
                //找到对象中哪些方法是需要测试的方法
                Method[] methods = bcase.getClass().getMethods();
                for (Method method : methods) {
                    BenchMark benchMark = method.getAnnotation(BenchMark.class);
                    if (benchMark == null) {
                        continue;
                    }
                    //取得方法是否有Measurement注解，如果有取得配置
                    Measurement methodMeasurement = method.getAnnotation(Measurement.class);
                    if (methodMeasurement != null) {
                        iterations = methodMeasurement.iterations();
                        group = methodMeasurement.group();
                    }
                    //将方法，类以及配置送入runCase中运行
                    runCase(bcase,method,iterations,group);
                }
            }
        }

    }

    //TODO:没有预热
    private void runCase(Case bCase,Method method,int intetations,int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(bCase.getClass().getName());
        for (int i = 0;i < group;i++) {
            System.out.println();
            long t1 = System.nanoTime();
            for (int j = 0;j < intetations;j++) {
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.println("第"+i+"组实验耗时"+(t2-t1)+"ms");
        }
    }
}
//Case加载
public class CaseLoader {
    public static CaseRunner load() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String pkg = "com.cases"; //包名称
        //一个存放类名称的链表
        List<String> classNameList = new ArrayList<String>();
        //1.根据一个固定的类找到类加载器
        //2.根据加载器找到类文件所在路径
        //3.扫描路径下所有类文件
        ClassLoader classLoader = Main.class.getClassLoader();
        Enumeration<URL> urls = classLoader.getResources("com/cases");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (!url.getProtocol().equals("file")) {
                //TODO:实现如何从jar包中提取文件
                continue;
            }
            //URL解码
            String dirName = URLDecoder.decode(url.getPath(),"UTF-8");
            File dir = new File(dirName);
            if (!dir.isDirectory()) {
                //不是目录
                continue;
            }
            //扫描该目录下所有*.class文件，作为类文件
            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }
            //TODO:没有判断是否是*.class文件
            for (File file : files) {
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.length()-6);
                classNameList.add(className);
            }
        }
        //得到一个个实例
        List<Case> caseList = new ArrayList<Case>();
        for (String className : classNameList){
            Class<?> cls = Class.forName(pkg+"."+className);
            if (hasInterface(cls,Case.class)) {
                caseList.add((Case)cls.newInstance());
            }
        }
        return new CaseRunner(caseList);


    }
    //判断是否是要测试的类
    private static boolean hasInterface(Class<?> cls, Class<?> classInterface) {
        Class<?>[] classInterfaces = cls.getInterfaces();
        for (Class<?> i : classInterfaces) {
            if (i == classInterface) {
                return true;
            }
        }
        return false;
    }
}
