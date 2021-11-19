package web.order.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class OrderMasterDAOImpl implements OrderMasterDAO_interface {

	private static final String INSERT_STMT = 
			"INSERT INTO ORDER_MASTER"
			+ "(RENT_ID, LEASE_ID, PAY_ID, COUPON_ID,"
			+ "ORD_DATE, STORE_CODE ,EST_START, EST_END, RENT_DAYS, PROD_PRICE, SHIP_FEE, ORD_PRICE)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE ORDER_MASTER SET "
			+ "SHIP_STATUS = ?, ORD_STATUS = ?, PAY_STATUS = ?, SHIP_CODE = ?, RETURN_CODE = ?, "
			+ "SHIP_DATE = ?, ARRIVAL_DATE = ?, RETURN_DATE = ?, RENT_RANK = ?, LEASE_RANK = ?, "
			+ "RENT_COMT = ?, LEASE_COMT = ?, RENT_COMTDATE = ?, LEASE_COMTDATE = ? WHERE (ORD_ID = ?)";
	private static final String FIND_BY_PK = 
			"SELECT * FROM ORDER_MASTER WHERE ORD_ID = ?";
	private static final String GET_ALL = 
			"SELECT * FROM ORDER_MASTER";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderMaster(OrderMasterVO orderMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orderMaster.getRentID());
			pstmt.setInt(2, orderMaster.getLeaseID());
			pstmt.setInt(3, orderMaster.getPayID());
			if(orderMaster.getCouponID() == null) {
//				pstmt.setObject(4, orderMaster.getCouponID());
				pstmt.setNull(4, Types.NULL);
			} else {
				pstmt.setInt(4, orderMaster.getCouponID());
			}
			pstmt.setTimestamp(5, orderMaster.getOrdDate());
			pstmt.setString(6, orderMaster.getStoreCode());
			pstmt.setDate(7, orderMaster.getEstStart());
			pstmt.setDate(8, orderMaster.getEstEnd());
			pstmt.setInt(9, orderMaster.getRentDays());
			pstmt.setInt(10, orderMaster.getProdPrice());
			pstmt.setInt(11, orderMaster.getShipFee());
			pstmt.setInt(12, orderMaster.getOrdPrice());

			pstmt.executeUpdate();

		} catch (SQLException e) {

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
	public void updateOrderMaster(OrderMasterVO orderMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, orderMaster.getShipStatus());
			pstmt.setInt(2, orderMaster.getOrdStatus());
			pstmt.setInt(3, orderMaster.getPayStatus());
			pstmt.setString(4, orderMaster.getShipCode());
			pstmt.setString(5, orderMaster.getReturnCode());
			pstmt.setTimestamp(6, orderMaster.getShipDate());
			pstmt.setTimestamp(7, orderMaster.getArrivalDate());
			pstmt.setTimestamp(8, orderMaster.getReturnDate());
			pstmt.setInt(9, orderMaster.getRentRank());
			pstmt.setInt(10, orderMaster.getLeaseRank());
			pstmt.setString(11, orderMaster.getRentComt());
			pstmt.setString(12, orderMaster.getLeaseComt());
			pstmt.setTimestamp(13, orderMaster.getRentComtdate());
			pstmt.setTimestamp(14, orderMaster.getLeaseComtdate());
			pstmt.setInt(15, orderMaster.getOrdID());

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
	public OrderMasterVO findOrderMasterByPK(Integer ordID) {

		OrderMasterVO orderMasterVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setInt(1, ordID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderMasterVO = new OrderMasterVO();
				orderMasterVO.setOrdID(rs.getInt("ORD_ID"));
				orderMasterVO.setRentID(rs.getInt("RENT_ID"));
				orderMasterVO.setLeaseID(rs.getInt("LEASE_ID"));
				orderMasterVO.setPayID(rs.getInt("PAY_ID"));
				orderMasterVO.setCouponID(rs.getInt("COUPON_ID"));
				orderMasterVO.setShipStatus(rs.getInt("SHIP_STATUS"));
				orderMasterVO.setPayStatus(rs.getInt("PAY_STATUS"));
				orderMasterVO.setOrdStatus(rs.getInt("ORD_STATUS"));
				orderMasterVO.setOrdDate(rs.getTimestamp("ORD_DATE"));
				orderMasterVO.setShipCode(rs.getString("SHIP_CODE"));
				orderMasterVO.setReturnCode(rs.getString("RETURN_CODE"));
				orderMasterVO.setStoreCode(rs.getString("STORE_CODE"));
				orderMasterVO.setEstStart(rs.getDate("EST_START"));
				orderMasterVO.setEstEnd(rs.getDate("EST_END"));
				orderMasterVO.setShipDate(rs.getTimestamp("SHIP_DATE"));
				orderMasterVO.setArrivalDate(rs.getTimestamp("ARRIVAL_DATE"));
				orderMasterVO.setReturnDate(rs.getTimestamp("RETURN_DATE"));
				orderMasterVO.setRentDays(rs.getInt("RENT_DAYS"));
				orderMasterVO.setRentRank(rs.getInt("RENT_RANK"));
				orderMasterVO.setLeaseRank(rs.getInt("LEASE_RANK"));
				orderMasterVO.setRentComt(rs.getString("RENT_COMT"));
				orderMasterVO.setLeaseComt(rs.getString("LEASE_COMT"));
				orderMasterVO.setRentComtdate(rs.getTimestamp("RENT_COMTDATE"));
				orderMasterVO.setLeaseComtdate(rs.getTimestamp("LEASE_COMTDATE"));
				orderMasterVO.setProdPrice(rs.getInt("PROD_PRICE"));
				orderMasterVO.setShipFee(rs.getInt("SHIP_FEE"));
				orderMasterVO.setOrdPrice(rs.getInt("ORD_PRICE"));

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
		return orderMasterVO;
	}

	@Override
	public List<OrderMasterVO> getAllOrderMaster() {
		List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();
		OrderMasterVO orderMasterVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderMasterVO = new OrderMasterVO();
				orderMasterVO.setOrdID(rs.getInt("ORD_ID"));
				orderMasterVO.setRentID(rs.getInt("RENT_ID"));
				orderMasterVO.setLeaseID(rs.getInt("LEASE_ID"));
				orderMasterVO.setPayID(rs.getInt("PAY_ID"));
				orderMasterVO.setCouponID(rs.getInt("COUPON_ID"));
				orderMasterVO.setShipStatus(rs.getInt("SHIP_STATUS"));
				orderMasterVO.setPayStatus(rs.getInt("PAY_STATUS"));
				orderMasterVO.setOrdStatus(rs.getInt("ORD_STATUS"));
				orderMasterVO.setOrdDate(rs.getTimestamp("ORD_DATE"));
				orderMasterVO.setShipCode(rs.getString("SHIP_CODE"));
				orderMasterVO.setReturnCode(rs.getString("RETURN_CODE"));
				orderMasterVO.setStoreCode(rs.getString("STORE_CODE"));
				orderMasterVO.setEstStart(rs.getDate("EST_START"));
				orderMasterVO.setEstEnd(rs.getDate("EST_END"));
				orderMasterVO.setShipDate(rs.getTimestamp("SHIP_DATE"));
				orderMasterVO.setArrivalDate(rs.getTimestamp("ARRIVAL_DATE"));
				orderMasterVO.setReturnDate(rs.getTimestamp("RETURN_DATE"));
				orderMasterVO.setRentDays(rs.getInt("RENT_DAYS"));
				orderMasterVO.setRentRank(rs.getInt("RENT_RANK"));
				orderMasterVO.setLeaseRank(rs.getInt("LEASE_RANK"));
				orderMasterVO.setRentComt(rs.getString("RENT_COMT"));
				orderMasterVO.setLeaseComt(rs.getString("LEASE_COMT"));
				orderMasterVO.setRentComtdate(rs.getTimestamp("RENT_COMTDATE"));
				orderMasterVO.setLeaseComtdate(rs.getTimestamp("LEASE_COMTDATE"));
				orderMasterVO.setProdPrice(rs.getInt("PROD_PRICE"));
				orderMasterVO.setShipFee(rs.getInt("SHIP_FEE"));
				orderMasterVO.setOrdPrice(rs.getInt("ORD_PRICE"));

				list.add(orderMasterVO);

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
		OrderMasterDAO_interface omdao = new OrderMasterDAOImpl();

		long datetime = System.currentTimeMillis();
		Timestamp timeStamp = new Timestamp(datetime);
		java.sql.Date date = new java.sql.Date(datetime);
//		Format es = new SimpleDateFormat("yyyy/MM/dd");
//		es.format(date);

		// 新增
//		OrderMasterVO om1 = new OrderMasterVO();
//		om1.setRentID(3);
//		om1.setLeaseID(4);
//		om1.setPayID(1);
//		om1.setCouponID(null);
//		om1.setOrdDate(timeStamp);
//		om1.setStoreCode("19374");
//		om1.setEstStart(date);
//		om1.setEstEnd(date);
//		om1.setRentDays(1);
//		om1.setProdPrice(600);
//		om1.setShipFee(120);
//		om1.setOrdPrice(720);
//		omdao.addOrderMaster(om1);

		// 修改
//		OrderMasterVO om2 = new OrderMasterVO();
//		om2.setShipStatus(9);
//		om2.setOrdStatus(2);
//		om2.setPayStatus(3);
//		om2.setShipCode("11111");
//		om2.setReturnCode("222222");
//		om2.setShipDate(timeStamp);
//		om2.setArrivalDate(timeStamp);
//		om2.setReturnDate(timeStamp);
//		om2.setRentRank(3);
//		om2.setLeaseRank(3);
//		om2.setRentComt("測試1234567");
//		om2.setLeaseComt("讚讚");
//		om2.setRentComtdate(timeStamp);
//		om2.setLeaseComtdate(timeStamp);
//		om2.setOrdID(22);
//		omdao.updateOrderMaster(om2);
//		
		// 從PK找
		OrderMasterVO om3 = omdao.findOrderMasterByPK(20);
		System.out.println(om3);
//		System.out.println(om3.getPayID() + ",");
//		System.out.println(om3.getRentID() + ",");
//		System.out.println(om3.getLeaseID() + ",");
//		System.out.println(om3.getPayID() + ",");
//		System.out.println(om3.getCouponID() + ",");
//		System.out.println(om3.getShipStatus() + ",");
//		System.out.println(om3.getPayStatus() + ",");
//		System.out.println(om3.getOrdStatus() + ",");
//		System.out.println(om3.getOrdDate() + ",");
//		System.out.println(om3.getShipCode() + ",");
//		System.out.println(om3.getReturnCode() + ",");
//		System.out.println(om3.getStoreCode() + ",");
//		System.out.println(om3.getEstStart() + ",");
//		System.out.println(om3.getEstEnd() + ",");
//		System.out.println(om3.getShipDate() + ",");
//		System.out.println(om3.getArrivalDate() + ",");
//		System.out.println(om3.getReturnDate() + ",");
//		System.out.println(om3.getRentDays() + ",");
//		System.out.println(om3.getRentRank() + ",");
//		System.out.println(om3.getLeaseRank() + ",");
//		System.out.println(om3.getRentComt() + ",");
//		System.out.println(om3.getLeaseComt() + ",");
//		System.out.println(om3.getRentComtdate() + ",");
//		System.out.println(om3.getLeaseComtdate() + ",");
//		System.out.println(om3.getProdPrice() + ",");
//		System.out.println(om3.getShipFee() + ",");
//		System.out.println(om3.getOrdPrice() + ",");
//		System.out.println("=========================");

		// 查詢全部
		List<OrderMasterVO> list = omdao.getAllOrderMaster();
		for (OrderMasterVO om4 : list) {
			System.out.println(om4);
//			System.out.println(om4.getPayID() + ",");
//			System.out.println(om4.getRentID() + ",");
//			System.out.println(om4.getLeaseID() + ",");
//			System.out.println(om4.getPayID() + ",");
//			System.out.println(om4.getCouponID() + ",");
//			System.out.println(om4.getShipStatus() + ",");
//			System.out.println(om4.getPayStatus() + ",");
//			System.out.println(om4.getOrdStatus() + ",");
//			System.out.println(om4.getOrdDate() + ",");
//			System.out.println(om4.getShipCode() + ",");
//			System.out.println(om4.getReturnCode() + ",");
//			System.out.println(om4.getStoreCode() + ",");
//			System.out.println(om4.getEstStart() + ",");
//			System.out.println(om4.getEstEnd() + ",");
//			System.out.println(om4.getShipDate() + ",");
//			System.out.println(om4.getArrivalDate() + ",");
//			System.out.println(om4.getReturnDate() + ",");
//			System.out.println(om4.getRentDays() + ",");
//			System.out.println(om4.getRentRank() + ",");
//			System.out.println(om4.getLeaseRank() + ",");
//			System.out.println(om4.getRentComt() + ",");
//			System.out.println(om4.getLeaseComt() + ",");
//			System.out.println(om4.getRentComtdate() + ",");
//			System.out.println(om4.getLeaseComtdate() + ",");
//			System.out.println(om4.getProdPrice() + ",");
//			System.out.println(om4.getShipFee() + ",");
//			System.out.println(om4.getOrdPrice() + ",");
//			System.out.println("=========================");
		}
	}
}
