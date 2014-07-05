package org.recipe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.recipe.domain.Recipe;

public interface RecipeDao {
	
	/*数据访问接口 (Data Access Object)
	 * 用于封装数据资源，方便更改
	 * */
	
	//根据关键字进行搜索
	public ArrayList<Recipe> search(String keyword) ;
	
	//根据食谱id得到食谱内容
	public Recipe getRecipe(int id) ;
	
	//根据关键词搜索出一个特定的食谱
	public Recipe getUniqueRecipe(String keyword) ;
	
	//得到所有食谱
	public ArrayList<Recipe> getAll() ;
	
	//得到食谱的口味
	public TreeMap<String, Integer> getTaste() ;
	
	//得到食谱所花时间
	public TreeMap<String, Integer> getTime() ;
	
	//得到食谱难度
	public TreeMap<String, Integer> getDiff() ;
	
	//根据口味和时间进行查询
	public Recipe getRecipeByTT(String taste, String time, String diff) ;
}
