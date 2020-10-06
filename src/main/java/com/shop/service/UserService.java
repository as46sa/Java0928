package com.shop.service;

import com.shop.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryUserByUsername(String username);

    List<User> queryUserByUsernameAndPassword(String username, String password);

    int saveUser(User user);
}
