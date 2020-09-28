package com.shop.filter;

import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("username");
        UserDao userDao = new UserDaoImpl();

        if(userDao.queryUserByUsername(user+"").size() > 0){
            httpServletRequest.getRequestDispatcher("/pages/user/regist.html").forward(servletRequest, servletResponse);
            System.out.println("过滤成功1");
            return;
        }else{
            System.out.println("过滤成功2");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
