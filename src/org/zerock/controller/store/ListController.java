//package org.zerock.controller.store;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.zerock.dao.StoreDAO;
//
///**
// * Servlet implementation class ListController
// */
//@WebServlet("/store/list")
//public class ListController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private StoreDAO storeDAO;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ListController() {
//        super();
//       
//        storeDAO = new StoreDAO();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
////		RequestDispatcher dispatcher =
////				request.getRequestDispatcher("/WEB-INF/store/list.jsp");
////		
////		dispatcher.forward(request, response);
//		// controller가 jsp 와 브라우저 사이에서 값을 받고 보내주는 역할
//		// controller를 통해서만 jsp와 브라우저가 소통할 수 있다
//		// request.setAttribute 는 jsp로 보내는 값
//		try {
//			request.setAttribute( "stores", storeDAO.selectAll());	
//		}catch ( Exception e) {
//			e.printStackTrace();
//		}
//		
//		// 줄여 쓸 수 있다
//		// jsp와 브라우저 사이에 주고 받는 뜻
//		request.getRequestDispatcher("/WEB-INF/store/list.jsp")
//		.forward(request, response);
//		
//	}
//
//	
//
//}
