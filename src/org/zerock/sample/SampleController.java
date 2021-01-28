package org.zerock.sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.StoreDAO;
import org.zerock.domain.Store;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/store/*")
public class SampleController extends MultiController {
	private static final long serialVersionUID = 1L;

	private StoreDAO storeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleController() {
		super();
		storeDAO = new StoreDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("list get method..................");
		try {
			request.setAttribute("stores", storeDAO.selectAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 줄여 쓸 수 있다
		// jsp와 브라우저 사이에 주고 받는 뜻

		return "store/list";
	}

	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register get method..................");
		return "store/register";
	}

	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("view get method..................");
		try {

			Long sno = Long.parseLong(request.getParameter("sno"));

			Store store = storeDAO.selectOne(sno);

			request.setAttribute("store", store);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "/store/view";
	}

	public String registerPOST(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register post method..................");
		try {

			String name = request.getParameter("name");
			Double lat = Double.parseDouble(request.getParameter("lat"));
			Double lng = Double.parseDouble(request.getParameter("lng"));
			String menu = request.getParameter("menu");

			Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();

			storeDAO.insert(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "re:/store/list";
	}

	public String modifyGET(HttpServletRequest request, HttpServletResponse response) {

		Long sno = Long.parseLong(request.getParameter("sno"));

		try {
			Store store = storeDAO.selectOne(sno);

			request.setAttribute("store", store);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "store/modify";
	}

	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) {

		try {
			String name = request.getParameter("name");
			Double lat = Double.parseDouble(request.getParameter("lat"));
			Double lng = Double.parseDouble(request.getParameter("lng"));
			String menu = request.getParameter("menu");

			Long sno = Long.parseLong(request.getParameter("sno"));

			Store store = Store.builder().sno(sno).name(name).lat(lat).lng(lng).menu(menu).build();

			storeDAO.update(store);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "re:/store/list";
	}

	public String deletePOST(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long sno = Long.parseLong(request.getParameter("sno"));
			
				storeDAO.delete(sno);
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		
		return "re:/store/list";
	}
}
