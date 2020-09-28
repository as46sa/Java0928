package com.shop.service;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    User user = new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3成功");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userDao.queryUserByUsername(username).size()>0){
            user.setUsername(username);
            user.setPassword(password);
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }else{


            req.getSession().setAttribute("username",username);
            userDao.saveUser(user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
