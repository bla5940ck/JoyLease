package web.pb_reply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class pb_replyJNDIDAO implements pb_replyDAO_interface {
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/root");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		private static final String INSERT_STMT = 
			"INSERT INTO pb_reply (reply_id,post_id,member_id,reply_cont,reply_time) VALUES (?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT reply_id,post_id,member_id,reply_cont,reply_time FROM pb_reply order by reply_id";
		private static final String GET_ONE_STMT = 
			"SELECT reply_id,post_id,member_id,reply_cont,reply_time FROM pb_reply where reply_id = ?";
		private static final String DELETE = 
			"DELETE FROM pb_reply where reply_id = ?";
		private static final String UPDATE = 
			"UPDATE pb_reply set reply_id=?, post_id=?, member_id=?, reply_cont=?, reply_time=?  where reply_id = ?";

	@Override
	public void insert(pb_replyVO pb_replyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, pb_replyVO.getReply_id());
			pstmt.setInt(2, pb_replyVO.getPost_id());
			pstmt.setInt(3, pb_replyVO.getMember_id());
			pstmt.setString(4, pb_replyVO.getReply_cont());
			pstmt.setTimestamp(5, pb_replyVO.getReply_time());

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
	public void update(pb_replyVO pb_replyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, pb_replyVO.getReply_id());
			pstmt.setInt(2, pb_replyVO.getPost_id());
			pstmt.setInt(3, pb_replyVO.getMember_id());
			pstmt.setString(4, pb_replyVO.getReply_cont());
			pstmt.setTimestamp(5, pb_replyVO.getReply_time());
			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer reply_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, reply_id);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public pb_replyVO findByPrimaryKey(Integer reply_id) {
		pb_replyVO pb_replyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, reply_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				pb_replyVO = new pb_replyVO();
				pb_replyVO.setReply_id(rs.getInt("reply_id"));
				pb_replyVO.setPost_id(rs.getInt("post_id"));
				pb_replyVO.setMember_id(rs.getInt("member_id"));
				pb_replyVO.setReply_cont(rs.getString("reply_cont"));
				pb_replyVO.setReply_time(rs.getTimestamp("reply_time"));
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
		return pb_replyVO;
	}

	@Override
	public List<pb_replyVO> getAll() {
		List<pb_replyVO> list = new ArrayList<pb_replyVO>();
		pb_replyVO pb_replyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				pb_replyVO = new pb_replyVO();
				pb_replyVO.setReply_id(rs.getInt("reply_id"));
				pb_replyVO.setPost_id(rs.getInt("post_id"));
				pb_replyVO.setMember_id(rs.getInt("member_id"));
				pb_replyVO.setReply_cont(rs.getString("reply_cont"));
				pb_replyVO.setReply_time(rs.getTimestamp("reply_time"));
				list.add(pb_replyVO); // Store the row in the list
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


