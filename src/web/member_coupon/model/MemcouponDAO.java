package web.member_coupon.model;

import java.util.*;
import java.sql.*;
import util.Util;
import web.promo.model.PromoVO;

public class MemcouponDAO implements Memcoupon_impl{

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		// member_coupon
	                  // mem_coupon_id, member_id, category_id, coupon_id, coupon_name, discount, status, start_date, end_date
	
		private static final String INSERT_STMT = 
			"INSERT INTO member_coupon (member_id, category_id, coupon_id, coupon_name, discount, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		private static final String GET_ALL_STMT = 
			"SELECT mem_coupon_id, member_id, category_id, coupon_id, coupon_name, discount, status, start_date, end_date FROM member_coupon order by mem_coupon_id";
		private static final String GET_ONE_STMT = 
			"SELECT mem_coupon_id, member_id, category_id, coupon_id, coupon_name, discount, status, start_date, end_date FROM member_coupon where mem_coupon_id = ?";
		private static final String DELETE = 
			"DELETE FROM member_coupon where mem_coupon_id = ?";
		private static final String UPDATE = 
			"UPDATE member_coupon set member_id=?, category_id=?, coupon_id=?, coupon_name=?, discount=?, status=?, start_date=?, end_date=? where mem_coupon_id = ?";
	
	
	@Override
	public void insert(MemcouponVO memcouponVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memcouponVO.getMember_id());
			pstmt.setInt(2, memcouponVO.getCategory_id());
			pstmt.setInt(3, memcouponVO.getCoupon_id());
			pstmt.setString(4, memcouponVO.getCoupon_name());
			pstmt.setDouble(5, memcouponVO.getDiscount());		
			pstmt.setInt(6, memcouponVO.getStatus());
			pstmt.setDate(7, memcouponVO.getStart_date());
			pstmt.setDate(8, memcouponVO.getEnd_date());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void update(MemcouponVO memcouponVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			
			pstmt.setInt(1, memcouponVO.getMember_id());
			pstmt.setInt(2, memcouponVO.getCategory_id());
			pstmt.setInt(3, memcouponVO.getCoupon_id());
			pstmt.setString(4, memcouponVO.getCoupon_name());
			pstmt.setDouble(5, memcouponVO.getDiscount());
			pstmt.setInt(6, memcouponVO.getStatus());
			pstmt.setDate(7, memcouponVO.getStart_date());
			pstmt.setDate(8, memcouponVO.getEnd_date());
			pstmt.setInt(9, memcouponVO.getMem_coupon_id());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer mem_coupon_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mem_coupon_id);

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public MemcouponVO findByPrimaryKey(Integer mem_coupon_id) {
		MemcouponVO memcouponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_coupon_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				memcouponVO = new MemcouponVO();
				memcouponVO.setMem_coupon_id(rs.getInt("mem_coupon_id"));
				memcouponVO.setMember_id(rs.getInt("member_id"));
				memcouponVO.setCategory_id(rs.getInt("category_id"));
				memcouponVO.setCoupon_id(rs.getInt("coupon_id"));
				memcouponVO.setDiscount(rs.getDouble("discount"));
				memcouponVO.setCoupon_name(rs.getString("coupon_name"));
				memcouponVO.setStatus(rs.getInt("status"));
				memcouponVO.setStart_date(rs.getDate("start_date"));
				memcouponVO.setEnd_date(rs.getDate("end_date"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return memcouponVO;
	}

	@Override
	public List<MemcouponVO> getAll() {
		List<MemcouponVO> list = new ArrayList<MemcouponVO>();
		MemcouponVO memcouponVO = null;
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// promoVO �]�٬� Domain objects
				memcouponVO = new MemcouponVO();
				memcouponVO.setMem_coupon_id(rs.getInt("mem_coupon_id"));
				memcouponVO.setMember_id(rs.getInt("member_id"));
				memcouponVO.setCategory_id(rs.getInt("category_id"));
				memcouponVO.setCoupon_id(rs.getInt("coupon_id"));
				memcouponVO.setDiscount(rs.getDouble("discount"));
				memcouponVO.setCoupon_name(rs.getString("coupon_name"));
				memcouponVO.setStatus(rs.getInt("status"));
				memcouponVO.setStart_date(rs.getDate("start_date"));
				memcouponVO.setEnd_date(rs.getDate("end_date"));
				list.add(memcouponVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
