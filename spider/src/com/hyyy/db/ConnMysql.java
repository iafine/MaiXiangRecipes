package com.hyyy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hyyy.spider.Recipe;

public class ConnMysql {
	
	Connection conn ;		//连接数据库
	ResultSet rs = null ;		//数据查询结果
	PreparedStatement statement = null ;
	
	//连接mysql数据库
	public Connection connectionMysql(){
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver") ;
			try {
				//连接数据库
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes?seUnicode=true&characterEncoding=UTF-8",
																							"root", "mysqladmin") ;
				//查看连接是否退出
				if(!conn.isClosed()){
					System.out.println("Connecting to Mysql successfully!") ;
				}else{
					System.out.println("Connection has error!") ;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回conn
		return conn;
	}
	
	//关闭mysql数据库
	public void closeMysql(){
		/*
		 * 只有数据库启动连接后才能进行关闭，
		 * 关闭数据库应该先关闭查询功能，在关闭连接
		 */
		System.out.println("关闭数据库") ;
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn != null){
					try {
						
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						System.out.println("Mysql数据库已经关闭") ;
					}
				}
			}
		}
	}
	
	/*
	 * 数据库查询操作
	 * */
	public ResultSet selectSql(String sql){
		try {
			statement = conn.prepareStatement(sql) ;
			rs = statement.executeQuery(sql) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	/*
	 * 数据库插入操作
	 * */
	public boolean insertSql(Recipe r){
		String sql = "INSERT INTO `recipe`(`recipe_title`, `recipe_url`, `recipe_desp`, `recipe_imageUrl`, `recipe_difficulty`, `recipe_taste`, `recipe_time`, `recipe_materials`, `recipe_method`)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)" ;
		try {
			statement = conn.prepareStatement(sql);
			
			//防止由于特殊字符引起的insert错误 
			statement.setString(1, r.title) ;
			statement.setString(2, r.url) ;
			statement.setString(3, r.desp) ;
			statement.setString(4, r.imageUrl) ;
			statement.setString(5, r.difficulty) ;
			statement.setString(6, r.taste) ;
			statement.setString(7, r.time) ;
			statement.setString(8, r.materials) ;
			statement.setString(9, r.method) ;
			statement.execute();
			
			System.out.println("成功插入一条数据");
			return true ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 *  数据库更新操作
	 *  */
	public boolean updateSql(String sql){
		try {
			statement = conn.prepareStatement(sql) ;
			statement.executeUpdate() ;
			System.out.println("更新字段内容成功") ;
			return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
	}
	
	/*
	 * 数据库删除操作
	 * */
	public boolean deleteSql(String sql){
		try {
			statement = conn.prepareStatement(sql) ;
			statement.executeUpdate() ;
			return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
	}
}
