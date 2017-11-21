<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/29
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约教室</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
</head>
<body>
<div style="width: 20%;float: left">
    <ul class="nav nav-pills nav-stacked" >
        <li role="presentation" ><a href="#">首页</a></li>
        <li role="presentation" class="active"><a href="selectLab.jsp">查看预约</a></li>
        <li role="presentation"><a href="anpai.jsp">预约课程</a></li>
        <li role="presentation"><a href="teacherCourse.jsp">我的课程</a></li>
        <li role="presentation"><a href="seachStyle.jsp">特殊查询</a></li>
    </ul>
</div>
<div style="width: 70%;float: left">
    <form method="post" action="servlet/search">
  <div class="form-group">
    <div class="col-sm-3">
        <select name="type" class="form-control">
            <option value="1">教师编号</option>
            <option value="2">学生学号</option>
            <option value="3">时间</option>
            <option value="4">实验室编号</option>
        </select>
    </div>

</div>
        <div class="col-sm-3">
        <input type="text" name="haha" value="" class="form-control">
        </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-5">
            <button type="submit" class="btn btn-default">查询</button>
        </div>
    </div>
    </form>

</div>

</body>
</html>
