package com.dao;
import com.bean.*;
import com.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/6/25.
 */
public class TeacherDao {
    /**
     * 安排课程
     * @param i
     * @return
     */
    public int insertInfor(Information i){
        int rs=0;
        try {
            Connection conn= JdbcUtil.getConnection();
            String sql="INSERT INTO lab.information (lab_id, lab_name" +
                    ", lab_date, lab_num,lab_tab,teacher_id,course_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,i.getId());
            ps.setString(2,i.getName());
            ps.setString(3,i.getDate());
            ps.setInt(4,i.getNum());
            ps.setString(5,i.getTab());
            ps.setString(6,i.getTeacher_id());
            ps.setString(7,i.getCourse_id());
            rs=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public List<Lab> selectLab(){
        Connection conn=null;
        List<Lab> list=new ArrayList<Lab>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConnection();
            String sql="SELECT  * FROM Lab.information i,lab.lab l WHERE i.lab_id=l.lab_id ";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Lab lab= new Lab();
                lab.setId(rs.getString("lab_id"));
                lab.setAddress(rs.getString("lab_address"));
                lab.setDate(rs.getString("lab_date"));
                lab.setTeacherid(rs.getString("teacher_id"));
                lab.setTab(rs.getString("lab_tab"));
                lab.setName(rs.getString("lab_name"));
                list.add(lab);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 查询教师课表
     */
    public List<TeacherCourse> selectTeacherClass(){
        Connection conn=null;
        List<TeacherCourse> list=new ArrayList<TeacherCourse>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConnection();
            String sql="SELECT l.lab_id,lab_address,lab_date,lab_tab,i.lab_name,lab_name1 FROM information i,lab l\n" +
                    "WHERE i.lab_id=l.lab_id";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                TeacherCourse c=new TeacherCourse();
                c.setId(rs.getString("lab_id"));
                c.setDate(rs.getString("lab_date"));
                c.setTab(rs.getString("lab_tab"));
                c.setLab_address("lab_address");
                c.setLab_name("lab_name");
                c.setLab_name1("lab_name1");
                c.setLab_address("lab_address");
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Teacher login(String student_id, String password){
        Teacher t=new Teacher();
        Connection conn=JdbcUtil.getConnection();
        try {
            String sql="SELECT * FROM  teacher WHERE teacher_id=? AND teacher_password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student_id);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                t.setId(rs.getString(2));
                t.setName(rs.getString(1));
            }
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }
    public List<Information> selectLabname(){
        List<Information> list =new ArrayList<>();
        try{
            Connection conn=JdbcUtil.getConnection();
            ResultSet rs=null;
            String sql="SELECT * FROM lab.lab";
            PreparedStatement ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Information i=new Information();
                i.setId(rs.getString("lab_id"));
                i.setName(rs.getString("lab_name1"));
                System.out.println(i.toString());
                list.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Information> TeacherCourse(String sno) {
        List<Information> list = new ArrayList<Information>();
        try {
            ResultSet rs = null;
            Connection conn = JdbcUtil.getConnection();
            String sql_select = "select * from information,teacher,lab WHERE  information.teacher_id=teacher.teacher_id AND lab.lab_id=information.lab_id AND information.teacher_id=?";
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
