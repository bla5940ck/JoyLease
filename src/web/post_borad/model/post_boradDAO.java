package web.post_borad.model;

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



public class post_boradDAO implements post_boradDAO_interface {
	
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
			"INSERT INTO post_borad (post_id,category_id,member_id,post_title,post_cont,post_time,reply_count) VALUES (?, ?, ?, ?, ?, ?,?)";
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

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setInt(1, post_boradVO.getPost_id());
					pstmt.setInt(2, post_boradVO.getCategory_id());
					pstmt.setInt(3,  post_boradVO.getMember_id());
					pstmt.setString(4, post_boradVO.getPost_title());
					pstmt.setString(5, post_boradVO.getPost_cont());
					pstmt.setTimestamp(6,  post_boradVO.getPost_time());
					pstmt.setInt(7,  post_boradVO.getReply_count());

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
			public void update(post_boradVO post_boradVO) {
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE);

					pstmt.setInt(1, post_boradVO.getPost_id());
					pstmt.setInt(2, post_boradVO.getCategory_id());
					pstmt.setInt(3,  post_boradVO.getMember_id());
					pstmt.setString(4, post_boradVO.getPost_title());
					pstmt.setString(5, post_boradVO.getPost_cont());
					pstmt.setTimestamp(6,  post_boradVO.getPost_time());
					pstmt.setInt(7,  post_boradVO.getReply_count());

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
			public void delete(Integer post_id) {
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(DELETE);

					pstmt.setInt(1, post_id);

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
			public post_boradVO findByPrimaryKey(Integer post_id) {
				post_boradVO post_boradVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, post_id);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						// empVo 也稱為 Domain objects
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

					con = ds.getConnection();
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
