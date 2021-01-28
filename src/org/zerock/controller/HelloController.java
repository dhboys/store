package org.zerock.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.WordDAO;

/**
 * Servlet implementation class HelloController
 */
@WebServlet("/hello")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private WordDAO wordDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloController() {
        super();
        wordDAO = new WordDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher 
		= request.getRequestDispatcher("/WEB-INF/hello.jsp");
		
		request.setAttribute("msg", wordDAO.hello());
		
		dispatcher.forward(request, response);
	}

}
