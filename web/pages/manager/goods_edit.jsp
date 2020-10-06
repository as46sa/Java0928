<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<%@ include file="/pages/common/head.jsp" %>
		<style type="text/css">
			h1 {
				text-align: center;
				margin-top: 200px;
			}

			h1 a {
				color: red;
			}

			input {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">编辑商品</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>

		<div id="main">
			<form action="GoodsServlet" method="get">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${empty param.id?"add" :"update"}"/>
				<input type="hidden" name="id" value="${requestScope.goods.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>品牌</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="name" type="text" value="${requestScope.goods.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.goods.price}"/></td>
						<td><input name="producer" type="text" value="${requestScope.goods.producer}"/></td>
						<td><input name="sales" type="text" value="${requestScope.goods.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.goods.stock}"/></td>
						<td><input type="submit" value="提交" /></td>
					</tr>
				</table>
			</form>


		</div>

		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>
