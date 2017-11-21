package com.servlet;

import com.bean.Information;
import com.dao.SelectDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/6/29.
 */
@WebServlet(name = "searchServlet",urlPatterns = "/servlet/search")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String type=request.getParameter("type");
        String value=request.getParameter("haha");
        System.out.println(type+"         "+value+request.getParameter("haha")+value);
        if (type.equals("1")){
            TeacherDao dao=new TeacherDao();
            List<Information> list=dao.TeacherCourse(value);
            System.out.println(1);
            if (list!=null){
                System.out.println(1.1);
                request.getSession().setAttribute("search",list);
                System.out.println(1.11);
                response.setHeader("refresh","0;URL=../doSearchStyle.jsp");
            }
            else {
                System.out.println(1.2);
                response.getWriter().write("用户信息不存在");
                response.setHeader("refresh","2;URL=../SearchStyle.jsp");
            }
        }
        if (type.equals("2")){
            StudentDao dao=new StudentDao();
            List<Information> list=dao.StudentCourse(value);
            if (list!=null){
                request.getSession().setAttribute("search",list);
                response.setHeader("refresh","0;URL=../doSearchStyle.jsp");
            }
            else {
                response.getWriter().write("用户信息不存在");
                response.setHeader("refresh","2;URL=../SearchStyle.jsp");
            }
        }
        if (type.equals("3")){
            SelectDao dao=new SelectDao();
            List<Information> list=dao.DateCourse(value);
            if (list!=null){
                request.getSession().setAttribute("search",list);
                response.setHeader("refresh","0;URL=../doSearchStyle.jsp");
            }
            else {
                response.getWriter().write("用户信息不存在");
                response.setHeader("refresh","2;URL=../SearchStyle.jsp");
            }

        }
        if (type.equals("4")){
            SelectDao dao=new SelectDao();
            List<Information> list=dao.LabCourse(value);
            if (list!=null){
                request.getSession().setAttribute("search",list);
            }
            else {
                response.getWriter().write("用户信息不存在");
                response.setHeader("refresh","2;URL=../doSearchStyle.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
