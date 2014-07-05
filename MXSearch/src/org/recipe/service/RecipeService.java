package org.recipe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.recipe.domain.Recipe;

public interface RecipeService {
	
	/*
	 * service层实现接口
	 * */
	
	//搜索功能实现
	public ArrayList<Recipe> search(String keyword) ; 
	
	//取得食谱细节信息
	public Recipe getRecipe(int id) ;
	
	//根据搜索取得一个食谱，返回给用户
	public Recipe getUniqueRecipe(String keyword) ;
	
	//得到全部食谱
	public ArrayList<Recipe> getAll() ;
	
	//得到前15名食谱口味排名
	public TreeMap<String, Integer> getTaste() ;
	
	//得到食谱所花时间
	public TreeMap<String, Integer> getTime() ;
	
	//得到食谱难度
	public TreeMap<String, Integer> getDiff() ;
	
	//得到智能搜索结果
	public Recipe getRecipeByTT(String taste, String time, String diff) ;
}
