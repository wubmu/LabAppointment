<%@ page import="com.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/28
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
成功
<%
   Student s = (Student) request.getSession().getAttribute("student");
    System.out.println(s.toString());
%>
</body>
</html>
