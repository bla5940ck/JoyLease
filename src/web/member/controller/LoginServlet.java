package web.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import web.member.model.MemberService;
import web.member.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	
	
		if ("getOne_For_Display".equals(action)) { // 來自Login.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String str = req.getParameter("loginId");
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入帳號 ");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/login.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer loginId = null;
			try {
				loginId = new Integer(str);
			} catch (Exception e) {
				errorMsgs.add("登入帳號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			MemberService empSvc = new MemberService();
			MemberVO memberVO = empSvc.getOneMember(loginId);
			if (memberVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emp/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("empVO", memberVO); // 資料庫取出的empVO物件,存入req
			String url = "/emp/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

			/***************************其他可能的錯誤處理*************************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/emp/select_page.jsp");
			failureView.forward(req, res);
		}
	}
	
	
	if ("getOne_For_Update".equals(action)) { // 來自login.jsp的請求

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		
		try {
			/***************************1.接收請求參數****************************************/
			String loginId = new String(req.getParameter("loginId"));
			
			/***************************2.開始查詢資料****************************************/
			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getLoginMember(loginId);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("memberVO", memberVO);         // 資料庫取出的memberVO物件,存入req
			String url = "/member/login.html";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 /member/login.html
			successView.forward(req, res);

			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/emp/listAllEmp.jsp");
			failureView.forward(req, res);
		}
		}
	}
}
