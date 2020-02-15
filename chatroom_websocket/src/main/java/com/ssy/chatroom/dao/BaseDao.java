package com.ssy.chatroom.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ssy.chatroom.utils.CommUtils;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装基础操作：数据源，获取链接，关闭资源
 */
public class BaseDao {
    private static DruidDataSource dataSource;
    static {
        Properties properties = CommUtils.loadProperties("datasource.properties");
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("加载数据源失败");
            e.printStackTrace();
        }
    }

    //获取链接(权限设置为protected，只能子类使用)
    protected static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("获取链接失败");
            e.printStackTrace();
        }
        return null;
    }

    //关闭资源
    protected static void closeSources(Connection connection,Statement statement) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected static void closeSources(Connection connection, Statement statement, ResultSet resultSet) {
        closeSources(connection,statement);
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
