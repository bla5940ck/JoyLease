package web.product.model;

import java.io.Serializable;
import java.sql.Date;

public class CartVO implements Serializable{
	private Integer prodID;
	private Date estStart;
	private Date estEnd;
	private String prodName;
	private Integer rent;
	private Integer tatolPrice;
	
	public CartVO(Integer prodID, Date estStart, Date estEnd, String prodName, Integer rent, Integer tatolPrice) {
		super();
		this.prodID = prodID;
		this.estStart = estStart;
		this.estEnd = estEnd;
		this.prodName = prodName;
		this.rent = rent;
		this.tatolPrice = tatolPrice;
	}

	public CartVO() {
		
	}
	
	public Integer getProdID() {
		return prodID;
	}
	public void setProdID(Integer prodID) {
		this.prodID = prodID;
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

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Integer getTatolPrice() {
		return tatolPrice;
	}

	public void setTatolPrice(Integer tatolPrice) {
		this.tatolPrice = tatolPrice;
	}
	
	
}
