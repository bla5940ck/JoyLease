package web.promo.model;

import java.util.*;
import java.sql.*;
import util.Util;

public class PromoDAO implements Promo_impl{

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
		private static final String INSERT_STMT = 
			"INSERT INTO promo (promo_name, promo_start, promo_end, promo_text, status) VALUES (?, ?, ?, ?, ?);";
		private static final String GET_ALL_STMT = 
			"SELECT promo_id, promo_name, promo_start, promo_end, promo_text, status FROM promo order by promo_id";
		private static final String GET_ONE_STMT = 
			"SELECT promo_id, promo_name, promo_start, promo_end, promo_text, status FROM promo where promo_id = ?";
		private static final String DELETE = 
			"DELETE FROM promo where promo_id = ?";
		private static final String UPDATE = 
			"UPDATE promo set promo_name=?, promo_start=?, promo_end=?, promo_text=?, status=? where promo_id = ?";
	
	@Override
	public void insert(PromoVO promoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, promoVO.getPromo_name());
			pstmt.setDate(2, promoVO.getPromo_start());
			pstmt.setDate(3, promoVO.getPromo_end());
			pstmt.setString(4, promoVO.getPromo_text());
			pstmt.setInt(5, promoVO.getStatus());

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
	public void update(PromoVO promoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, promoVO.getPromo_name());
			pstmt.setDate(2, promoVO.getPromo_start());
			pstmt.setDate(3, promoVO.getPromo_end());
			pstmt.setString(4, promoVO.getPromo_text());
			pstmt.setInt(5, promoVO.getStatus());
			pstmt.setInt(6, promoVO.getPromo_id());

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
	public void delete(Integer promo_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, promo_id);

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
	public PromoVO findByPrimaryKey(Integer promo_id) {
		
		PromoVO promoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, promo_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				promoVO = new PromoVO();
				promoVO.setPromo_id(rs.getInt("promo_id"));
				promoVO.setPromo_name(rs.getString("promo_name"));
				promoVO.setPromo_start(rs.getDate("promo_start"));
				promoVO.setPromo_end(rs.getDate("promo_end"));
				promoVO.setPromo_text(rs.getString("promo_text"));
				promoVO.setStatus(rs.getInt("status"));
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
		return promoVO;
	}

	@Override
	public List<PromoVO> getAll() {
		List<PromoVO> list = new ArrayList<PromoVO>();
		PromoVO promoVO = null;
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				promoVO = new PromoVO();
				promoVO.setPromo_id(rs.getInt("promo_id"));
				promoVO.setPromo_name(rs.getString("promo_name"));
				promoVO.setPromo_start(rs.getDate("promo_start"));
				promoVO.setPromo_end(rs.getDate("promo_end"));
				promoVO.setPromo_text(rs.getString("promo_text"));
				promoVO.setStatus(rs.getInt("status"));
				list.add(promoVO);
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