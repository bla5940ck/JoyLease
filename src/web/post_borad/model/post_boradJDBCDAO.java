package web.post_borad.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class post_boradJDBCDAO implements post_boradDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/JoyLease_1115?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = 
			"INSERT INTO post_borad (post_id,category_id,member_id,post_title,post_cont,post_time,reply_count) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT post_id,category_id,member_id,post_title,post_cont,post_time,reply_count FROM post_borad order by post_id";
	private static final String GET_ONE_STMT = 
			"SELECT post_id,category_id,member_id,post_title,post_cont,post_time,reply_count FROM post_borad where post_id = ?";
	private static final String DELETE = 
			"DELETE FROM post_borad where post_id = ?";
	private static final String UPDATE = 
			"UPDATE post_borad set post_id=?, category_id=?, member_id=?, post_title=?, post_cont=?, post_time=? reply_count=? where post_id = ?";

	@Override
	public void insert(post_boradVO post_boradVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, post_boradVO.getPost_id());
			pstmt.setInt(2, post_boradVO.getCategory_id());
			pstmt.setInt(3, post_boradVO.getMember_id());
			pstmt.setString(4, post_boradVO.getPost_title());
			pstmt.setString(5, post_boradVO.getPost_cont());
			pstmt.setTimestamp(6, post_boradVO.getPost_time());
			pstmt.setInt(7, post_boradVO.getReply_count());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(post_boradVO post_boradVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, post_boradVO.getPost_id());
			pstmt.setInt(2, post_boradVO.getCategory_id());
			pstmt.setInt(3, post_boradVO.getMember_id());
			pstmt.setString(4, post_boradVO.getPost_title());
			pstmt.setString(5, post_boradVO.getPost_cont());
			pstmt.setTimestamp(6, post_boradVO.getPost_time());
			pstmt.setInt(7, post_boradVO.getReply_count());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer post_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, post_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public post_boradVO findByPrimaryKey(Integer post_id) {
		post_boradVO post_boradVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, post_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				post_boradVO = new post_boradVO();
				post_boradVO.setPost_id(rs.getInt("post_id"));
				post_boradVO.setCategory_id(rs.getInt("category_id"));
				post_boradVO.setMember_id(rs.getInt("member_id"));
				post_boradVO.setPost_title(rs.getString("post_title"));
				post_boradVO.setPost_cont(rs.getString("post_cont"));
				post_boradVO.setPost_time(rs.getTimestamp("post_time"));
				post_boradVO.setReply_count(rs.getInt("reply_count"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return post_boradVO;
	}

	@Override
	public List<post_boradVO> getAll() {
		List<post_boradVO> list = new ArrayList<post_boradVO>();
		post_boradVO post_boradVO = null;

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
				post_boradVO = new post_boradVO();
				post_boradVO.setPost_id(rs.getInt("post_id"));
				post_boradVO.setCategory_id(rs.getInt("category_id"));
				post_boradVO.setMember_id(rs.getInt("member_id"));
				post_boradVO.setPost_title(rs.getString("post_title"));
				post_boradVO.setPost_cont(rs.getString("post_cont"));
				post_boradVO.setPost_time(rs.getTimestamp("post_time"));
				post_boradVO.setReply_count(rs.getInt("reply_count"));
				list.add(post_boradVO); // Store the row in the list

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		post_boradJDBCDAO dao = new post_boradJDBCDAO();
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);

		// 新增--ok
//		post_boradVO post_boradVO1 = new post_boradVO();
//		post_boradVO1.setPost_id(5);
//		post_boradVO1.setCategory_id(1);
//		post_boradVO1.setMember_id(1);
//		post_boradVO1.setPost_title("test");
//		post_boradVO1.setPost_cont("test");
//		post_boradVO1.setPost_time(timestamp);
//		post_boradVO1.setReply_count(0);
//		dao.insert(post_boradVO1);

//		// 修改--ok
//		post_boradVO post_boradVO2 = new post_boradVO();
//		post_boradVO2.setPost_id(6);
//		post_boradVO2.setCategory_id(1);
//		post_boradVO2.setMember_id(1);
//		post_boradVO2.setPost_title("test");
//		post_boradVO2.setPost_cont("test2");
//		post_boradVO2.setPost_time(timestamp);
//		post_boradVO2.setReply_count(0);
//		dao.insert(post_boradVO2);
//
//		// 刪除--ok
//		dao.delete(6);
//
//		// 查詢--ok
//		post_boradVO pbVO3 = new post_boradVO();
//		pbVO3.setPost_id(1);
//		pbVO3.setCategory_id(1);
//		pbVO3.setMember_id(1);
//		pbVO3.setPost_title("test");
//		pbVO3.setPost_time(timestamp);
//		pbVO3.setReply_count(1);
//		dao.findByPrimaryKey(1);
//		System.out.print(pbVO3.getPost_id() + ",");
//		System.out.print(pbVO3.getCategory_id()+ ",");
//		System.out.print(pbVO3.getMember_id()+ ",");
//		System.out.print(pbVO3.getPost_title()+ ",");
//		System.out.print(pbVO3.getPost_cont()+ ",");
//		System.out.print(pbVO3.getPost_time()+ ",");
//		System.out.print(pbVO3.getReply_count()+ ",");

//		// 查詢--ok
		List<post_boradVO> list = dao.getAll();
		for (post_boradVO pPost : list) {
			System.out.print(pPost.getPost_id() + ",");
			System.out.print(pPost.getCategory_id() + ",");
			System.out.print(pPost.getMember_id() + ",");
			System.out.print(pPost.getPost_title() + ",");
			System.out.print(pPost.getPost_cont() + ",");
			System.out.print(pPost.getPost_time() + ",");
			System.out.print(pPost.getReply_count() + ",");
			System.out.println();
		}
	}

}
