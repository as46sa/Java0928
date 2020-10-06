<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<%@ include file="/pages/common/head.jsp" %>
	</head>
	<script type="text/javascript">
		$(function () {
			// 给删除的a 标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				// 在事件的function 函数中，有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象。
				/**
				 * confirm 是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个是取消。
				 * 返回true 表示点击了，确认，返回false 表示点击取消。
				 */
				return confirm("你确定要删除 【" + $(this).parent().parent().find("td:first").text() + "】?");
				// return false// 阻止元素的默认行为===不提交请求
			});
		});
	</script>
	<body>
		<% %>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">商品管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>

		<div id="main">
			<table>
				<tr>
					<td>名称</td>
					<td>价格</td>
					<td>品牌</td>
					<td>销量</td>
					<td>库存</td>
					<td colspan="2">操作</td>
				</tr>
			<c:forEach items="${requestScope.page.items}" var="good">
				<tr>
					<td>${good.name}</td>
					<td>${good.price}</td>
					<td>${good.producer}</td>
					<td>${good.sales}</td>
					<td>${good.stock}</td>
					<td><a href="GoodsServlet?action=getGoods&id=${good.id}&&pageNo=${requestScope.page.pageNo}" >修改</a></td>
					<td><a class="deleteClass" href="GoodsServlet?action=delete&id=${good.id}">删除</a></td>
				</tr>
			</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="pages/manager/goods_edit.jsp">添加商品</a></td>
				</tr>
			</table>
			<%@include file="/pages/common/page_nav.jsp" %>
		</div>

		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>
