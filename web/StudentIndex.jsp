<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/28
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
    <title>实验室预约管理系统</title>
</head>
<body>
<div style="width: 20%">
    <ul class="nav nav-pills nav-stacked" >
        <li role="presentation" class="active"><a href="#">首页</a></li>
        <li role="presentation"><a href="information.jsp">预约课程</a></li>
        <li role="presentation"><a href="StudentCourse.jsp">已预约课程</a></li>
        <li role="presentation"><a href="seachStyle.jsp">特殊查询</a></li>
    </ul>
</div>
<form action="servlet/logout" method="post">
    <div class="form-control">
        <input type="button" value="注销">
    </div>
</form>
</body>
</html>
