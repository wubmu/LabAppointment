<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/25
  Time: 17:18
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
      <li role="presentation"><a href="selectLab.jsp">查看预约</a></li>
      <li role="presentation"><a href="anpai.jsp">预约课程</a></li>
      <li role="presentation"><a href="teacherCourse.jsp">我的课程</a></li>
    </ul>
  </div>
  </body>
  <form action="servlet/logout" method="post">
    <div class="form-control">
      <input type="button" value="注销">
    </div>
  </form>
</html>
