package com.hyyy.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Html {
	
	/*
	 * 给出一个可用的URL，使用getHtml()得到它的html内容
	 */
	public String getHtml(String url){
		String content = "" ;
		BufferedReader br = null ;
		try{
			
			//在此定义要查询的URL，如果到后期的话，那么将会是很多页面
			URL getUrl = new URL(url) ;
			URLConnection  urlConnection = getUrl.openConnection() ;
			HttpURLConnection connection = null ;
			
			if(urlConnection instanceof HttpURLConnection){
				
				connection = (HttpURLConnection) urlConnection ;
			}else{
				
				System.out.println("Please input a right http address") ;
				return null ;
			}
			
			//如果URL合理，那么将进行读取操作
			br = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;
			String currentContent ;
			while((currentContent = br.readLine()) != null ){
				content += currentContent ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			//关闭输入流
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回html内容
		return content;	
	}
	
	/*
	 * 将得到的html内容用正则表达式进行分析
	 * 分析后的内容将存入数据库中
	 */
	public ArrayList<Recipe> Regex(String content){
		
		//定义一个Food来存储结果
		ArrayList<Recipe> recipes = new ArrayList<Recipe>() ;
		
		//匹配标题
		Pattern titlePattern = Pattern.compile("class=\"listtyle1\".+?title=\"(.+?)\"") ;
		Matcher titleMatcher = titlePattern.matcher(content) ;
		
		//匹配食物链接
		Pattern urlPattern = Pattern.compile("class=\"listtyle1\".+? href=\"(.+?)\"") ;
		Matcher urlMatcher = urlPattern.matcher(content) ;
		
		//一个food必须存在标题和食材
		boolean isFind = titleMatcher.find() &&  urlMatcher.find() ;
		
		while(isFind){
			
			//定义一个recipe对象用来存储抓取到的东西
			Recipe recipeTemp = new Recipe() ;
			recipeTemp.title = titleMatcher.group(1) ;
			recipeTemp.url = urlMatcher.group(1) ;
			
			/******************************************************************************/
			/*抓取recipeTemp.url页面
			 * 得到imageUrl，desp和practice
			 * */
			String recipeDetails = getHtml(recipeTemp.url) ;
			
			//匹配imageUrl
			Pattern imagePattern = Pattern.compile("<div class=\"cp_headerimg_w\".+? src=\"(.+?)\" /></div>") ;
			Matcher imageMatcher = imagePattern.matcher(recipeDetails) ;
			
			//匹配食谱的制作难度difficulty
			Pattern diffPattern = Pattern.compile("class=\"w270\".+?small\">(.+?)</a>") ;
			Matcher diffMatcher = diffPattern.matcher(recipeDetails) ;
			
			//匹配食谱的口味
			Pattern tastePattern = Pattern.compile("<li class=\"w127 bb0\">.+?big\">(.+?)</a>") ;
			Matcher tasteMatcher = tastePattern.matcher(recipeDetails) ;
			
			//匹配食谱的制作时间
			Pattern timePattern = Pattern.compile("<li class=\"w270 bb0 br0\">.+?small\">(.+?)</a>") ;
			Matcher timeMatcher = timePattern.matcher(recipeDetails) ;
			
			//匹配食谱的描述
			Pattern despPattern = Pattern.compile("<strong>“</strong>(.+?)<strong>”</strong>") ;
			Matcher despMatcher = despPattern.matcher(recipeDetails) ;
			 
			//匹配食谱的食材
			Pattern materialsPattern = Pattern.compile("<div class=\"materials_box\">(.+?)<div class=\"measure\">") ;
			Matcher materialsMatcher = materialsPattern.matcher(recipeDetails) ;
			 
			//匹配食谱制作方法
			Pattern methodPattern = Pattern.compile("<div class=\"measure\">(.+?)<span class=\"authors_copy_right\">") ;
			Matcher methodMatcher = methodPattern.matcher(recipeDetails) ;
			 
			boolean isGet = despMatcher.find() && imageMatcher.find() && diffMatcher.find() && tasteMatcher.find() 
														&& timeMatcher.find() && materialsMatcher.find() && methodMatcher.find() ;
			System.out.println(isGet) ;
			
			if(isGet){
				
				//将从recipeTemp.url页面抓取到的细节存储到recipeTemp
				recipeTemp.imageUrl = imageMatcher.group(1) ;
				recipeTemp.difficulty = diffMatcher.group(1) ;
				recipeTemp.taste = tasteMatcher.group(1) ;
				recipeTemp.time = timeMatcher.group(1) ;
				recipeTemp.desp = despMatcher.group(1) ;
				recipeTemp.materials = materialsMatcher.group(1) ;
				recipeTemp.method = methodMatcher.group(1) ;
			}
			//将匹配的结果添加到recipe中
			recipes.add(recipeTemp) ;
			
			/*
			 *  
			 * 解决网站禁止同一IP频繁访问
			 * 
			 * */
			Random random = new Random() ;
			  int time = (random.nextInt(4) + 1) * 1000 ;
			   
			   System.out.println(time/1000 + "秒后进行爬取下一个页面...") ;
				
			   try {
					Thread.sleep(time);	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			//匹配下一个
			isFind =  titleMatcher.find() && urlMatcher.find() ;
		}
		return recipes ;
	}

}
