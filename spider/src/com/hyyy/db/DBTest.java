package com.hyyy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	    	//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	      Connection connect = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:3306/Science_for_Children","root","mysqladmin");

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from articles");
	                                                              //user 为你表的名称
	while (rs.next()) {
	        System.out.println(rs.getString("title"));
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	}
}
