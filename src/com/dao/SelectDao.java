package com.dao;

import com.bean.Information;
import com.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
public class SelectDao {
    public List<Information> DateCourse(String sno) {
        List<Information> list = new ArrayList<Information>();
        try {
            ResultSet rs = null;
            Connection conn = JdbcUtil.getConnection();
            String sql_select = "select * from information,teacher,lab WHERE  information.teacher_id=teacher.teacher_id AND lab.lab_id=information.lab_id AND information.lab_date=?";
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

    public List<Information> LabCourse(String sno) {
        List<Information> list = new ArrayList<Information>();
        try {
            ResultSet rs = null;
            Connection conn = JdbcUtil.getConnection();
            String sql_select = "select * from information,teacher,lab WHERE  information.teacher_id=teacher.teacher_id AND lab.lab_id=information.lab_id AND information.lab_id=?";
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

