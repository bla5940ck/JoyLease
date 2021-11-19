package web.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class ProdCategoryDAO implements ProdCategoryDAOImpl{
		
		static {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	@Override
	public ProdCategoryVO findCategoryByPK(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		ProdCategoryVO prodCategory = null;
		String sql = "select * from product_category where category_id = ?";
		try {
			
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			prodCategory = new ProdCategoryVO();
			rs.next();
			prodCategory.setCategoryName(rs.getString("category_name"));
			prodCategory.setCategoryID(id);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return prodCategory;
	}

	@Override
	public List<ProdCategoryVO> getAllCategory() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		ProdCategoryVO prodCategory = null;
		String sql = "select * from product_category";
		List<ProdCategoryVO> list = new ArrayList<ProdCategoryVO>();
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			prodCategory = new ProdCategoryVO();
			while(rs.next()) {
				prodCategory = new ProdCategoryVO(rs.getInt(1),rs.getString(2));
				
				list.add(prodCategory);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
			
		}
		return list;
	}

	@Override
	public void addCategory(ProdCategoryVO prodCategory) {
		// TODO Auto-generated method stub
		
	}
	
}
