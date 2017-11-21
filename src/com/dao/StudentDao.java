package com.dao;


import com.bean.Information;
import com.bean.Student;
import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenna on 2017/6/25.
 */
public class StudentDao {
    public List<Information> SelectInformation() {
        List<Information> list = new ArrayList<Information>();
        try {
            ResultSet rs = null;
            Connection conn = JdbcUtil.getConnection();
            String sql_select = "select * from lab.information,lab.lab,lab.teacher WHERE information.lab_id=lab.lab_id AND information.teacher_id=teacher.teacher_id";
            PreparedStatement pst = conn.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                Information inf = new Information();
                inf.setId(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setNum(rs.getInt(3));
                inf.setTeacher_id(rs.getString(4));
                inf.setTab(rs.getString(5));
                inf.setDate(rs.getString(6));
                inf.setCourse_id(rs.getString(7));
                inf.setTeachet_name(rs.getString("teacher_name"));
                inf.setAddress(rs.getString("lab_address"));
                list.add(inf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int reserve(String course_id,String student_id){
        int rs=0;
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "INSERT INTO sc VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student_id);
            ps.setString(2,course_id);
            rs=ps.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public Student login(String student_id,String password){
        Student s =new Student();
        Connection conn=JdbcUtil.getConnection();
        try {
            String sql="SELECT * FROM  student WHERE student_id=? AND student_password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student_id);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
               s.setStudent_id(rs.getString(1));
               s.setStudent_name(rs.getString(2));

            }
          ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;

    }


        public List<Information> StudentCourse(String sno) {
        List<Information> list = new ArrayList<Information>();
        try {
            ResultSet rs = null;
            Connection conn = JdbcUtil.getConnection();
            String sql_select = "select * from information,sc,teacher,lab WHERE information.course_id=sc.course_id AND information.teacher_id=teacher.teacher_id AND lab.lab_id=information.lab_id AND student_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_select);
            pst.setString(1,sno);
            rs = pst.executeQuery();
            while (rs.next()) {
                Information inf = new Information();
                inf.setId(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setTeacher_id(rs.getString(4));
                inf.setTab(rs.getString(5));
                inf.setDate(rs.getString(6));
                inf.setCourse_id(rs.getString(7));
                inf.setTeachet_name(rs.getString("teacher_name"));
                inf.setAddress(rs.getString("lab_address"));
                list.add(inf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}


