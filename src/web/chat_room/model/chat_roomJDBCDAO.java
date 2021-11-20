package web.chat_room.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Timestamp;

public class chat_roomJDBCDAO implements chat_roomDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/JoyLease_1115?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
		"INSERT INTO chat_room (chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time FROM chat_room order by chat_room_No";
	private static final String GET_ONE_STMT = 
		"SELECT chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time FROM chat_room where chat_room_No = ?";
	private static final String DELETE = 
		"DELETE FROM chat_room where chat_room_No = ?";
	private static final String UPDATE = 
		"UPDATE chat_room set rent_id=?, lease_id=?, chat_No=?, chat_text=?, chat_time=? where chat_room_No = ?";

	@Override
	public void insert(chat_roomVO chat_roomVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, chat_roomVO.getChat_room_No());
				pstmt.setInt(2, chat_roomVO.getRent_id());
				pstmt.setInt(3, chat_roomVO.getLease_id());
				pstmt.setInt(4, chat_roomVO.getChat_No());
				pstmt.setString(5, chat_roomVO.getChat_text());
				pstmt.setTimestamp(6, chat_roomVO.getChat_time());

				pstmt.executeUpdate();
			
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
	public void update(chat_roomVO chat_roomVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, chat_roomVO.getRent_id());
			pstmt.setInt(2, chat_roomVO.getLease_id());
			pstmt.setInt(3, chat_roomVO.getChat_No());
			pstmt.setString(4, chat_roomVO.getChat_text());
			pstmt.setTimestamp(5, chat_roomVO.getChat_time());

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
	public void delete(Integer chat_room_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, chat_room_No);

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
	public chat_roomVO findByPrimaryKey(Integer chat_room_No) {
		chat_roomVO chat_roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, chat_room_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				chat_roomVO = new chat_roomVO();
				chat_roomVO.setChat_room_No(rs.getInt("chat_room_No"));
				chat_roomVO.setRent_id(rs.getInt("rent_id"));
				chat_roomVO.setLease_id(rs.getInt("lease_id"));
				chat_roomVO.setChat_No(rs.getInt("chat_No"));
				chat_roomVO.setChat_text(rs.getString("chat_text"));
				chat_roomVO.setChat_time(rs.getTimestamp("Chat_time"));
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
		return chat_roomVO;
		
	}

	@Override
	public List<chat_roomVO> getAll() {
		List<chat_roomVO> list = new ArrayList<chat_roomVO>();
		chat_roomVO chat_roomVO = null;

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
				chat_roomVO = new chat_roomVO();
				chat_roomVO.setChat_room_No(rs.getInt("chat_room_No"));
				chat_roomVO.setRent_id(rs.getInt("rent_id"));
				chat_roomVO.setLease_id(rs.getInt("lease_id"));
				chat_roomVO.setChat_No(rs.getInt("chat_No"));
				chat_roomVO.setChat_text(rs.getString("chat_text"));
				chat_roomVO.setChat_time(rs.getTimestamp("chat_time"));
				list.add(chat_roomVO); 
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
			chat_roomJDBCDAO dao = new chat_roomJDBCDAO();

			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			
			// 新增--ok
//			chat_roomVO chatVO1 = new chat_roomVO();
//			chatVO1.setChat_room_No(4);
//			chatVO1.setRent_id(1);
//			chatVO1.setLease_id(1);
//			chatVO1.setChat_No(4);
//			chatVO1.setChat_text("test");
//			chatVO1.setChat_time(timestamp);
//			dao.insert(chatVO1);

//			// 修改--ok
//			chat_roomVO chatVO2 = new chat_roomVO();
//			chatVO2.setChat_room_No(5);
//			chatVO2.setRent_id(1);
//			chatVO2.setLease_id(1);
//			chatVO2.setChat_No(4);
//			chatVO2.setChat_text("test2");
//			chatVO2.setChat_time(timestamp);
//			dao.insert(chatVO2);
//
//			// 刪除--ok
//			dao.delete(5);
//
////		// 查詢--ok
//			chat_roomVO chatVO4 = new chat_roomVO();
//			chatVO4.setChat_room_No(2);
//			chatVO4.setRent_id(1);
//			chatVO4.setLease_id(1);
//			chatVO4.setChat_No(2);
//			chatVO4.setChat_text("test");
//			chatVO4.setChat_time(timestamp);
//			dao.findByPrimaryKey(2);
//			System.out.println(chatVO4.getChat_room_No());
//
//			// 查詢--ok
//			List<chat_roomVO> list = dao.getAll();
//			for (chat_roomVO cChat : list) {
//			System.out.print(cChat.getChat_room_No() + ",");
//			System.out.print(cChat.getRent_id() + ",");
//			System.out.print(cChat.getLease_id() + ",");
//			System.out.print(cChat.getChat_No() + ",");
//			System.out.print(cChat.getChat_text() + ",");
//			System.out.print(cChat.getChat_time() + ",");
//			System.out.println();
		}
	}

		
	


