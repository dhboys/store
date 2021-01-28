//package org.zerock.controller.store;
//
//import java.io.IOException;
//
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.zerock.dao.StoreDAO;
//import org.zerock.domain.Store;
//
///**
// * Servlet implementation class ModifyController
// */
//@WebServlet("/store/modify")
//public class ModifyController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private StoreDAO storeDAO;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ModifyController() {
//        super();
//        storeDAO = new StoreDAO();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		Long sno = Long.parseLong(request.getParameter("sno"));
//		
//		try {
//			Store store = storeDAO.selectOne(sno);
//			
//			RequestDispatcher dispatcher
//				= request.getRequestDispatcher("/WEB-INF/store/modify.jsp");
//			
//			request.setAttribute("store", store);
//			
//			dispatcher.forward(request, response);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.sendRedirect("/error");
//		}
//				
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//			
//			
//			try {
//			String name = request.getParameter("name");
//			Double lat = Double.parseDouble(request.getParameter("lat"));
//			Double lng = Double.parseDouble(request.getParameter("lng"));
//			String menu = request.getParameter("menu");
//			
//			Long sno = Long.parseLong(request.getParameter("sno"));
//			
//			Store store = Store.builder()
//					.sno(sno)
//					.name(name)
//					.lat(lat)
//					.lng(lng)
//					.menu(menu)
//					.build();	
//			
//			
//				storeDAO.update(store);
//			} catch (Exception e) {
//				e.printStackTrace();
//				response.sendRedirect("/error");
//			}
//			
//			response.sendRedirect("/store/list");
//			
//	}
//
//}
