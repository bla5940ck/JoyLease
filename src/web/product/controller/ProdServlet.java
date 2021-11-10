package web.product.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.*;

public class ProdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		res.getWriter().print("請測試一下看看");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doGet(req,res);
	}

}
