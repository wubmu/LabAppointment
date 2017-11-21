<%@ page import="com.bean.Teacher" %>
<%@ page import="com.dao.TeacherDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Information" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/26
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安排课程</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
</head>
<body>
<div style="width: 20%;float: left">
    <ul class="nav nav-pills nav-stacked" >
        <li role="presentation" ><a href="#">首页</a></li>
        <li role="presentation" ><a href="selectLab.jsp">查看预约</a></li>
        <li role="presentation"  class="active"><a href="anpai.jsp">预约课程</a></li>
        <li role="presentation"><a href="teacherCourse.jsp">我的课程</a></li>
        <li role="presentation"><a href="seachStyle.jsp">特殊查询</a></li>
    </ul>
</div>

<div style="width:70% ;float: left">
    <form action="servlet/planClass" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">实验名称</label>
            <div class="col-sm-5">
            <input type="text" name="name" id="inputEmail3" class="form-control" placeholder="实验名称">
            </div>
        </div>
            <br>
        <div class="form-group">
            <label  class="col-sm-2 control-label">实验地点</label>

            <div class="col-sm-5">
                <select name="address" class="form-control">
                    <%TeacherDao dao=new TeacherDao();
                        List<Information> list =dao.selectLabname();
                        for (Information  labname:list){
                            System.out.println(labname.toString());
                    %>
                    <option value="<%=labname.getId()%>"><%=labname.getName()%></option>

               <%}%>
                </select>
            </div>
        </div>
            <br>
            <div class="form-group">
                <label for="date1" class="col-sm-2 control-label"> 实验日期</label>
                <div class="col-sm-5">
                    <input type="text" name="date1" id="date1" class="form-control" placeholder="实验时间">
                </div>
            </div>
        <br>
        <div class="form-group">
            <label for="num" class="col-sm-2 control-label"> 课容量</label>
            <div class="col-sm-5">
                <input type="text" name="num" id="num" class="form-control" placeholder="课容量">
            </div>
        </div>
            <br>
        <div class="form-group">
            <label  class="col-sm-2 control-label">实验时段</label>
            <div class="col-sm-5">
                <select name="date2" class="form-control">
                    <option value="1">8：00-10：00</option>
                    <option value="2">10：00-12：00</option>
                    <option value="3">14：00-16：00</option>
                    <option value="4">16：00-18：00</option>
                    <option value="5">19：00-21：00</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">预约</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
