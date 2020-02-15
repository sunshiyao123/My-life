package com;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

public class Main {
    /**
     * 目标：找到com.cases下的所有类
     * 转换：能找到存放com.cases的目录，扫描这个目录下的所有*.class文件
     *
     * 1.如何找到目录
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.找目录
        //通过Main的类加载器找到路径
        ClassLoader classLoader = Main.class.getClassLoader();
        Enumeration<URL> urls = classLoader.getResources("com/cases");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            //System.out.println(URLDecoder.decode(url.getPath(),"UTF-8"));

            //我们只能处理*.class文件的情况，无法处理成jar包的情况
            File dir = new File(URLDecoder.decode(url.getPath(),"UTF-8"));
            if (!dir.isDirectory()) {
                continue;
            }
            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }
            for (File file : files) {
                //取出文件名，xxx.class 再删除后面6个字符得到class名字
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.length()-6);
                System.out.println(className);

                Class<?> cls = Class.forName("com.cases."+className);

                //利用class接口找出我们需要的class
                //两种方法
                //1.利用if(实例化对象 instanceof 接口)
                if (cls.newInstance() instanceof Case) {
                    System.out.println("实现了接口");
                } else {
                    System.out.println("没有实现接口");
                }
                //2.把所有类的接口取出来，再与接口名称对比
                Class<?>[] interfaces = cls.getInterfaces();
                for (Class<?> interface1 : interfaces) {
                    if (interface1 == Case.class) {
                        System.out.println("实现了接口");
                    } else {
                        System.out.println("没有实现接口");
                    }
                }
            }
        }
    }
}
