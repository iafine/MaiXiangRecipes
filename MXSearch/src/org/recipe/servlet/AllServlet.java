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
 * Servlet implementation class AllServlet
 */
@WebServlet("/AllServlet")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RecipeServiceImpl service = new RecipeServiceImpl() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		ArrayList<Recipe> list = service.getAll() ;
		System.out.println(list.size()) ;
		
		ServletContext context = getServletContext() ;
		
		context.setAttribute("all", list); 
		
		response.sendRedirect("/MXSearch/recipeList.jsp");
		System.out.println("Servlet拿到的菜谱数：" + list.size()) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
