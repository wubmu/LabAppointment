package com.dao;

import com.bean.Lab;
import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dell on 2017/6/25.
 */
public class AdminDao {
    Connection conn= JdbcUtil.getConnection();
    PreparedStatement stam=null;
    ResultSet rs=null;
    /**
     * 增加
     */

    public int insert(Lab lab ){
        int rs=0;
        Connection conn= JdbcUtil.getConnection();
        PreparedStatement stam=null;
       Lab lab1=new Lab();
        try {

            String sql_insert="insert into lab (adress,id,name ) VALUES (?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql_insert);
            pst.setString(1,lab1.getId());
            pst.setString(2,lab1.getAddress());
            pst.setString(3,lab1.getName());
            rs= pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
/**
 * 删除
 */
  public  int delete(Lab id){
      int rs=0;
      Connection conn= JdbcUtil.getConnection();
      PreparedStatement stam=null;
      Lab lab=new Lab();
      try {
          String sql="DELETE FROM lab WHERE lab_id=?";

          stam=conn.prepareStatement(sql);
          stam.setString(1,lab.getId());
          rs=stam.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return rs;
  }

    /**
     * 修改实验室信息
     * @return
     */
   public int updateLab(Lab lab){
       Connection conn= JdbcUtil.getConnection();
       PreparedStatement stam=null;
       int rs=0;
       Lab lab1=new Lab();
       try {
           String sql="UPDATE user SET lab_name=?,lab_adress=? WHERE lab_id=?";
           stam=conn.prepareStatement(sql);
           stam.setString(1,lab1.getId());
           stam.setString(3,lab1.getName());
           stam.setString(2,lab1.getAddress());
           rs=stam.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rs;
   }

    }







