package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> queryUserByUsername(String username) {
        String sql = "SELECT * FROM User WHERE username = ?";
        return queryForList(User.class,sql,username);
    }

    @Override
    public List<User> queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM User WHERE username = ? AND password=?";
        return queryForList(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `User` (`username`, `password`, `email`) VALUES (?, ?, ?) ";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
