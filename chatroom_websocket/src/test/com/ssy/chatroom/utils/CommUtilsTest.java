package com.ssy.chatroom.utils;

import com.ssy.chatroom.eneity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilsTest {

    @Test
    public void gsonTest() throws ClassNotFoundException {
        User user = new User();
        user.setId(10);
        user.setPassword("123");
        user.setUserName("sy");
        String jsonString = CommUtils.ObjectToJson(user);
        System.out.println(jsonString);
        User user1 = (User) CommUtils.JsonToObject(jsonString,User.class);
        System.out.println(user1);
    }


    @Test
    public void loadProperties() {
        String fileName = "db.properties";
        Properties properties = CommUtils.loadProperties(fileName);
        String url = properties.getProperty("url");
    }
}