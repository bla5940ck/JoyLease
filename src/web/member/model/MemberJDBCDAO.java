package web.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			"UPDATE member set bank_code	=?,	email	=?,  login_id	=?,	idcn	=?,	phone_num	=?,	password	=?,"
			+"status	=?,	name	=?,	nickname	=?,	birthday	=?,	address	=?,	bank_account	=?, account_name	=?,"
			+ "rent_score	=?,	lease_score	=?,	creat_date	=?,	pic	=?,	idc_f	=?,	idc_b	=?,	foul	=?"
			+ "where member_id = ?";

	
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
			pstmt.setDate(16, memberVO.getCreatDate());
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
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
