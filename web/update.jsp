<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/26
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    public static final String DBDRIVER="com.mysql.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/Lab";
    public static final String DBUSER="root";
    public static final String DBPASS="123456";
%>
<%
    request.setCharacterEncoding("utf-8");
    String name=request.getParameter("name");
    String address=request.getParameter("address");
    String id=request.getParameter("id");
    System.out.println(id+" "+name+" "+address+" ");
    try{
        Class.forName(DBDRIVER);
        Connection conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        String sql_modify="update lab set lab_name1='"+name+"',lab_address='"+address+"'WHERE lab_id='"+id+"'" ;
        PreparedStatement pst=conn.prepareStatement(sql_modify);
        int row=pst.executeUpdate();
        if(row!=0){
            out.println("修改成功");
            response.setHeader("refresh","3;URL=select.jsp");
        }
        else{
            out.println("修改失败");
            response.setHeader("refresh","3;URL=select.jsp");
        }
        pst.close();
        conn.close();
    }
    catch (Exception e){
        out.println(e);
    }
%>
</body>
</html>
