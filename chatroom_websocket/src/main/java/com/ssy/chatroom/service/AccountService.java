package com.ssy.chatroom.service;

import com.ssy.chatroom.dao.AccountDao;
import com.ssy.chatroom.eneity.User;

import java.sql.SQLException;

public class AccountService {
    private AccountDao accountDao = new AccountDao();
    //用户登陆
    public boolean userLogin(String userName,String password) throws SQLException {
        User user = accountDao.userLogin(userName,password);
        if (user == null) {
            return false;
        }
        return true;
    }
    //用户注册
    public boolean userRegister(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return accountDao.userRegister(user);

    }
}
