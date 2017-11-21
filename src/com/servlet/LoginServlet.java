package com.servlet;

import com.bean.Student;
import com.bean.Teacher;
import com.dao.StudentDao;
import com.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/6/28.
 */
@WebServlet(name = "LoginServlet" ,urlPatterns = "/servlet/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String type=request.getParameter("type");
        System.out.println(username+"        "+password+"           "+type);
        if (type.equals("学生")) {
            StudentDao dao = new StudentDao();
            Student student = dao.login(username, password);
            if (student.getStudent_id() != null) {
                request.getSession().setAttribute("student", student);
                response.sendRedirect("../StudentIndex.jsp");
            }
        }
        if (type.equals("教师")){
            TeacherDao dao = new TeacherDao();
            Teacher t=dao.login(username,password);
            System.out.println(t+password+"         "+username);
            if(t.getName()!=null) {
                request.getSession().setAttribute("teacher", t);
                System.out.println(t.toString());
                response.sendRedirect("../index.jsp");
                System.out.println(123);
            }
        }
        if (type.equals("管理员")){

        response.sendRedirect("../AdminIndex.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
