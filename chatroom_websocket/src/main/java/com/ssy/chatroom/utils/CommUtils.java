package com.ssy.chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 封装了基础的工具方法，如加载的配置文件，json序列化等
 */
public class CommUtils {

    private static final Gson gson = new GsonBuilder().create();
    //Object对象转换为Json字符串
    public static String ObjectToJson(Object obj) {
        return gson.toJson(obj);
    }
    //Json字符串转换为Object对象
    public static Object JsonToObject(String jsonStr,Class objClass) {
        return gson.fromJson(jsonStr,objClass);
    }

    private CommUtils(){}

    /**
     * 根据文件名加载配置文件
     * @param fileName  配置文件名
     * @return
     */
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        /**
         * 获取当前配置文件夹下的文件输入流
         * getResourceAsStream():获取当前类加载器下所有同目录资源文件(resource文件)
         */
        InputStream in = CommUtils.class.getClassLoader().
                getResourceAsStream(fileName);
        /**
         * 加载配置文件中的所有内容
         * properties.load():加载输入流中所有内容
         */
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    //判断字符串是否为空
    public static boolean strIsNull(String str) {
        //先写str == null,如果str为空str.equals()报空指针异常
        return str == null || str.equals("");
    }


}
