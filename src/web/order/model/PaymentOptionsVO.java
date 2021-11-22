package web.order.model;

import java.io.Serializable;

public class PaymentOptionsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer payID;
	private String payName;
	
	
	public PaymentOptionsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentOptionsVO(Integer payID, String payName) {
		super();
		this.payID = payID;
		this.payName = payName;
	}
	
	public Integer getPayID() {
		return payID;
	}
	public void setPayID(Integer payID) {
		this.payID = payID;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	@Override
	public String toString() {
		return "PaymentOptionsVO [payID=" + payID + ", payName=" + payName + "]";
	}
	
}
