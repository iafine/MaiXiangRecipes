package org.recipe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	/*
	 * 数据库连接操作
	 * */
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// 定义MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/recipes?user=root&password=mysqladmin&useUnicode=true&characterEncoding=UTF-8";
	// MySQL数据库的连接用户名
	public static final String DBUSER = "root";
	// MySQL数据库的连接密码
	public static final String DBPASS = "mysqladmin";
	Connection conn = null;

	static{  
		
        try {  
            Class.forName(DBDRIVER);  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
    public static Connection getConnection(){  
        Connection conn=null;  
          
          
        try {  
            conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println("数据库连接成功！") ;
        return conn;  
  
    }  
	
    //关闭数据库
    public  static void closeDB(Connection conn, ResultSet rs, PreparedStatement ps){
    	
    	//关闭ResultSet
    	if(rs != null){
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	//关闭PreparedStatement
    	if(ps != null){
    		try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	//关闭Connection
    	if(conn != null){
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
