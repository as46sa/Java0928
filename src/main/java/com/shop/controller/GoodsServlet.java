package com.shop.controller;

import com.shop.bean.Goods;
import com.shop.bean.Page;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import com.shop.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("list".equals(action)){
            list(req, resp);
        }else if("add".equals(action)){
            add(req, resp);
        }
        else if("delete".equals(action)){
            delete(req, resp);
        }else if("getGoods".equals(action)){
            getGoods(req, resp);
        }else if("update".equals(action)){
            update(req, resp);
        }
        else if("page".equals(action)){
            page(req, resp);
        }
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //1 GoodsService 查询全部商品
        List<Goods> goods = goodsService.queryGoods();
        //2 把全部商品保存到Request 域中
        req.setAttribute("goods", goods);
        //3、请求转发到/pages/manager/goods_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Goods goods = WebUtils.copyParamToBean(req.getParameterMap(), new Goods());
//       2、goodsService.addGoods()保存商品
        goodsService.addGoods(goods);
//       3、跳到商品列表页面
//             /manager/GoodsServlet?action=list
//       req.getRequestDispatcher("/manager/GoodsServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/GoodsServlet?action=page");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//        1、获取请求的参数 id，商品编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        2、goodsService.deleteGoodsById();删除商品
        goodsService.deleteGoodsById(id);
//        3、重定向回商品列表管理页面
        resp.sendRedirect(req.getContextPath() + "/GoodsServlet?action=page");
    }

    protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //1 获取请求的参数商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2 调用goodsService.queryGoodsById 查询商品
        Goods goods = goodsService.queryGoodsById(id);
        //3 保存到商品到Request 域中
        req.setAttribute("goods", goods) ;
        //4 请求转发到。pages/manager/goods_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/goods_edit.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//       1、获取请求的参数==封装成为Goods 对象
        Goods goods = WebUtils.copyParamToBean(req.getParameterMap(), new Goods());
//       2、调用GoodsService.updateGoods(goods);修改goods
        goodsService.updateGoods(goods);
//       3、重定向回goods列表管理页面
//       地址：/工程名/manager/GoodsServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/GoodsServlet?action=page");
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用GoodsService.page(pageNo，pageSize)：Page 对象
        Page<Goods> page = goodsService.page(pageNo,pageSize);
        page.setUrl("GoodsServlet?action=page");
        //3 保存Page 对象到Request 域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/goods_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req,resp);
    }
}
