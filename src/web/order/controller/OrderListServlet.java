package web.order.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.order.model.OrderListDAOImpl;
import web.order.model.OrderListVO;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
//		String path = req.getRequestURI();
//		System.out.println(path);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自listAllOrderList.jsp
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				String str = req.getParameter("listID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訂單明細編號");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				Integer listID = null;
				try {
					listID = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				/**************** 2.開始查詢資料 ****************/

				OrderListDAOImpl oldao = new OrderListDAOImpl();
				OrderListVO olVO = oldao.findOrderListByPK(listID);

				if (olVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/************** 3.查詢完成,準備轉交 *************/
				req.setAttribute("OrderListVO", olVO);
				System.out.println(req.getAttribute("OrderListVO"));
				String url = "/orderList/listOneOrderList.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/orderMaster/select_page.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
