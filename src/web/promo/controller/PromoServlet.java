package web.promo.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.promo.model.PromoService;
import web.promo.model.PromoVO;

public class PromoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_Promo.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer promo_id = new Integer(req.getParameter("promo_id").trim());
//				String str = req.getParameter("promo_id");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入專案編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/promo/select_promo.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}
//
//				Integer promo_id = null;
//				try {
//					promo_id = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("專案編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/promo/select_promo.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}

				/*************************** 2.開始查詢資料 *****************************************/
				PromoService promoSvc = new PromoService();
				PromoVO promoVO = promoSvc.findByPrimaryKey(promo_id);
				if (promoVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/promo/select_promo.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("promoVO", promoVO); // 資料庫取出的promoVO物件,存入req
				String url = "/promo/listOne_promo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOne_promo.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/promo/select_promo.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAll_promo.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer promo_id = new Integer(req.getParameter("promo_id"));

				/*************************** 2.開始查詢資料 ****************************************/
				PromoService promoSvc = new PromoService();
				PromoVO promoVO = promoSvc.findByPrimaryKey(promo_id);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("promoVO", promoVO); // 資料庫取出的promoVO物件,存入req
				String url = "/promo/update_promo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_promo_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/promo/listAll_promo.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_promo.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer promo_id = new Integer(req.getParameter("promo_id").trim());

				String promo_name = req.getParameter("promo_name");
				String promo_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (promo_name == null || promo_name.trim().length() == 0) {
					errorMsgs.add("專案名稱: 請勿空白");
				} else if (!promo_name.trim().matches(promo_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("專案名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				java.sql.Date promo_start = null;
				try {
					promo_start = java.sql.Date.valueOf(req.getParameter("promo_start").trim());
				} catch (IllegalArgumentException e) {
					promo_start = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				java.sql.Date promo_end = null;
				try {
					promo_end = java.sql.Date.valueOf(req.getParameter("promo_end").trim());
				} catch (IllegalArgumentException e) {
					promo_end = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				String promo_text = req.getParameter("promo_text").trim();
				if (promo_text == null || promo_text.trim().length() == 0) {
					errorMsgs.add("專案內容請勿空白");
				}

				Integer status = null;
				try {
					status = new Integer(req.getParameter("status").trim());
				} catch (NumberFormatException e) {
					status = 0;
					errorMsgs.add("狀態請填一位數字");
				}

				PromoVO promoVO = new PromoVO();
				promoVO.setPromo_id(promo_id);
				promoVO.setPromo_name(promo_name);
				promoVO.setPromo_start(promo_start);
				promoVO.setPromo_end(promo_end);
				promoVO.setPromo_text(promo_text);
				promoVO.setStatus(status);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("promoVO", promoVO); // 含有輸入格式錯誤的promoVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/promo/update_promo.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				PromoService promoSvc = new PromoService();
				promoVO = promoSvc.update(promo_id, promo_name, promo_start, promo_end, promo_text, status);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("promoVO", promoVO); // 資料庫update成功後,正確的的promoVO物件,存入req
				String url = "/promo/listOne_promo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOne_promo.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/promo/update_promo.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // 來自add_promo.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				String promo_name = req.getParameter("promo_name");
				String promo_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (promo_name == null || promo_name.trim().length() == 0) {
					errorMsgs.add("專案名稱: 請勿空白");
				} else if (!promo_name.trim().matches(promo_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("專案名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				java.sql.Date promo_start = null;
				try {
					promo_start = java.sql.Date.valueOf(req.getParameter("promo_start").trim());
				} catch (IllegalArgumentException e) {
					promo_start = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				java.sql.Date promo_end = null;
				try {
					promo_end = java.sql.Date.valueOf(req.getParameter("promo_end").trim());
				} catch (IllegalArgumentException e) {
					promo_end = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				String promo_text = req.getParameter("promo_text").trim();
				if (promo_text == null || promo_text.trim().length() == 0) {
					errorMsgs.add("專案內容請勿空白");
				}

				Integer status = null;
				try {
					status = new Integer(req.getParameter("status").trim());
				} catch (NumberFormatException e) {
					status = 0;
					errorMsgs.add("狀態請填一位數字");
				}

				PromoVO promoVO = new PromoVO();
				promoVO.setPromo_name(promo_name);
				promoVO.setPromo_start(promo_start);
				promoVO.setPromo_end(promo_end);
				promoVO.setPromo_text(promo_text);
				promoVO.setStatus(status);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("promoVO", promoVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/promo/add_promo.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				PromoService promoSvc = new PromoService();
				promoVO = promoSvc.insert(promo_name, promo_start, promo_end, promo_text, status);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/promo/listAll_promo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAll_promo.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/promo/add_promo.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAll_promo.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				Integer promo_id = new Integer(req.getParameter("promo_id"));

				/*************************** 2.開始刪除資料 ***************************************/
				PromoService promoSvc = new PromoService();
				promoSvc.delete(promo_id);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/promo/listAll_promo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/promo/listAll_pormo.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
