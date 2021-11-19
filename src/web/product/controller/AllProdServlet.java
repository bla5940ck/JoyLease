package web.product.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Util;



public class AllProdServlet extends HttpServlet {
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * from product where prod_id=" + req.getParameter("picNo");

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			OutputStream os = res.getOutputStream();
			byte[] pic1 = null;
			byte[] pic2 = null;
			byte[] pic3 = null;

			while (rs.next()) {
				pic1 = rs.getBytes("pic_1");
				pic2 = rs.getBytes("pic_2");
				pic3 = rs.getBytes("pic_3");

				String no = req.getParameter("no");
				if (no != null) {
					switch (no) {
					case "1":
						if (pic1 != null)
							os.write(pic1);
						break;
					case "2":
						if (pic2 != null)
							os.write(pic2);
						break;
					case "3":
						if (pic3 != null)
							os.write(pic3);
						break;
					}
				}

//				String no = req.getParameter("no");
//				if (req.getParameter("no") != null) {
//					switch (no) {
//					case "1":
//						
//						break;
//					case "2":
//						os.write(pic2);
//						break;
//					case "3":
//						os.write(pic3);
//						break;
//					}
////				
//				
//			}
//				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


