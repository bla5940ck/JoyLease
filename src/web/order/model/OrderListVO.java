package web.order.model;

import java.io.Serializable;

public class OrderListVO implements Serializable {
	private Integer listID;
	private Integer prodID;
	private Integer ordID;
	private Integer price;		//°Ó«~ª÷ÃB
	public OrderListVO(Integer listID, Integer prodID, Integer ordID, Integer price) {
		super();
		this.listID = listID;
		this.prodID = prodID;
		this.ordID = ordID;
		this.price = price;
	}
	public OrderListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getListID() {
		return listID;
	}
	public void setListID(Integer listID) {
		this.listID = listID;
	}
	public Integer getProdID() {
		return prodID;
	}
	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}
	public Integer getOrdID() {
		return ordID;
	}
	public void setOrdID(Integer ordID) {
		this.ordID = ordID;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderListVO [listID=" + listID + ", prodID=" + prodID + ", ordID=" + ordID + ", price=" + price + "]";
	}
	
}
