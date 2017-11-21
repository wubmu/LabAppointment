<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/25
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    public static final String DBRIVER="com.mysql.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/Lab";
    public static final String DBUSER="root";
    public static final String DBPASS="123456";
%>
<%
    Connection conn=null ;
    PreparedStatement pst=null;
    int rs=0;
    String id=null;
%>
<%try {
    Class.forName(DBRIVER);
    id=request.getParameter("id");
    conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);
    String sql_delete="delete from lab where lab_id='"+id+"'";
    pst=conn.prepareStatement(sql_delete);
    rs=pst.executeUpdate();
    if (rs==1){
        out.println("删除成功，5秒后跳转回显示页面");
        response.setHeader("refresh","5;URL=select.jsp");
    }
    else {
        System.out.println(id);
    }
}
catch (Exception e){
    out.println(e);
}
%>
</body>
</html>
