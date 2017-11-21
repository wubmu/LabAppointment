<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/25
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
<%!
    public static final String DBRIVER="com.mysql.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/Lab";
    public static final String DBUSER="root";
    public static final String DBPASS="123456";
%>
<%  Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
%>
<%
    try{
        Class.forName(DBRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        String sql_insert = "select * from lab;";
        pst = conn.prepareStatement(sql_insert);
        rs = pst.executeQuery();
%>
<table border="1px"solid><tr><td>编号</td><td>名称</td><td>地址</td>
    <td colspan="2" align="center">操作</td>
</tr>
    <%
        while (rs.next()){
    %>
    <tr><td><%=rs.getInt("lab_id")%></td>
        <td><%=rs.getString("lab_name1")%></td>
        <td><%=rs.getString("lab_address")%></td>
        <td><a href="doupdate.jsp?id=<%=rs.getString("lab_id")%>"> 修改</a></td>
        <td><a href="delete.jsp?id=<%=rs.getString("lab_id")%>">删除</a> </td>
    </tr>
    <%}
    %>
</table>
<%
    }
    catch (Exception e){
        out.println(e);
    }
%>

</body>
</html>