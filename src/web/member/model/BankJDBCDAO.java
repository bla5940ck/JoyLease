package web.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BankJDBCDAO implements BankDAO_interface {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/JoyLease?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
		"INSERT INTO bank (code,chinese_name) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT code,chinese_name FROM bank order by code";
	private static final String GET_ONE_STMT = 
		"SELECT code,chinese_name FROM bank where code = ?";

	private static final String UPDATE = 
		"UPDATE bank set code=?, chinese_name=? where code = ?";

	@Override
	public void insert(BankVO bankVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, bankVO.getCode());
			pstmt.setString(2, bankVO.getChineseName());
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
	public void update(BankVO bankVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, bankVO.getCode());
				pstmt.setString(2, bankVO.getChineseName());


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
	public BankVO findByPrimaryKey(String code) {
		// TODO Auto-generated method stub
		BankVO bankVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, code);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				bankVO = new BankVO();
				bankVO.setCode(rs.getString("code"));
				bankVO.setChineseName(rs.getString("chineseName"));
		
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
		return bankVO;
	}

	@Override
	public List<BankVO> getAll() {
		List<BankVO> list = new ArrayList<BankVO>();
		BankVO bankVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// bankVO 也稱為 Domain objects
				bankVO = new BankVO();
				bankVO.setCode(rs.getString("code"));
				bankVO.setChineseName(rs.getString("chineseName"));

				list.add(bankVO); // Store the row in the list
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

		BankJDBCDAO dao = new BankJDBCDAO();

		// 新增
//		BankVO bankVO1 = new BankVO();
//		bankVO1.setCode("822");
//		bankVO1.setChineseName("中信");
//
//		dao.insert(bankVO1);

		// 修改
		BankVO bankVO2 = new BankVO();
		bankVO2.setCode("822");
		bankVO2.setChineseName("中國信託");

		dao.update(bankVO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
		BankVO bankVO3 = dao.findByPrimaryKey("822");
		System.out.print(bankVO3.getCode() + ",");
		System.out.print(bankVO3.getChineseName() + ",");

		System.out.println("---------------------");

		// 查詢
		List<BankVO> list = dao.getAll();
		for (BankVO aBank : list) {
			System.out.print(aBank.getCode() + ",");
			System.out.print(aBank.getChineseName() + ",");

			System.out.println();
		}
	}
}
