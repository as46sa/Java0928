<%--
  Created by IntelliJ IDEA.
  User: 17710
  Date: 2020/9/30
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临网上商城</span>
    <a href="pages/cart/cart.jsp" >购物车</a>
    <a href="order/order.jsp">我的订单</a>
    <a href="UserServlet?action=logout">注销</a> &nbsp;&nbsp;
    <a href="ClientGoodsServlet?action=page">返回</a>
</div>
</body>
</html>
