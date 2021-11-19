package web.pb_reply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;


public class pb_replyJDBCDAO implements pb_replyDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/JoyLease_1115?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = 
		"INSERT INTO pb_reply (reply_id,post_id,member_id,reply_cont,reply_time) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT reply_id,post_id,member_id,reply_cont,reply_time FROM pb_reply order by reply_id";
	private static final String GET_ONE_STMT = 
		"SELECT reply_id,post_id,member_id,reply_cont,reply_time FROM pb_reply where reply_id = ?";
	private static final String DELETE = 
		"DELETE FROM pb_reply where reply_id = ?";
	private static final String UPDATE = 
		"UPDATE pb_reply set post_id=?, member_id=?, reply_cont=? reply_time=?  where reply_id = ?";
	
	
	
	@Override
	public void insert(pb_replyVO pb_replyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, pb_replyVO.getReply_id());
			pstmt.setInt(2, pb_replyVO.getPost_id());
			pstmt.setInt(3, pb_replyVO.getMember_id());
			pstmt.setString(4, pb_replyVO.getReply_cont());
			pstmt.setTimestamp(5, pb_replyVO.getReply_time());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, pb_replyVO.getReply_id());
			pstmt.setInt(2, pb_replyVO.getPost_id());
			pstmt.setInt(3, pb_replyVO.getMember_id());
			pstmt.setString(4, pb_replyVO.getReply_cont());
			pstmt.setTimestamp(5, pb_replyVO.getReply_time());
		

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(Integer reply_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, reply_id);

			pstmt.executeUpdate();
			//執行

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public pb_replyVO findByPrimaryKey(Integer reply_id) {
		pb_replyVO pb_replyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
	
	public static void main(String[] args) {

		pb_replyJDBCDAO dao = new pb_replyJDBCDAO();
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);

		// 新增--ok
//		pb_replyVO pb_replyVO1 = new pb_replyVO();
//		pb_replyVO1.setReply_id(5);
//		pb_replyVO1.setPost_id(1);
//		pb_replyVO1.setMember_id(5);
//		pb_replyVO1.setReply_cont("test2");
//		pb_replyVO1.setReply_time(timestamp);
//		dao.insert(pb_replyVO1);

//		// 修改--ok
//		pb_replyVO pb_replyVO2 = new pb_replyVO();
//		pb_replyVO2.setReply_id(4);
//		pb_replyVO2.setPost_id(1);
//		pb_replyVO2.setMember_id(5);
//		pb_replyVO2.setReply_cont("test2");
//		pb_replyVO2.setReply_time(timestamp);
//		dao.insert(pb_replyVO2);
	
//
//		// 刪除--ok
//		dao.delete(4);
//
//		// 查詢--ok
//		pb_replyVO pb_replyVO3 = new pb_replyVO();
//		pb_replyVO3.setReply_id(1);
//		pb_replyVO3.setPost_id(1);
//		pb_replyVO3.setMember_id(1);
//		pb_replyVO3.setReply_cont("test");
//		pb_replyVO3.setReply_time(timestamp);
//		dao.findByPrimaryKey(1);
//		System.out.print(pb_replyVO3.getReply_id() + ",");
//		System.out.print(pb_replyVO3.getPost_id() + ",");
//		System.out.print(pb_replyVO3.getMember_id() + ",");
//		System.out.print(pb_replyVO3.getReply_cont() + ",");
//		System.out.print(pb_replyVO3.getReply_time() + ",");

//
//		// 查詢 --ok
		List<pb_replyVO> list = dao.getAll();
		for (pb_replyVO pbReply : list) {
			System.out.print(pbReply.getReply_id() + ",");
			System.out.print(pbReply.getPost_id() + ",");
			System.out.print(pbReply.getMember_id() + ",");
			System.out.print(pbReply.getReply_cont() + ",");
			System.out.print(pbReply.getReply_time() + ",");
			System.out.println();
		}
	}



}
