package com.servlet;

import com.bean.Student;
import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/6/28.
 */
@WebServlet(name = "RevenServlet",urlPatterns = "/servlet/reven")
public class RevenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StudentDao dao=new StudentDao();
        Student s= (Student) request.getSession().getAttribute("student");
        String student_id=s.getStudent_id();
        String course_id=request.getParameter("course_id");
        dao.reserve(course_id,student_id);
        response.sendRedirect("../StudentCourse.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
