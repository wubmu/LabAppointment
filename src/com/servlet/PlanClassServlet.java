package com.servlet;

import com.bean.Information;
import com.bean.Teacher;
import com.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 吴亚斌 on 2017/6/26.
 */
@WebServlet(name = "PlanClassServlet",urlPatterns = "/servlet/planClass")
public class PlanClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");

        String date1=request.getParameter("date1");
        String date2=request.getParameter("date2");
        String lab_id=request.getParameter("address");
        Teacher t= (Teacher) request.getSession().getAttribute("teacher");
        System.out.println(t.toString());
        int num=Integer.valueOf(request.getParameter("num"));

        Information i=new Information();
        i.setId(lab_id);
        i.setDate(date1);
        i.setTeacher_id(t.getId());
        i.setTab(date2);
        i.setNum(num);
        i.setName(name);
        int x= (int) (Math.random()*10000);
        i.setCourse_id(String.valueOf(x));
        TeacherDao dao=new TeacherDao();
        dao.insertInfor(i);
        System.out.println(i.toString());
        response.sendRedirect("../selectLab.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
