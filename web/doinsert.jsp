<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%--
  Create by IntelliJ IDEA.
  User: dell
  Date: 2017/6/25
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    public static final String DBRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/Lab?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";
%>
<%
    String id = null;
    String name = null;
    String address = null;
    Connection conn = null;
    int rs = 0;
%>
<%
    try {
        Class.forName(DBRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);//连接数据库
        request.setCharacterEncoding("utf-8");
        id = request.getParameter("id");
        name = request.getParameter("name");
        address = request.getParameter("address");
        String sql_insert = "INSERT INTO lab (lab_id, lab_name1, lab_address) VALUES  (?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql_insert);
        pst.setInt(1, Integer.parseInt(id));
        pst.setString(2,name);
        pst.setString(3,address);
        rs = pst.executeUpdate();
        if (rs != 0) {
%>

<%
            response.setHeader("refresh", "1;URL=AdminIndex.jsp");
        } else {
            out.println("失败");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
