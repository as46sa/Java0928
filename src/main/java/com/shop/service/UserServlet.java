package com.shop.service;


import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    User user = new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if(userDao.queryUserByUsername(username).size()>0){
            return;

        }else{
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            req.getSession().setAttribute("username",username);
            userDao.saveUser(user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
