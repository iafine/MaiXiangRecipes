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
 * Servlet implementation class UniqueServlet
 */
@WebServlet("/UniqueServlet")
public class UniqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RecipeServiceImpl service = new RecipeServiceImpl() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniqueServlet() {
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
		
		Recipe recipe = service.getUniqueRecipe(key) ;
		
		ServletContext context = getServletContext() ;
		context.setAttribute("r", recipe); 
		context.setAttribute("keyword", key);
		
		response.sendRedirect("/MXSearch/unique.jsp");
		System.out.println("Servlet拿到的菜谱：" + recipe.getTitle()) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
