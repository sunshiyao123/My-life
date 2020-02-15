package com.ssy.chatroom.dao;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.ssy.chatroom.eneity.User;
import com.ssy.chatroom.utils.CommUtils;
import com.ssy.chatroom.utils.JDBCUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

/**
 * 关于用户模块的dao层
 */
public class AccountDao extends BaseDao {
    //用户登录 select
    public User userLogin(String userName,String password) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = getConnection();
            String sql = "select * from user " +
                    "where userName = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            resultSet = statement.executeQuery();
            //resultSet为表头，只有resultSet.next()才下移一行
            if (resultSet.next()) {
                user = getUserInfo(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("查询用户信息出错");
        } finally {
            closeSources(connection,statement,resultSet);
        }
        return user;
    }



    //用户注册 insert
    public boolean userRegister(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String sql = "INSERT INTO user (username,password) VALUES (?,?)";
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            if (statement.executeUpdate() == 1)
                isSuccess = true;
        } catch (SQLException e) {
            System.err.println("用户注册失败");
            e.printStackTrace();
        } finally {
            closeSources(connection,statement);
        }
        return isSuccess;
    }

    //将数据表信息封装到User类中
    public User getUserInfo(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
