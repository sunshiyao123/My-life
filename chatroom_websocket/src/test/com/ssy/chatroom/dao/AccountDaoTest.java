package com.ssy.chatroom.dao;

import com.ssy.chatroom.eneity.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    @Test
    public void userLogin() {
        try {
            User user = accountDao.userLogin("666","666");
            System.out.println(user.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userRegister() {
        User user = new User();
        user.setUserName("666");
        user.setPassword("666");
        boolean isSucceed = accountDao.userRegister(user);
        Assert.assertEquals(true,isSucceed);
    }
}