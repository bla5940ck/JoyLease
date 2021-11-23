package web.promo_list.model;

import java.util.*;
import java.sql.*;
import util.Util;
import web.promo.model.PromoVO;

public class PromolistDAO implements Promolist_impl{
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		           
		private static final String INSERT_STMT = 
			"INSERT INTO promo_list (promo_id, category_id, coupon_name, discount, amount, used, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		private static final String GET_ALL_STMT = 
			"SELECT coupon_id, promo_id, category_id, coupon_name, discount, amount, used, start_date, end_date FROM promo_list order by coupon_id";
		private static final String GET_ONE_STMT = 
			"SELECT coupon_id, promo_id, category_id, coupon_name, discount, amount, used, start_date, end_date FROM promo_list where coupon_id = ?";
		private static final String DELETE = 
			"DELETE FROM promo_list where coupon_id = ?";
		private static final String UPDATE = 
			"UPDATE promo_list set promo_id=?, category_id=?, coupon_name=?, discount=?, amount=?, used=?, start_date=?, end_date=? where coupon_id = ?";
	

	@Override
	public void insert(PromolistVO promolistVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, promolistVO.getPromo_id());
			pstmt.setInt(2, promolistVO.getCategory_id());
			pstmt.setString(3, promolistVO.getCoupon_name());
			pstmt.setDouble(4, promolistVO.getDiscount());
			pstmt.setInt(5, promolistVO.getAmount());
			pstmt.setInt(6, promolistVO.getUsed());
			pstmt.setDate(7, promolistVO.getStart_date());
			pstmt.setDate(8, promolistVO.getEnd_date());

			pstmt.executeUpdate();


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
		} finally {
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

		
	}

	@Override
	public void update(PromolistVO promolistVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {


			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			
			pstmt.setInt(1, promolistVO.getPromo_id());
			pstmt.setInt(2, promolistVO.getCategory_id());
			pstmt.setString(3, promolistVO.getCoupon_name());
			pstmt.setDouble(4, promolistVO.getDiscount());
			pstmt.setInt(5, promolistVO.getAmount());
			pstmt.setInt(6, promolistVO.getUsed());
			pstmt.setDate(7, promolistVO.getStart_date());
			pstmt.setDate(8, promolistVO.getEnd_date());
			pstmt.setInt(9, promolistVO.getCoupon_id());
			
			pstmt.executeUpdate();

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
		} finally {
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
		
		
	}

	@Override
	public void delete(Integer coupon_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {


			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, coupon_id);

			pstmt.executeUpdate();

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
		} finally {
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
		
	}

	@Override
	public PromolistVO findByPrimaryKey(Integer coupon_id) {
		
		PromolistVO promolistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, coupon_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				promolistVO = new PromolistVO();
				promolistVO.setCoupon_id(rs.getInt("coupon_id"));
				promolistVO.setPromo_id(rs.getInt("promo_id"));
				promolistVO.setCategory_id(rs.getInt("category_id"));
				promolistVO.setCoupon_name(rs.getString("coupon_name"));
				promolistVO.setDiscount(rs.getDouble("discount"));
				promolistVO.setAmount(rs.getInt("amount"));
				promolistVO.setUsed(rs.getInt("used"));
				promolistVO.setStart_date(rs.getDate("start_date"));
				promolistVO.setEnd_date(rs.getDate("end_date"));
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
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
		return promolistVO;
	}

	@Override
	public List<PromolistVO> getAll() {
		List<PromolistVO> list = new ArrayList<PromolistVO>();
		PromolistVO promolistVO = null;
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {


			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				promolistVO = new PromolistVO();
				promolistVO.setCoupon_id(rs.getInt("coupon_id"));
				promolistVO.setPromo_id(rs.getInt("promo_id"));
				promolistVO.setCategory_id(rs.getInt("category_id"));
				promolistVO.setCoupon_name(rs.getString("coupon_name"));
				promolistVO.setDiscount(rs.getDouble("discount"));
				promolistVO.setAmount(rs.getInt("amount"));
				promolistVO.setUsed(rs.getInt("used"));
				promolistVO.setStart_date(rs.getDate("start_date"));
				promolistVO.setEnd_date(rs.getDate("end_date"));
				list.add(promolistVO);
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
		return list;
	}

}
