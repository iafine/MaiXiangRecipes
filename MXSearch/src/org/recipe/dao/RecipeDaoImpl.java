package org.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import org.recipe.db.DB;
import org.recipe.domain.Recipe;

public class RecipeDaoImpl implements RecipeDao{

	/*
	 * DAO接口的具体实现
	 * */
	
	//根据关键词进行搜索，返回一个ArrayList集合
	public ArrayList<Recipe> search(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("DaoImpl: " + keyword) ;
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			conn = DB.getConnection() ;
			String sql = "select * from recipe where recipe_title LIKE '%"+ keyword +"%'" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//ps.setString(1, keyword);			//将sql语句问号部分替换成keyword值
					
			rs = ps.executeQuery() ;
			
			ArrayList<Recipe> list = new ArrayList<Recipe>() ;
			while(rs.next()){
				//输出查询到的recipe
				Recipe r = new Recipe() ;
				r.setId(rs.getInt("recipe_id"));
				r.setTitle(rs.getString("recipe_title"));
				r.setImageUrl(rs.getString("recipe_imageUrl"));
				
				//加入食谱到集合中
				list.add(r) ;
			}
			System.out.println("查询到的菜谱数：" + list.size()) ;
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	//根据食谱id，取得食谱各个字段值
	public Recipe getRecipe(int id) {
		// TODO Auto-generated method stub
		
		System.out.println("DaoImpl: " + id) ;
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			//连接数据库
			conn = DB.getConnection() ;
			
			//sql语句
			String sql = "select * from recipe where recipe_id="+ id +"" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//执行sql语句
			rs = ps.executeQuery() ;
			
			Recipe recipe = new Recipe() ;
			
			//返回执行的结果
			while(rs.next()){	
								
				//取得食谱中各字段值
				recipe.setId(rs.getInt("recipe_id"));
				recipe.setTitle(rs.getString("recipe_title"));
				recipe.setUrl(rs.getString("recipe_url"));
				recipe.setDesp(rs.getString("recipe_desp"));
				recipe.setImageUrl(rs.getString("recipe_imageUrl"));
				recipe.setDifficulty(rs.getString("recipe_difficulty"));
				recipe.setTaste(rs.getString("recipe_taste"));
				recipe.setTime(rs.getString("recipe_time"));
				recipe.setMaterials(rs.getString("recipe_materials"));
				recipe.setMethod(rs.getString("recipe_method"));
			}
			
			return recipe;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null;
	}

	@Override
	public Recipe getUniqueRecipe(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("DaoImpl: " + keyword) ;
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			conn = DB.getConnection() ;
			String sql = "select * from recipe where recipe_title LIKE '%"+ keyword +"%' order by rand() limit 1" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//ps.setString(1, keyword);			//将sql语句问号部分替换成keyword值
			
			rs = ps.executeQuery() ;
			
			Recipe recipe = new Recipe() ;
			while(rs.next()){
				
				//取得食谱中各字段值
				recipe.setId(rs.getInt("recipe_id"));
				recipe.setTitle(rs.getString("recipe_title"));
				recipe.setUrl(rs.getString("recipe_url"));
				recipe.setDesp(rs.getString("recipe_desp"));
				recipe.setImageUrl(rs.getString("recipe_imageUrl"));
				recipe.setDifficulty(rs.getString("recipe_difficulty"));
				recipe.setTaste(rs.getString("recipe_taste"));
				recipe.setTime(rs.getString("recipe_time"));
				recipe.setMaterials(rs.getString("recipe_materials"));
				recipe.setMethod(rs.getString("recipe_method"));
			}
			
			return recipe;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	public ArrayList<Recipe> getAll() {
		
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			//连接数据库
			conn = DB.getConnection() ;
			
			//sql语句
			String sql = "select * from recipe" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//执行sql语句
			rs = ps.executeQuery() ;
			
			ArrayList<Recipe> list = new ArrayList<Recipe>() ;
			
			while(rs.next()){
				//输出查询到的recipe
				Recipe r = new Recipe() ;
				r.setId(rs.getInt("recipe_id"));
				r.setTitle(rs.getString("recipe_title"));
				
				//加入食谱到集合中
				list.add(r) ;
			}
			System.out.println("查询到的菜谱数：" + list.size()) ;
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	public TreeMap<String, Integer> getTaste() {
		
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			//连接数据库
			conn = DB.getConnection() ;
			
			//sql语句
			String sql = "SELECT count(*) AS count, recipe_taste FROM recipe GROUP BY recipe_taste ORDER BY count DESC LIMIT 10" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//执行sql语句
			rs = ps.executeQuery() ;
			
			TreeMap<String, Integer> taste = new TreeMap<String, Integer>() ;
			
			while(rs.next()){
				
				//输出查询到的结果
				taste.put(rs.getString("recipe_taste"), rs.getInt("count")) ;
			}
			System.out.println("查询到的菜谱口味：" +taste.size()) ;
			return taste;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	public TreeMap<String, Integer> getTime() {
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			//连接数据库
			conn = DB.getConnection() ;
			
			//sql语句
			String sql = "SELECT count(*) AS count, recipe_time FROM recipe GROUP BY recipe_time ORDER BY count DESC" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//执行sql语句
			rs = ps.executeQuery() ;
			
			TreeMap<String, Integer> time = new TreeMap<String, Integer>() ;
			
			while(rs.next()){
				
				//输出查询到的结果
				time.put(rs.getString("recipe_time"), rs.getInt("count")) ;
			}
			System.out.println("查询到的菜谱所需时间：" +time.size()) ;
			return time;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	public TreeMap<String, Integer> getDiff() {
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			//连接数据库
			conn = DB.getConnection() ;
			
			//sql语句
			String sql = "SELECT count(*) AS count, recipe_difficulty FROM recipe GROUP BY recipe_difficulty ORDER BY count DESC" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//执行sql语句
			rs = ps.executeQuery() ;
			
			TreeMap<String, Integer> diff = new TreeMap<String, Integer>() ;
			
			while(rs.next()){
				
				//输出查询到的结果
				diff.put(rs.getString("recipe_difficulty"), rs.getInt("count")) ;
			}
			System.out.println("查询到的菜谱难度：" +diff.size()) ;
			return diff;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}

	@Override
	public Recipe getRecipeByTT(String taste, String time, String diff) {
		// TODO Auto-generated method stub
		System.out.println("DaoImpl: " + taste + "--->" + time + "-->" + diff) ;
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		try {
			conn = DB.getConnection() ;
			String sql = "select * from recipe where recipe_taste LIKE '%"+ taste +"%' AND recipe_time = '"+ time +"' AND recipe_difficulty = '"+ diff +"' order by rand() limit 1" ;
			System.out.println(sql) ;
			ps = conn.prepareStatement(sql) ;
			
			//ps.setString(1, keyword);			//将sql语句问号部分替换成keyword值
			
			rs = ps.executeQuery() ;
			
			Recipe recipe = new Recipe() ;
			while(rs.next()){
				
				//取得食谱中各字段值
				recipe.setId(rs.getInt("recipe_id"));
				recipe.setTitle(rs.getString("recipe_title"));
				recipe.setUrl(rs.getString("recipe_url"));
				recipe.setDesp(rs.getString("recipe_desp"));
				recipe.setImageUrl(rs.getString("recipe_imageUrl"));
				recipe.setDifficulty(rs.getString("recipe_difficulty"));
				recipe.setTaste(rs.getString("recipe_taste"));
				recipe.setTime(rs.getString("recipe_time"));
				recipe.setMaterials(rs.getString("recipe_materials"));
				recipe.setMethod(rs.getString("recipe_method"));
			}
			
			return recipe;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DB.closeDB(conn, rs, ps); ;
		}
		return null ;
	}
}
