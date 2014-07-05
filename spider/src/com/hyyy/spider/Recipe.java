package com.hyyy.spider;

/*
 * 为了得到所有菜谱，我们定义了一个recipe类
 * 存储所有抓取到的对象
 */
public class Recipe {
	
	public String title ;				//抓取到的标题
	public String url ;					//做法步骤
	public String desp ;			//食谱简单介绍
	public String method ;		//食谱做法
	public String imageUrl ;				//食谱介绍图片链接
	public String difficulty ;			//制作难度
	public String taste ;				//口味
	public String time ;			//烹饪时间
	public String materials ;		//食材
	
	//Recipe方法
	public Recipe(){
		
		//初始化相关属性
		title = "" ;
		url = "" ;
		desp = "" ;
		method = "" ;
		imageUrl = "" ;
		difficulty = "" ;
		taste = "" ;
		time = "" ;
		materials = "" ;
	}

	@Override
	public String toString() {
		return "Recipe [title=" + title + ", url=" + url + ", desp=" + desp
				+ ", method=" + method + ", imageUrl=" + imageUrl
				+ ", difficulty=" + difficulty + ", taste=" + taste + ", time="
				+ time + ", materials=" + materials + "]";
	}

	
}
