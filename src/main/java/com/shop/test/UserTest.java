package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    User user = new User();
    @Test
    public void test1(){
        UserDao user1 = new UserDaoImpl();
        user.setUsername("admin");
        user.setPassword("123");
        user.setEmail("hhh@qq.com");
        user1.saveUser(user);
    }
}
