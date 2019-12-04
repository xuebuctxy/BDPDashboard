package com.aura.training.dashboard.utils;

import java.sql.*;

public class MysqlPool {
    private static String className="com.mysql.jdbc.Driver"; //驱动名
    private static String url="jdbc:mysql://hadoopnode:3306/jd"; //连接数据库的URL地址
    private static String username="root"; //数据库的用户名
    private static String password="newpass"; //数据库的密码
    private static Connection con; //数据库连接对象
    private static PreparedStatement pstm; //数据库预编译处理对象

    public MysqlPool(){
        try{
            Class.forName(className);
        }catch(ClassNotFoundException e){
            System.out.println("加载数据库驱动程序失败！");
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try {
            con=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败！");
            e.printStackTrace();
        }
        return con;
    }

    public static ResultSet getRs(){
        try {
            return pstm.getResultSet();
        } catch (SQLException e) {
            System.out.println("DB类中的getRs()方法出错！");
            e.printStackTrace();
            return null;
        }
    }
}
