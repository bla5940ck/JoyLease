package web.order.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class OrderMasterService {

	private OrderMasterDAO_interface dao;

	public OrderMasterService() {
		dao = new OrderMasterDAOImpl();
	}

	public OrderMasterVO addOrderMaster(Integer rentID, Integer leaseID, Integer payID, Integer couponID,
			Timestamp ordDate, String storeCode, Date estStart, Date estEnd, Integer rentDays, Integer prodPrice,
			Integer shipFee, Integer ordPrice) {

		OrderMasterVO omVO = new OrderMasterVO();

		omVO.setRentID(rentID);
		omVO.setLeaseID(leaseID);
		omVO.setPayID(payID);
		omVO.setCouponID(couponID);
		omVO.setOrdDate(ordDate);
		omVO.setStoreCode(storeCode);
		omVO.setEstStart(estStart);
		omVO.setEstEnd(estEnd);
		omVO.setRentDays(rentDays);
		omVO.setProdPrice(prodPrice);
		omVO.setShipFee(shipFee);
		omVO.setOrdPrice(ordPrice);
		dao.addOrderMaster(omVO);
		return omVO;

	}

	public OrderMasterVO updateorderMaster(Integer ordID, Integer shipStatus, Integer ordStatus, Integer payStatus,
			String shipCode, String returnCode, Timestamp shipDate, Timestamp arrivalDate, Timestamp returnDate,
			Integer rentRank, Integer leaseRank, String rentComt, String leaseComt, Timestamp rentComtdate,
			Timestamp leaseComtdate) {

		OrderMasterVO omVO = new OrderMasterVO();
		
		omVO.setOrdID(ordID);
		omVO.setShipStatus(shipStatus);
		omVO.setOrdStatus(ordStatus);
		omVO.setPayStatus(payStatus);
		omVO.setShipCode(shipCode);
		omVO.setReturnCode(returnCode);
		omVO.setShipDate(shipDate);
		omVO.setArrivalDate(arrivalDate);
		omVO.setReturnDate(returnDate);
		omVO.setRentRank(rentRank);
		omVO.setLeaseRank(leaseRank);
		omVO.setRentComt(rentComt);
		omVO.setLeaseComt(leaseComt);
		omVO.setRentComtdate(rentComtdate);
		omVO.setLeaseComtdate(leaseComtdate);

		dao.updateOrderMaster(omVO);
		
		return omVO;
	}

	public OrderMasterVO getOneOrderMaster(Integer ordID) {
		return dao.findOrderMasterByPK(ordID);
	}

	public List<OrderMasterVO> getAll() {
		return dao.getAllOrderMaster();

	}
}
