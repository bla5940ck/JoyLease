package web.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class PaymentOptionsDAOImpl implements PaymentOptionsDAO_interface {

	private static final String INSERT_STMT = 
			"INSERT INTO PAY_OPTIONS (PAY_ID, PAY_NAME) VALUES (?, ?)";
	private static final String FIND_BY_PK = 
			"SELECT * FROM PAY_OPTIONS WHERE PAY_ID = ?";
	private static final String GET_ALL = 
			"SELECT * FROM PAY_OPTIONS";
	private static final String UPDATE = 
			"UPDATE PAY_OPTIONS SET PAY_NAME = ? WHERE PAY_ID = ?";
	private static final String DELETE = 
			"DELETE FROM PAY_OPTIONS WHERE PAY_ID = ?";
	static {
		try {
			Class.forName(util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPaymentOptions(PaymentOptionsVO paymentOptions) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, paymentOptions.getPayID());
			pstmt.setString(2, paymentOptions.getPayName());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void update(PaymentOptionsVO paymentOptions) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, paymentOptions.getPayName());
			pstmt.setInt(2, paymentOptions.getPayID());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void delete(Integer payID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, payID);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public PaymentOptionsVO findPaymentOptionsByPK(Integer payID) {

		PaymentOptionsVO paymentOptionsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setInt(1, payID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				paymentOptionsVO = new PaymentOptionsVO();
				paymentOptionsVO.setPayID(rs.getInt("PAY_ID"));
				paymentOptionsVO.setPayName(rs.getString("PAY_NAME"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return paymentOptionsVO;
	}

	@Override
	public List<PaymentOptionsVO> getAllPaymentOptions() {
		List<PaymentOptionsVO> list = new ArrayList<PaymentOptionsVO>();
		PaymentOptionsVO paymentOptionsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				paymentOptionsVO = new PaymentOptionsVO();
				paymentOptionsVO.setPayID(rs.getInt("PAY_ID"));
				paymentOptionsVO.setPayName(rs.getString("PAY_NAME"));

				list.add(paymentOptionsVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();
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

		PaymentOptionsDAO_interface podao = new PaymentOptionsDAOImpl();

		// 穝糤
//		PaymentOptionsVO po1 = new PaymentOptionsVO();
//		po1.setPayID(3);
//		po1.setPayName("代刚");
//		podao.addPaymentOptions(po1);

		// э
//		PaymentOptionsVO po4 = new PaymentOptionsVO();
//		po4.setPayName("ATM锣眀");
//		po4.setPayID(3);
//		podao.update(po4);

		// 埃
//		podao.delete(3);

		// 眖PK琩高
		PaymentOptionsVO po2 = podao.findPaymentOptionsByPK(1);
		System.out.println(po2);
//		System.out.println(po2.getPayID() + ",");
//		System.out.println(po2.getPayName() + ",");
		System.out.println("=======================================================");

		// 琩高场
		List<PaymentOptionsVO> list = podao.getAllPaymentOptions();
		for (PaymentOptionsVO po3 : list) {
			System.out.println(po3);
//			System.out.println(po3.getPayID() + ",");
//			System.out.println(po3.getPayName() + ",");
			System.out.println("===================================================");

		}
	}
}
