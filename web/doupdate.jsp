<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/26
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%!
    public static final String DBDRIVER="com.mysql.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/Lab";
    public static final String DBUSER="root";
    public static final String DBPASS="123456";
%>
<%
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet set=null;
%>
<%
    try {
        Class.forName(DBDRIVER);
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        String sql_doupdate="select * from lab WHERE lab_id='"+id+"'";
        pst=conn.prepareStatement(sql_doupdate);
        set= pst.executeQuery();
        if(set.next()){
%>
<form action="update.jsp?id=<%=set.getInt("lab_id")%>" method="post">
    实验室名称：<input type="text" value="<%=set.getString("lab_name1")%>" name="name"></input>
    地址：<input type="text" value="<%=set.getString("lab_address")%>" name="address"></input>
    <input type="submit" value="提交"></input>
</form>
<%
            set.close();
            pst.close();
            conn.close();
        }
        else{
            out.println("没有找到该用户");
        }

    }
    catch (Exception e){
        out.println(e);
    }
%>
</body>
</html>
