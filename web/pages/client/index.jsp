<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城首页</title>
    <meta charset="UTF-8">
    <%@ include file="/pages/common/head.jsp" %>
</head>
<Script type="text/javascript">
    $(function () {
        // 给加入购物车按钮绑定单击事件

        $(".shop_add").click(function () {
            /**
             * 在事件响应的function 函数 中，有一个this 对象，这个this 对象，是当前正在响应事件的dom 对象
             * @type {jQuery}
             */
            var goodsId = $(this).attr("value");
            console.log(goodsId)
            location.href = "http://localhost:8080/Shop_war/CartServlet?action=addItem&id=" + goodsId;
        });
    });
</Script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>
<div id="main">
    <div id="shop">
        <div class="shop_cond">
            <form action="ClientGoodsServlet?action=pageByPrice" method="post">
                价格：<input id="min" type="text" name="min" value=""> 元 -
                <input id="max" type="text" name="max" value=""> 元
                <button  type="submit" class="btn btn-group-lg btn-primary" >查询</button>
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <%--购物车为空的输出--%>
                <span> </span>
                <div>
                    <span style="color: red">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <%--购物车非空的输出--%>
                <span>您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>
        <c:forEach items="${requestScope.page.items}" var="good">
            <div class="b_list">
                <div class="img_div">
                    <img class="shop_img" alt="" src="static/img/default.jpg"/>
                </div>
                <div class="shop_info">
                    <div class="shop_name">
                        <span class="sp1">商品名:</span>
                        <span class="sp2">${good.name}</span>
                    </div>
                    <div class="shop_author">
                        <span class="sp1">品牌:</span>
                        <span class="sp2">${good.producer}</span>
                    </div>
                    <div class="shop_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${good.price}</span>
                    </div>
                    <div class="shop_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${good.sales}</span>
                    </div>
                    <div class="shop_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${good.stock}</span>
                    </div>
                    <div class="shop_add" value="${good.id}">
                        <button class="btn btn-sm btn-info" >加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<div id="bottom">
			<span>
				网上商城.Copyright &copy;2020
			</span>
</div>
</body>
</html>
