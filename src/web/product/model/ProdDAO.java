package web.product.model;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class ProdDAO implements ProdDAOImpl {

	static {
		try {
			Class.forName(util.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(ProdVO prod) {
		
		String sql = "INSERT INTO product(category_id,prod_status,prod_name,prod_cot,prod_rent,prod_price,comt,pic_1,pic_2,pic_3,shelf_date) VALUES (?,?,?,?,?, ?, ?, ?, ?, ?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, prod.getCategoryID());
			pstmt.setInt(2, prod.getProdStatus());
			pstmt.setString(3, prod.getProdName());
			pstmt.setString(4, prod.getProdCot());
			pstmt.setInt(5, prod.getProdRent());
			pstmt.setInt(6, prod.getProdPrice());
			pstmt.setString(7, prod.getComt());
			pstmt.setBytes(8, prod.getPic1());
			pstmt.setBytes(9, prod.getPic2());
			pstmt.setBytes(10, prod.getPic3());
			pstmt.setTimestamp(11, prod.getShelfDate());
			
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void update(ProdVO prod) {
		String sql = "update product set category_id=?, prod_status=?, prod_name=? ,prod_cot =? ,prod_rent=?,prod_price=? ,pic_1=?,pic_2=?,pic_3=?,comt=?,shelf_date=? where prod_id = ? ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prod.getCategoryID());
			pstmt.setInt(2, prod.getProdStatus());
			pstmt.setString(3, prod.getProdName());
			pstmt.setString(4, prod.getProdCot());
			pstmt.setInt(5, prod.getProdRent());
			pstmt.setInt(6, prod.getProdPrice());
			pstmt.setBytes(7, prod.getPic1());
			pstmt.setBytes(8, prod.getPic2());
			pstmt.setBytes(9, prod.getPic3());
			pstmt.setString(10, prod.getComt());
			pstmt.setTimestamp(11, prod.getShelfDate());
			pstmt.setInt(12, prod.getProdID());
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteProudct(ProdVO prod) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdVO findProductByPK(Integer prodId) {
		String sql = "select * from product where prod_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProdVO prod = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prodId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				prod = new ProdVO();
				prod.setProdID(rs.getInt("prod_id"));
				prod.setCategoryID(rs.getInt("category_id"));
				prod.setMemberID(rs.getInt("member_id"));
				prod.setProdStatus(rs.getInt("prod_status"));
				prod.setProdName(rs.getString("prod_name"));
				prod.setProdCot(rs.getString("prod_cot"));
				prod.setShelfDate(rs.getTimestamp("shelf_date"));
				prod.setCreationDate(rs.getTimestamp("creation_date"));
				prod.setProdRent(rs.getInt("prod_rent"));
				prod.setProdPrice(rs.getInt("prod_price"));
				prod.setPic1(rs.getBytes("pic_1"));
				prod.setPic2(rs.getBytes("pic_2"));
				prod.setPic3(rs.getBytes("pic_3"));
				prod.setComt(rs.getString("comt"));

			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}

		return prod;
	}

	@Override
	public List<ProdVO> getAll() {
		List<ProdVO> prodList = new ArrayList<ProdVO>();
		String sql = "select * from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProdVO prod = new ProdVO();
				prod.setProdID(rs.getInt("prod_id"));
				prod.setCategoryID(rs.getInt("category_id"));
				prod.setMemberID(rs.getInt("member_id"));
				prod.setProdStatus(rs.getInt("prod_status"));
				prod.setProdName(rs.getString("prod_name"));
				prod.setProdCot(rs.getString("prod_cot"));
				prod.setShelfDate(rs.getTimestamp("shelf_date"));
				prod.setCreationDate(rs.getTimestamp("creation_date"));
				prod.setProdRent(rs.getInt("prod_rent"));
				prod.setProdPrice(rs.getInt("prod_price"));
				prod.setPic1(rs.getBytes("pic_1"));
				prod.setPic2(rs.getBytes("pic_2"));
				prod.setPic3(rs.getBytes("pic_3"));
				prod.setComt(rs.getString("comt"));

				prodList.add(prod);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

		return prodList;
	}
	
	public Integer getLastKey() {
		String sql = "select * from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int lastKey = 0 ;
		
		
		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				lastKey = rs.getInt("prod_id");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKey;
	}
	

}
