package web.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.product.model.ProdDAO;
import web.product.model.ProdVO;

/**
 * Servlet implementation class ShelfServlet
 */
@WebServlet("/ShelfServlet")
public class ShelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdDAO prodDao = new ProdDAO();
		ProdVO vo = prodDao.findProductByPK(11);
		
		vo.setProdStatus(2);
		
		
		
		System.out.println();
	}

}
