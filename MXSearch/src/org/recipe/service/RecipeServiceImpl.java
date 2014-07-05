package org.recipe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.recipe.dao.RecipeDao;
import org.recipe.dao.RecipeDaoImpl;
import org.recipe.domain.Recipe;

public class RecipeServiceImpl implements RecipeService {

	/*
	 * service层具体实现
	 * */
	
	RecipeDao dao = new RecipeDaoImpl() ;
	
	@Override
	public ArrayList<Recipe> search(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("serviceImpl: " + keyword) ;
		return dao.search(keyword) ;
	}

	@Override
	public Recipe getRecipe(int id) {
		// TODO Auto-generated method stub
		System.out.println("serviceImpl:" + id) ;
		return dao.getRecipe(id) ;
	}

	@Override
	public Recipe getUniqueRecipe(String keyword) {
		// TODO Auto-generated method stub
		return dao.getUniqueRecipe(keyword);
	}

	@Override
	public ArrayList<Recipe> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll() ;
	}

	@Override
	public TreeMap<String, Integer> getTaste() {
		// TODO Auto-generated method stub
		return dao.getTaste();
	}

	@Override
	public TreeMap<String, Integer> getTime() {
		// TODO Auto-generated method stub
		return dao.getTime() ;
	}

	@Override
	public TreeMap<String, Integer> getDiff() {
		// TODO Auto-generated method stub
		return dao.getDiff();
	}

	@Override
	public Recipe getRecipeByTT(String taste, String time, String diff) {
		// TODO Auto-generated method stub
		return dao.getRecipeByTT(taste, time, diff);
	}
}
