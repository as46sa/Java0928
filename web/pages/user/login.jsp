<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
	<head>
		<meta charset="UTF-8">
		<%@ include file="/pages/common/head.jsp" %>
	</head>

	<script type="text/javascript">
		$(function () {

			$("#sub_btn").click(function () {

				var usernameText = $("#username").val();
				usernameText = $.trim(usernameText);
				if(usernameText == '' || usernameText == null){
					$("span.errorMsg").text("用户名为空");

					return false;
				}

				var passwordText = $("#password").val();
				passwordText = $.trim(passwordText);
				if(passwordText == '' || passwordText == null ){
					console.log("1");
					$("span.errorMsg").text("密码为空");
					return false;
				}
				$("span.errorMsg").text("");
			});
			$("#code_img").click(function () {
				// 在事件响应的function 函数中有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象
				// src 属性表示验证码 img 标签的 图片路径。它可读，可写
				// alert(this.src);
				this.src = "${basePath}Kaptcha.jpg?d=" + new Date();
			});
		});
	</script>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
		</div>

		<div class="login_banner">

			<div id="l_content">
				<span class="login_word">欢迎登录</span>
			</div>

			<div id="content">
				<div class="login_form">
					<div class="login_box">
						<div class="tit">
							<h1>网上商城会员</h1>
							<a href="pages/user/regist.jsp">立即注册</a>
						</div>
						<div class="msg_cont">
							<b></b>
							<span class="errorMsg">
								${ empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
							</span>
						</div>
						<div class="form">
							<form action="UserServlet" method="post">
								<input type="hidden" name="action" value="login"/>
								<label>用户名称：</label>
								<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
								<br />
								<br />
								<label>用户密码：</label>
								<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" value="${requestScope.pwd}"/>
								<br />
								<br />
								<label>验证码：</label>
								<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
								<img style="width:70px;height:25px" alt=""
									 src="http://localhost:8080/Shop_war/Kaptcha.jpg"
									 style="float: right; margin-right: 40px" id="code_img">
								<br />
								<br />
								<a href="login.jsp"></a>
								<input type="submit" value="登录" id="sub_btn" />
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>
