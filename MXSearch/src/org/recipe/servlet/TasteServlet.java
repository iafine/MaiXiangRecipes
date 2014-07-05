package org.recipe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recipe.service.RecipeServiceImpl;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RecipeServiceImpl service = new RecipeServiceImpl() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		TreeMap<String, Integer> taste = service.getTaste() ;
		TreeMap<String, Integer> time = service.getTime() ;
		TreeMap<String, Integer> diff = service.getDiff() ;
		
		System.out.println(diff.size()) ;
		System.out.println(time.size()) ;
		System.out.println(taste.size()) ;

		/*
		List<Map.Entry<String, Integer>> compare_taste =
				new ArrayList<Map.Entry<String, Integer>>(taste.entrySet());

			Collections.sort(compare_taste, new Comparator<Map.Entry<String, Integer>>(){
				public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
					return (o2.getValue() - o1.getValue());
				}
			}) ;
			*/
			
		ServletContext context = getServletContext() ;
		context.setAttribute("taste", taste);
		context.setAttribute("time", time);
		context.setAttribute("diff", diff);
		
		response.sendRedirect("/MXSearch/recipeList.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
