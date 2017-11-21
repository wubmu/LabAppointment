<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/25
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加</title>
</head>
<body>
    <form action="doinsert.jsp" method="post">
        名称： <input type="text" name="name" value="">
        地址：<input type="text" name="address"  value="">
        编号：<input type="text" name="id"  value="">
        <input type="submit" value="添加">
    </form>
</body>
</html>
