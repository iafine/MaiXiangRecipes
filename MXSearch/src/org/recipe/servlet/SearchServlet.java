package org.recipe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recipe.domain.Recipe;
import org.recipe.service.RecipeServiceImpl;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	RecipeServiceImpl service = new RecipeServiceImpl() ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String key =request.getParameter("keyword") ;
		
		 //byte[]  buf =   key.getBytes("ISO8859-1") ;
		key = new String(key.getBytes("ISO8859-1"), "UTF-8") ;
		
		System.out.println(key) ;
		ArrayList<Recipe> list = service.search(key) ;
		
		ServletContext context = getServletContext() ;
		
		context.setAttribute("recipes", list); 
		context.setAttribute("keyword", key);
		
		response.sendRedirect("/MXSearch/resultList.jsp");
		System.out.println("Servlet拿到的菜谱数：" + list.size()) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
