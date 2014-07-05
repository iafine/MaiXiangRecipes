package com.hyyy.spider;


import java.util.ArrayList;
import java.util.Iterator;

import com.hyyy.db.ConnMysql;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Html html = new Html() ;
		
		for(int i=2; i<=556; i++){
			
			//获取食谱的URL
			String page = html.getHtml("http://www.meishij.net/list.php?lm=13&page=" + i + "") ;
			ArrayList<Recipe> pageRecipes = html.Regex(page) ;
			  
			//使用Iterator遍历
			Iterator<Recipe> iterator = pageRecipes.iterator();
			  while (iterator.hasNext())
			  {
			   Recipe recipe = iterator.next() ;
			   
			   //将食谱插入数据库中
			   ConnMysql cm = new ConnMysql() ;
			   cm.connectionMysql() ;
			   cm.insertSql(recipe) ;
			  }
			
			   //打印出相关信息
			  System.out.println("接下来爬取第个"+(i+1)+"页面") ;
			}
	}
}
