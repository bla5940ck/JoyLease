package web.order.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class OrderMasterVO implements Serializable{
	private Integer ordID;
	private Integer rentID; // 承租者編號
	private Integer leaseID; // 出租者編號
	private Integer payID; // 交易方式編碼
	private Integer couponID;
	private Integer shipStatus;
	private Integer payStatus;
	private Integer ordStatus;
	private Timestamp ordDate;
	private String shipCode;
	private String returnCode;
	private String storeCode;
	private Date estStart; // 預計租借起日
	private Date estEnd; // 預計租借訖日
	private Timestamp shipDate; // 實際出貨日期
	private Timestamp arrivalDate;
	private Timestamp returnDate;
	private Integer rentDays;
	private Integer rentRank; // 承租者評分
	private Integer leaseRank;
	private String rentComt; // 承租者評論
	private String leaseComt;
	private Timestamp rentComtdate;
	private Timestamp leaseComtdate;
	private Integer prodPrice; // 商品小計
	private Integer shipFee;
	private Integer ordPrice;
	
	public OrderMasterVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderMasterVO(Integer ordID, Integer rentID, Integer leaseID, Integer payID, Integer couponID,
			Integer shipStatus, Integer payStatus, Integer ordStatus, Timestamp ordDate, String shipCode,
			String returnCode, String storeCode, Date estStart, Date estEnd, Timestamp shipDate,
			Timestamp arrivalDate, Timestamp returnDate, Integer rentDays, Integer rentRank, Integer leaseRank,
			String rentComt, String leaseComt, Timestamp rentComtdate, Timestamp leaseComtdate, Integer prodPrice,
			Integer shipFee, Integer ordPrice) {
		super();
		this.ordID = ordID;
		this.rentID = rentID;
		this.leaseID = leaseID;
		this.payID = payID;
		this.couponID = couponID;
		this.shipStatus = shipStatus;
		this.payStatus = payStatus;
		this.ordStatus = ordStatus;
		this.ordDate = ordDate;
		this.shipCode = shipCode;
		this.returnCode = returnCode;
		this.storeCode = storeCode;
		this.estStart = estStart;
		this.estEnd = estEnd;
		this.shipDate = shipDate;
		this.arrivalDate = arrivalDate;
		this.returnDate = returnDate;
		this.rentDays = rentDays;
		this.rentRank = rentRank;
		this.leaseRank = leaseRank;
		this.rentComt = rentComt;
		this.leaseComt = leaseComt;
		this.rentComtdate = rentComtdate;
		this.leaseComtdate = leaseComtdate;
		this.prodPrice = prodPrice;
		this.shipFee = shipFee;
		this.ordPrice = ordPrice;
	}

	public Integer getOrdID() {
		return ordID;
	}

	public void setOrdID(Integer ordID) {
		this.ordID = ordID;
	}

	public Integer getRentID() {
		return rentID;
	}

	public void setRentID(Integer rentID) {
		this.rentID = rentID;
	}

	public Integer getLeaseID() {
		return leaseID;
	}

	public void setLeaseID(Integer leaseID) {
		this.leaseID = leaseID;
	}

	public Integer getPayID() {
		return payID;
	}

	public void setPayID(Integer payID) {
		this.payID = payID;
	}

	public Integer getCouponID() {
		return couponID;
	}

	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}

	public Integer getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(Integer shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(Integer ordStatus) {
		this.ordStatus = ordStatus;
	}

	public Timestamp getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Timestamp ordDate) {
		this.ordDate = ordDate;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Date getEstStart() {
		return estStart;
	}

	public void setEstStart(Date estStart) {
		this.estStart = estStart;
	}

	public Date getEstEnd() {
		return estEnd;
	}

	public void setEstEnd(Date estEnd) {
		this.estEnd = estEnd;
	}

	public Timestamp getShipDate() {
		return shipDate;
	}

	public void setShipDate(Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	public Timestamp getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getRentDays() {
		return rentDays;
	}

	public void setRentDays(Integer rentDays) {
		this.rentDays = rentDays;
	}

	public Integer getRentRank() {
		return rentRank;
	}

	public void setRentRank(Integer rentRank) {
		this.rentRank = rentRank;
	}

	public Integer getLeaseRank() {
		return leaseRank;
	}

	public void setLeaseRank(Integer leaseRank) {
		this.leaseRank = leaseRank;
	}

	public String getRentComt() {
		return rentComt;
	}

	public void setRentComt(String rentComt) {
		this.rentComt = rentComt;
	}

	public String getLeaseComt() {
		return leaseComt;
	}

	public void setLeaseComt(String leaseComt) {
		this.leaseComt = leaseComt;
	}

	public Timestamp getRentComtdate() {
		return rentComtdate;
	}

	public void setRentComtdate(Timestamp rentComtdate) {
		this.rentComtdate = rentComtdate;
	}

	public Timestamp getLeaseComtdate() {
		return leaseComtdate;
	}

	public void setLeaseComtdate(Timestamp leaseComtdate) {
		this.leaseComtdate = leaseComtdate;
	}

	public Integer getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Integer getShipFee() {
		return shipFee;
	}

	public void setShipFee(Integer shipFee) {
		this.shipFee = shipFee;
	}

	public Integer getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(Integer ordPrice) {
		this.ordPrice = ordPrice;
	}

	@Override
	public String toString() {
		return "OrderMasterVO [ordID=" + ordID + ", rentID=" + rentID + ", leaseID=" + leaseID + ", payID=" + payID
				+ ", couponID=" + couponID + ", shipStatus=" + shipStatus + ", payStatus=" + payStatus + ", ordStatus="
				+ ordStatus + ", ordDate=" + ordDate + ", shipCode=" + shipCode + ", returnCode=" + returnCode
				+ ", storeCode=" + storeCode + ", estStart=" + estStart + ", estEnd=" + estEnd + ", shipDate="
				+ shipDate + ", arrivalDate=" + arrivalDate + ", returnDate=" + returnDate + ", rentDays=" + rentDays
				+ ", rentRank=" + rentRank + ", leaseRank=" + leaseRank + ", rentComt=" + rentComt + ", leaseComt="
				+ leaseComt + ", rentComtdate=" + rentComtdate + ", leaseComtdate=" + leaseComtdate + ", prodPrice="
				+ prodPrice + ", shipFee=" + shipFee + ", ordPrice=" + ordPrice + "]";
	}
	

}
