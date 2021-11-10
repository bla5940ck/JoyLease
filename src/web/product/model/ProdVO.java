package web.product.model;

import java.sql.Timestamp;

public class ProdVO {
	private Integer prodID;
	private Integer categoryID;
	private Integer memberID;
	private Integer prodStatus;
	private String prodName;
	private String prodCot;
	private Timestamp shelfDate;
	private Timestamp creationDate;
	private Integer prodRent;
	private Integer prodPrice;
	private byte[] pic1;
	private byte[] pic2;
	private byte[] pic3;
	private String comt;
	
	
	public ProdVO(Integer prodID, Integer categoryID, Integer memberID, Integer prodStatus, String prodName,
			String prodCot, Timestamp shelfDate, Timestamp creationDate, Integer prodRent, Integer prodPrice,
			byte[] pic1, byte[] pic2, byte[] pic3, String comt) {
		super();
		this.prodID = prodID;
		this.categoryID = categoryID;
		this.memberID = memberID;
		this.prodStatus = prodStatus;
		this.prodName = prodName;
		this.prodCot = prodCot;
		this.shelfDate = shelfDate;
		this.creationDate = creationDate;
		this.prodRent = prodRent;
		this.prodPrice = prodPrice;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.comt = comt;
	}
	
	public ProdVO() {
		super();
	
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCot() {
		return prodCot;
	}

	public void setProdCot(String prodCot) {
		this.prodCot = prodCot;
	}

	public Timestamp getShelfDate() {
		return shelfDate;
	}

	public void setShelfDate(Timestamp shelfDate) {
		this.shelfDate = shelfDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getProdRent() {
		return prodRent;
	}

	public void setProdRent(Integer prodRent) {
		this.prodRent = prodRent;
	}

	public Integer getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}

	public byte[] getPic1() {
		return pic1;
	}

	public void setPic1(byte[] pic1) {
		this.pic1 = pic1;
	}

	public byte[] getPic2() {
		return pic2;
	}

	public void setPic2(byte[] pic2) {
		this.pic2 = pic2;
	}

	public byte[] getPic3() {
		return pic3;
	}

	public void setPic3(byte[] pic3) {
		this.pic3 = pic3;
	}

	public String getComt() {
		return comt;
	}

	public void setComt(String comt) {
		this.comt = comt;
	}
	
	
}
