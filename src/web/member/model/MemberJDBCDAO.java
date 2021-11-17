package web.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MemberJDBCDAO implements MemberDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/JoyLease?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
			"INSERT INTO member (bank_code, email,login_id,idcn,phone_num,password,status,	name,	nickname,	"
			+ "birthday,	address,	bank_account,	account_name,	rent_score,	lease_score,	creat_date,	pic,	idc_f,	idc_b,	foul) "
			+ "VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT member_id,bank_code, email,login_id,idcn,phone_num,password,status,	name,	nickname,"
			+"birthday,	address,	bank_account,	account_name,	rent_score,	lease_score,	creat_date,	pic,	idc_f,	idc_b,	foul "
			+ "FROM member";
		private static final String GET_ONE_STMT = 
			"SELECT member_id,bank_code, email,login_id,idcn,phone_num,password,status,	name,	nickname,"
			+ "birthday,	address,	bank_account,	account_name,	rent_score,	lease_score,	creat_date,	pic,	idc_f,	idc_b,	foul  "
			+ "FROM member where member_id = ?";
//		private static final String DELETE = 
//			"DELETE FROM member where member_id = ?";
		private static final String UPDATE = 
			"UPDATE member set bank_code=?,	email=?,  login_id=?,	idcn	=?,	phone_num=?,	password=?,status	=?,	name=?,	nickname=?,	birthday	=?,	address=?,	bank_account=?, account_name=?,rent_score=?,	lease_score=?,	creat_date=?,	pic=?,	idc_f=?,	idc_b=?,	foul	=? where (member_id = ?)";

	
	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getBankCode());
			pstmt.setString(2, memberVO.getEmail());
			pstmt.setString(3, memberVO.getLoginId());
			pstmt.setString(4, memberVO.getIdcn());
			pstmt.setString(5, memberVO.getPhoneNum());
			pstmt.setString(6, memberVO.getPassword());
			pstmt.setInt(7, memberVO.getStatus());
			pstmt.setString(8, memberVO.getName());
			pstmt.setString(9, memberVO.getNickName());
			pstmt.setDate(10, memberVO.getBirthday());
			pstmt.setString(11, memberVO.getAddress());
			pstmt.setString(12, memberVO.getBankAccount());
			pstmt.setString(13, memberVO.getAccountName());
			pstmt.setDouble(14, memberVO.getRentScore());
			pstmt.setDouble(15, memberVO.getLeaseScore());
			pstmt.setTimestamp(16, memberVO.getCreatDate());
			pstmt.setBytes(17, memberVO.getPic());
			pstmt.setBytes(18, memberVO.getIdcF());
			pstmt.setBytes(19, memberVO.getIdcB());
			pstmt.setInt(20, memberVO.getFoul());
			
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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getBankCode());
			pstmt.setString(2, memberVO.getEmail());
			pstmt.setString(3, memberVO.getLoginId());
			pstmt.setString(4, memberVO.getIdcn());
			pstmt.setString(5, memberVO.getPhoneNum());
			pstmt.setString(6, memberVO.getPassword());
			pstmt.setInt(7, memberVO.getStatus());
			pstmt.setString(8, memberVO.getName());
			pstmt.setString(9, memberVO.getNickName());
			pstmt.setDate(10, memberVO.getBirthday());
			pstmt.setString(11, memberVO.getAddress());
			pstmt.setString(12, memberVO.getBankAccount());
			pstmt.setString(13, memberVO.getAccountName());
			pstmt.setDouble(14, memberVO.getRentScore());
			pstmt.setDouble(15, memberVO.getLeaseScore());
			pstmt.setTimestamp(16, memberVO.getCreatDate());
			pstmt.setBytes(17, memberVO.getPic());
			pstmt.setBytes(18, memberVO.getIdcF());
			pstmt.setBytes(19, memberVO.getIdcB());
			pstmt.setInt(20, memberVO.getFoul());
			pstmt.setInt(21, memberVO.getMemberId());

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
	public MemberVO findByPrimaryKey(Integer memberId) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberId(rs.getInt("member_id"));
				memberVO.setBankCode(rs.getString("bank_code"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setLoginId(rs.getString("login_id"));
				memberVO.setIdcn(rs.getString("idcn"));
				memberVO.setPhoneNum(rs.getString("phone_num"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setStatus(rs.getInt("status"));
				memberVO.setName(rs.getString("name"));
				memberVO.setNickName(rs.getString("nickname"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setBankAccount(rs.getString("bank_account"));
				memberVO.setRentScore(rs.getDouble("rent_score"));
				memberVO.setLeaseScore(rs.getDouble("lease_score"));
				memberVO.setCreatDate(rs.getTimestamp("creat_date"));
				memberVO.setPic(rs.getBytes("pic"));
				memberVO.setIdcF(rs.getBytes("idc_f"));
				memberVO.setIdcB(rs.getBytes("idc_b"));
				memberVO.setFoul(rs.getInt("foul"));
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
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemberId(rs.getInt("member_id"));
				memberVO.setBankCode(rs.getString("bank_code"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setLoginId(rs.getString("login_id"));
				memberVO.setIdcn(rs.getString("idcn"));
				memberVO.setPhoneNum(rs.getString("phone_num"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setStatus(rs.getInt("status"));
				memberVO.setName(rs.getString("name"));
				memberVO.setNickName(rs.getString("nickname"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setBankAccount(rs.getString("bank_account"));
				memberVO.setRentScore(rs.getDouble("rent_score"));
				memberVO.setLeaseScore(rs.getDouble("lease_score"));
				memberVO.setCreatDate(rs.getTimestamp("creat_date"));
				memberVO.setPic(rs.getBytes("pic"));
				memberVO.setIdcF(rs.getBytes("idc_f"));
				memberVO.setIdcB(rs.getBytes("idc_b"));
				memberVO.setFoul(rs.getInt("foul"));

				list.add(memberVO); // Store the row in the list
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

		MemberJDBCDAO dao = new MemberJDBCDAO();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		// 新增
//				MemberVO memberVO1 = new MemberVO();
//				memberVO1.setBankCode("700");
//				memberVO1.setEmail("abc@gmail.com");
//				memberVO1.setLoginId("tibame");
//				memberVO1.setIdcn("A123456789");
//				memberVO1.setPhoneNum("0988567123");
//				memberVO1.setPassword("123test");
//				memberVO1.setStatus(0);
//				memberVO1.setName("成大天");
//				memberVO1.setNickName("天天");
//				memberVO1.setBirthday(java.sql.Date.valueOf("2002-01-01"));
//				memberVO1.setAddress("台北市中山區型男路1號");
//				memberVO1.setBankAccount("52525882");
//				memberVO1.setAccountName("成大天");
//				memberVO1.setRentScore(4.5);
//				memberVO1.setLeaseScore(4.8);
//				memberVO1.setCreatDate(now);
//				memberVO1.setPic(null);
//				memberVO1.setIdcF(null);
//				memberVO1.setIdcB(null);
//				memberVO1.setFoul(0);
//				dao.insert(memberVO1);
		
		// 修改
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setBankCode("822");
		memberVO2.setEmail("updateabc@gmail.com");
		memberVO2.setLoginId("tibame");
		memberVO2.setIdcn("A123456789");
		memberVO2.setPhoneNum("0988567123");
		memberVO2.setPassword("123test");
		memberVO2.setStatus(0);
		memberVO2.setName("成大天");
		memberVO2.setNickName("天天");
		memberVO2.setBirthday(java.sql.Date.valueOf("2002-01-01"));
		memberVO2.setAddress("台北市中山區型男路1號");
		memberVO2.setBankAccount("52525882");
		memberVO2.setAccountName("成大天");
		memberVO2.setRentScore(4.5);
		memberVO2.setLeaseScore(4.8);
		memberVO2.setCreatDate(now);
		memberVO2.setPic(null);
		memberVO2.setIdcF(null);
		memberVO2.setIdcB(null);
		memberVO2.setFoul(0);
		memberVO2.setMemberId(8);
		dao.update(memberVO2);
		
		
		// 查詢
//		MemberVO memberVO3 = dao.findByPrimaryKey(1);
//		System.out.print(memberVO3.getMemberId() + ",");
//		System.out.print(memberVO3.getBankCode() + ",");
//		System.out.print(memberVO3.getEmail() + ",");
//		System.out.print(memberVO3.getLoginId() + ",");
//		System.out.print(memberVO3.getIdcn() + ",");
//		System.out.print(memberVO3.getPhoneNum() + ",");
//		System.out.print(memberVO3.getPassword() + ",");
//		System.out.print(memberVO3.getStatus() + ",");
//		System.out.print(memberVO3.getName() + ",");
//		System.out.print(memberVO3.getNickName() + ",");
//		System.out.print(memberVO3.getBirthday() + ",");
//		System.out.print(memberVO3.getAddress() + ",");
//		System.out.print(memberVO3.getBankAccount() + ",");
//		System.out.print(memberVO3.getAccountName() + ",");
//		System.out.print(memberVO3.getRentScore() + ",");
//		System.out.print(memberVO3.getLeaseScore() + ",");
//		System.out.print(memberVO3.getCreatDate() + ",");
//		System.out.print(memberVO3.getPic() + ",");
//		System.out.print(memberVO3.getIdcF() + ",");
//		System.out.print(memberVO3.getIdcB() + ",");
//		System.out.println(memberVO3.getFoul());
//		System.out.println("---------------------");
		
		
				// 查詢
//				List<MemberVO> list = dao.getAll();
//				for (MemberVO aMember : list) {
//					System.out.print(aMember.getMemberId() + ", ");
//					System.out.print(aMember.getBankCode() + ", ");
//					System.out.print(aMember.getEmail() + ", ");
//					System.out.print(aMember.getLoginId() + ", ");
//					System.out.print(aMember.getIdcn() + ", ");
//					System.out.print(aMember.getPhoneNum() + ", ");
//					System.out.print(aMember.getPassword()+ ", ");
//					System.out.print(aMember.getStatus() + ", ");
//					System.out.print(aMember.getName() + ", ");
//					System.out.print(aMember.getNickName() + ", ");
//					System.out.print(aMember.getBirthday() + ", ");
//					System.out.print(aMember.getAddress() + ", ");
//					System.out.print(aMember.getBankAccount()+ ", ");
//					System.out.print(aMember.getAccountName() + ", ");
//					System.out.print(aMember.getRentScore() + ", ");
//					System.out.print(aMember.getLeaseScore() + ", ");
//					System.out.print(aMember.getCreatDate() + ", ");
//					System.out.print(aMember.getPic() + ", ");
//					System.out.print(aMember.getIdcF() + ", ");
//					System.out.print(aMember.getIdcB() + ", ");
//					System.out.print(aMember.getFoul());
//					System.out.println();
//				}
	}
}
