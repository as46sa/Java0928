<%--
  Created by IntelliJ IDEA.
  User: 17710
  Date: 2020/9/30
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<!--写base 标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<script src="static/js/jquery-1.11.3.min.js"></script>
<script src="static/js/bootstrap.js"></script>
