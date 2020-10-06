package com.shop.service.impl;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public List<User> queryUserByUsernameAndPassword(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username,password);
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
