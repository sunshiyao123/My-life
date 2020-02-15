package com.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //表示保存的时期为运行时期
@Target({ElementType.TYPE,ElementType.METHOD})//表示只能修饰类，接口，枚举
public @interface Measurement {
    //一组实验调用方法多少次，如果调用时未设置，则默认3
    int iterations() default 3;

    //一共进行多少组实验
    int group();
}


