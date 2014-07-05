package com.hyyy.spider;

import java.sql.ResultSet;

import com.hyyy.db.ConnMysql;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

public class Pinyin{
	public static void main(String args[]){
		/*
		 * 测试代码：
		 * 1. 爬虫爬到的标题如果是全中文，则转化成全拼音;
		 * 		例如： “西红柿鸡蛋面” ---> "xihongshijidanmian"
		 * 2. 如果标题还有标点符号，英文字符等非中文字符，则不做任何处理;
		 * 		例如： “小吃---xihongshi鸡蛋面” ---> "xiaochi---xihongshijidanmian"
		 * */
		
		ConnMysql cm = new ConnMysql() ;
		
		//查询数据表sql语句
		String sql = "select * from recipe " ;
		//连接数据库
		cm.connectionMysql() ;
		//System.out.println(sql) ;
		try {
			//取得查询结果
			ResultSet rs = cm.selectSql(sql) ;
			
			while(rs.next()){
				String title = rs.getString("recipe_title") ;
				int id = rs.getInt("recipe_id") ;
				//System.out.println(title + "-->" + id) ;
				
				//将title变成拼音
				String title_pinyin = PinyinHelper.convertToPinyinString(title, " ", PinyinFormat.WITH_TONE_NUMBER)  ;
				//System.out.println(title_pinyin) ;
				
				//更新数据表，插入recipe_title_pinyin
				String update_sql = "update recipe set recipe_title_pinyin='"+title_pinyin+"' where recipe_id="+ id +"" ;
				//System.out.println(update_sql) ;
				
				cm.updateSql(update_sql) ;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*
		String s = "我是-----hyyy!" ;
		String pinyin = PinyinHelper.convertToPinyinString(s, "", PinyinFormat.WITH_TONE_NUMBER) ;
		
		System.out.println(pinyin) ;
		//输出：wo3shi4-----hyyy!  ( 其中数字是声调)
		*/
		/*
		 * 如果用户搜索的是“炒鸡蛋”关键词，那么将转化成“chaojidan”，
		 * get提交是应当是?keyword=chaojidan这种格式
		 * 
		 *  */
		/*
		String keyword = "炒鸡蛋"  ;
		String keyword_pinyin = PinyinHelper.convertToPinyinString(keyword, "", PinyinFormat.WITH_TONE_NUMBER) ;
		
		System.out.println(keyword_pinyin) ;
		*/
		//输出：chao3ji1dan4  ( 其中数字是声调)
	}
	
}