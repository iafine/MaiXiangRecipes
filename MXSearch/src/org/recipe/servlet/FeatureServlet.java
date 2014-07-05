package org.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recipe.domain.Recipe;
import org.recipe.service.RecipeServiceImpl;

/**
 * Servlet implementation class FeatureServlet
 */
@WebServlet("/FeatureServlet")
public class FeatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RecipeServiceImpl service = new RecipeServiceImpl() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeatureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String taste =request.getParameter("taste") ;
		String time =request.getParameter("time") ;
		String diff =request.getParameter("diff") ;
		
		 //byte[]  buf =   key.getBytes("ISO8859-1") ;
		taste = new String(taste.getBytes("ISO8859-1"), "UTF-8") ;
		time = new String(time.getBytes("ISO8859-1"), "UTF-8") ;
		diff = new String(diff.getBytes("ISO8859-1"), "UTF-8") ;
		System.out.println(taste + "--->" + time + "--->" + diff) ;
		
		Recipe recipe = service.getRecipeByTT(taste, time, diff) ;
		
		ServletContext context = getServletContext() ;
		
		context.setAttribute("r", recipe); 
		
		response.sendRedirect("/MXSearch/recipe.jsp");
		System.out.println("Servlet拿到的菜谱：" + recipe) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
