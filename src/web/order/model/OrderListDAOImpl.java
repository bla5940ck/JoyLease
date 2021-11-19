package web.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class OrderListDAOImpl implements OrderListDAO_interface {

	private static final String INSERT_STMT = 
			"INSERT INTO ORDER_LIST(LIST_ID, PROD_ID, ORD_ID, PRICE) VALUES (?, ?, ?, ?)";
	private static final String FIND_BY_PK = 
			"SELECT * FROM ORDER_LIST WHERE LIST_ID = ?";
	private static final String GET_ALL = 
			"SELECT * FROM ORDER_LIST";

	static {
		try {
			Class.forName(util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void addOrderList(OrderListVO orderList) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orderList.getListID());
			pstmt.setInt(2, orderList.getProdID());
			pstmt.setInt(3, orderList.getOrdID());
			pstmt.setInt(4, orderList.getPrice());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public OrderListVO findOrderListByPK(int listID) {
		OrderListVO orderListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setInt(1, listID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setListID(rs.getInt("LIST_ID"));
				orderListVO.setProdID(rs.getInt("PROD_ID"));
				orderListVO.setOrdID(rs.getInt("ORD_ID"));
				orderListVO.setPrice(rs.getInt("PRICE"));

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return orderListVO;
	}

	@Override
	public List<OrderListVO> getAllOrderList() {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		OrderListVO orderListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setListID(rs.getInt("LIST_ID"));
				orderListVO.setProdID(rs.getInt("PROD_ID"));
				orderListVO.setOrdID(rs.getInt("ORD_ID"));
				orderListVO.setPrice(rs.getInt("PRICE"));
				list.add(orderListVO);

			}

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
		OrderListDAO_interface oldao = new OrderListDAOImpl();

		// 新增
//		OrderListVO ol1 = new OrderListVO();
//		ol1.setListID(2);
//		ol1.setOrdID(1);
//		ol1.setProdID(1);
//		ol1.setPrice(3600);
//		oldao.addOrderList(ol1);

		// 從PK查詢
		OrderListVO ol2 = oldao.findOrderListByPK(2);
		System.out.println(ol2);
//		System.out.println(ol2.getListID() + ",");
//		System.out.println(ol2.getProdID() + ",");
//		System.out.println(ol2.getOrdID() + ",");
//		System.out.println(ol2.getPrice() + ",");
		System.out.println("==========================================");

		// 查詢全部
		List<OrderListVO> list = oldao.getAllOrderList();
		for (OrderListVO ol3 : list) {
			System.out.println(ol3);
//			System.out.println(ol3.getListID() + ",");
//			System.out.println(ol3.getProdID() + ",");
//			System.out.println(ol3.getOrdID() + ",");
//			System.out.println(ol3.getPrice() + ",");
			System.out.println("======================================");
		}

	}

}
