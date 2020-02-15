package com.annotations;

import com.cases.StringConcatCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Measurement(iterations = 10,group = 5)
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //默认配置
        int iterations = 10;
        int group = 5;
        StringConcatCase object = new StringConcatCase();
        //通过反射获取类中定义的方法
        Class<?> cls = object.getClass();
        Method[] methods = cls.getMethods();
        //获取类的Measurement注解，然后判断是否有配置，如果有配置则设置为类配置
        Annotation annotationMeasurement = cls.getAnnotation(Measurement.class);
        if (annotationMeasurement != null) {
            Measurement measurement = (Measurement) annotationMeasurement;
            iterations = measurement.iterations();
            group = measurement.group();
        }
        for (Method method : methods) {
            //判断是否为要测试的方法
            Annotation annotationBenchMark = method.getAnnotation(BenchMark.class);
            if (annotationBenchMark == null) {
                continue;
            }
            int methodIterations = iterations;
            int methodGroup = group;
            System.out.println(method.getName());
            //获得方法上的Measurement配置，如果有则配置
            Annotation methodAnnotation = method.getAnnotation(Measurement.class);
            if (methodAnnotation != null) {
                Measurement methodMeasurement = (Measurement)methodAnnotation;
                methodIterations = methodMeasurement.iterations();
                methodGroup = methodMeasurement.group();
            }

            //调用
            for (int i = 0;i < methodGroup;i++) {
                long t1 = System.nanoTime();
                for (int j = 0;j < methodIterations;j++) {
                    method.invoke(object);
                }
                long t2 = System.nanoTime();
                System.out.println("第"+i+"次实验耗时"+(t2-t1)+"ms");
            }
        }

    }
}
