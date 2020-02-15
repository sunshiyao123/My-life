package com;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {
//        CaseLoader loader = new CaseLoader();
//        loader.load().run();

        Random random = new Random();
        System.out.println(random.nextInt(100000));
    }
}
