<%@ page import="com.dao.StudentDao" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Information" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/28
  Time: 19:47
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
<div style="width: 20%;float: left">
    <ul class="nav nav-pills nav-stacked" >
        <li role="presentation" ><a href="#">首页</a></li>
        <li role="presentation" ><a href="information.jsp">预约课程</a></li>
        <li role="presentation" class="active"><a href="StudentCourse.jsp">我的课程</a></li>
        <li role="presentation"><a href="seachStyle.jsp">特殊查询</a></li>
    </ul>
</div>
<%
    Student s= (Student) request.getSession().getAttribute("student");
    StudentDao dao =new StudentDao();

    List<Information> list=dao.StudentCourse(s.getStudent_id());
    for (Information i:list){
        System.out.println(i.toString());
    }
%>
<div style="width:70% ;float: left">
    <table  class="table table-hover">
        <caption>以下是你即将要上的课程</caption>
        <tr>
            <th>实验室编号</th>
            <th>实验室地点</th>
            <th>实验名称</th>
            <th>实验时间</th>
            <th>实验老师</th>
        </tr>
        <%  for (Information lab:list){
            System.out.printf(lab.toString());%>
        <tr>
            <td><%=lab.getId()%></td>
            <td><%=lab.getAddress()%></td>
            <td><%=lab.getName()%></td>
            <td><%=lab.getDate()+"   "+lab.accountDate(lab.getTab())%></td>
            <td><%=lab.getTeachet_name()%></td>
        </tr>
        <%
            }
        %>
    </table>

</div>

</body>
</html>
