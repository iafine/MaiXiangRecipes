package com.hyyy.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hyyy.spider.Recipe;

public class Test {
	public static void main(String[] args){
		ConnMysql cm = new ConnMysql() ;
		cm.connectionMysql() ;
		cm.closeMysql();
	}
}
