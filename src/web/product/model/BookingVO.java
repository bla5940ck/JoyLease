package web.product.model;

import java.sql.Date;

public class BookingVO {
	private Integer bkID;
	private Integer prodID;
	private Integer status;
	private Date estStart;
	private Date estEnd;
	
	public BookingVO() {
		super();
	
	}
	
	
	public BookingVO(Integer bkID, Integer prodID, Integer status, Date estStart, Date estEnd) {
		super();
		this.bkID = bkID;
		this.prodID = prodID;
		this.status = status;
		this.estStart = estStart;
		this.estEnd = estEnd;
	}


	public Integer getBkID() {
		return bkID;
	}


	public void setBkID(Integer bkID) {
		this.bkID = bkID;
	}


	public Integer getProdID() {
		return prodID;
	}


	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
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
	
	
}
