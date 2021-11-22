package web.product.model;

import java.io.Serializable;
import java.sql.Date;

public class CartVO implements Serializable{
	private Integer prodID;
	private Date estStart;
	private Date estEnd;
	
	public CartVO() {
		
	}
	public CartVO(Integer prodID, Date estStart, Date estEnd) {
		super();
		this.prodID = prodID;
		this.estStart = estStart;
		this.estEnd = estEnd;
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
	
	
}
