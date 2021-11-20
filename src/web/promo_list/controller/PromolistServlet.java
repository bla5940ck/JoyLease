package web.promo_list.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromolistServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		res.getWriter().print("請測試一下看看");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doGet(req,res);
	}

}
