package com.shop.controller;


import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends HttpServlet {
    private  UserDao userDao = new UserDaoImpl();
    private  User user = new User();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            login(req, resp);
        } else if ("regist".equals(action)) {
            regist(req, resp);
        }
        else if ("logout".equals(action)) {
            logout(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userDao.queryUserByUsernameAndPassword(username, password).size() > 0) {
                user.setUsername(username);
                user.setPassword(password);
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            } else {
                resp.setContentType("text/html; charset=UTF-8");
                req.setAttribute("msg", "用户或密码错误！");
                req.getSession().setAttribute("username", username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }
        }else{
                req.setAttribute("username", username);
                req.setAttribute("pwd", password);
                req.setAttribute("msg", "验证码错误");
                req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            }
    }


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userDao.queryUserByUsername(username).size() > 0) {
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userDao.saveUser(new User(username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//       1、销毁Session 中用户登录的信息 （或者销毁Session）
        req.getSession().invalidate();
//       2、重定向到首页 （或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }
}

