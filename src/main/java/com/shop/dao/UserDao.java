package com.shop.dao;

import com.shop.bean.User;

import java.util.List;

public interface UserDao {
    List<User> queryUserByUsername(String username);

    List<User> queryUserByUsernameAndPassword(String username, String password);

    int saveUser(User uesr);
}
