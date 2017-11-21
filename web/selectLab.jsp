<%@ page import="java.util.List" %>
<%@ page import="com.bean.Lab" %>
<%@ page import="com.dao.TeacherDao" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/26
  Time: 9:01
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
<div style="width:70% ;float: left">
<%List<Lab> list= new TeacherDao().selectLab();
%>
    <table  class="table table-hover">
        <tr>
            <th>实验室编号</th>
            <th>实验室地点</th>
            <th>实验名字</th>
            <th>预约时间</th>
        </tr>
        <%  for (Lab lab:list){%>
            <tr>
                <td><%=lab.getId()%></td>
                <td><%=lab.getAddress()%></td>
                <td><%=lab.getName()%></td>
                <td><%=lab.getDate()+"   "+lab.accountDate(lab.getTab())%></td>
            </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>
