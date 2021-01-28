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
// * Servlet implementation class DeleteController
// */
//@WebServlet("/store/delete")
//public class DeleteController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private StoreDAO storeDAO;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DeleteController() {
//        super();
//        storeDAO = new StoreDAO();
//    }
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
//			try {
//			Long sno = Long.parseLong(request.getParameter("sno"));
//			
//				storeDAO.delete(sno);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//				response.sendRedirect("/error");
//			}
//		
//			response.sendRedirect("/store/list");
//			
//			
//	}
//
//}
