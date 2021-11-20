package web.order.model;

public class PaymentOptionsVO {
	private Integer payID;
	private String payName;
	public PaymentOptionsVO(Integer payID, String payName) {
		super();
		this.payID = payID;
		this.payName = payName;
	}
	public PaymentOptionsVO() {
		super();
		// TODO Auto-generated constructor stub
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
