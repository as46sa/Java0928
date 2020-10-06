<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
	<head>
		<meta charset="UTF-8">
		<%@ include file="/pages/common/head.jsp" %>
		<style type="text/css">
			h1 {
				text-align: center;
				margin-top: 200px;
			}
		</style>
	</head>
	<body>

		<div id="header">
			<base href="<%=basePath%>">
			<img class="logo_img" alt="" src="static/i	mg/logo.gif">
			<span class="wel_word">结算</span>
			<div>
				<span>欢迎<span class="um_span">用户</span>光临网上商城</span>
				<a href="order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
		</div>

		<div id="main">

			<h1>你的订单已结算，订单号为2937474382928484747</h1>


		</div>

		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>
