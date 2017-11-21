package com.servlet;

import com.bean.Lab;
import com.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/6/26.
 */
@WebServlet(name = "SelectLabServlet",urlPatterns = "/com/servlet/selectLab")
public class SelectLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TeacherDao dao=new TeacherDao();
        List<Lab> list =dao.selectLab();
        request.setAttribute("list",list);
        request.getRequestDispatcher("../selectLab.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
