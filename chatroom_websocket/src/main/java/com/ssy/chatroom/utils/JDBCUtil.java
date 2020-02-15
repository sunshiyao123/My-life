package com.ssy.chatroom.utils;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Properties;

/**
 * 封装JDBC操作的公共方法
 */
public class JDBCUtil {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String password;
    //使用静态代码块，这样在加载类时直接加载并且只加载一次
    static {
        //调用自己写的loadProperties()方法加载资源文件
        Properties properties = CommUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");
        //加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("加载数据库驱动出错");
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            System.err.println("获取数据库连接出错");
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库资源：Connection   Statement   ResultSet
    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeResources(connection,statement);
    }
    public static void closeResources(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
