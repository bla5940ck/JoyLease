package web.chat_room.model;

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

public class chat_roomJNDIDAO implements chat_roomDAO_interface{
	
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
			"INSERT INTO chat_room (chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time) VALUES (?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time FROM chat_room order by chat_room_No";
		private static final String GET_ONE_STMT = 
			"SELECT chat_room_No,rent_id,lease_id,chat_No,chat_text,chat_time FROM chat_room where chat_room_No = ?";
		private static final String DELETE = 
			"DELETE FROM chat_room where chat_room_No = ?";
		private static final String UPDATE = 
			"UPDATE chat_room set chat_room_No=?, rent_id=?, lease_id=?, chat_No=?, chat_text=?, chat_time=? where chat_room_No = ?";

	@Override
	public void insert(chat_roomVO chat_roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, chat_roomVO.getChat_room_No());
			pstmt.setInt(2, chat_roomVO.getRent_id());
			pstmt.setInt(3, chat_roomVO.getLease_id());
			pstmt.setInt(4, chat_roomVO.getChat_No());
			pstmt.setString(5, chat_roomVO.getChat_text());
			pstmt.setTimestamp(6, chat_roomVO.getChat_time());

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
	public void update(chat_roomVO chat_roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, chat_roomVO.getChat_room_No());
			pstmt.setInt(2, chat_roomVO.getRent_id());
			pstmt.setInt(3, chat_roomVO.getLease_id());
			pstmt.setInt(4, chat_roomVO.getChat_No());
			pstmt.setString(5, chat_roomVO.getChat_text());
			pstmt.setTimestamp(6, chat_roomVO.getChat_time());

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
	public void delete(Integer chat_room_No) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, chat_room_No);

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
	public chat_roomVO findByPrimaryKey(Integer chat_room_No) {
		chat_roomVO chat_roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO ¤]ºÙ¬° Domain objects
				chat_roomVO = new chat_roomVO();
				chat_roomVO.setChat_room_No(rs.getInt("chat_room_No"));
				chat_roomVO.setRent_id(rs.getInt("rent_id"));
				chat_roomVO.setLease_id(rs.getInt("lease_id"));
				chat_roomVO.setChat_No(rs.getInt("chat_No"));
				chat_roomVO.setChat_text(rs.getString("chat_text"));
				chat_roomVO.setChat_time(rs.getTimestamp("Chat_time"));
				list.add(chat_roomVO); 
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
