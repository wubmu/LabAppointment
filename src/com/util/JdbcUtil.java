package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by 吴亚斌 on 2017/2/10.
 */
public class JdbcUtil {
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;
    static {
        try {
            ClassLoader cl=JdbcUtil.class.getClassLoader();
            InputStream in =cl.getResourceAsStream("dbcfg.properties");
            Properties props=new Properties();
            props.load(in);
            driverClass=props.getProperty("driverClass");
            user=props.getProperty("user");
            url=props.getProperty("url");
            password=props.getProperty("password");
            in.close();
        } catch (IOException e) {
            throw  new ExceptionInInitializerError("获取配置文件信息失败");
        }
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw  new ExceptionInInitializerError("加载驱动失败");
        }
    }

    public static Connection getConnection() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab"
                    , "root", "123456");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("连接数据库的url和用户密码错误");
        }
    }

    public static void release(Connection conn, ResultSet rs, Statement statm) {
        if (rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        rs = null;
        if (statm != null)
            try {
                statm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        statm = null;
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        conn = null;
    }
}
