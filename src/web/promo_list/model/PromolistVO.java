package web.promo_list.model;

public class PromolistVO {
	private Integer coupon_id;
	private Integer promo_id; 
	private Integer category_id; 
	private String coupon_name;
	private Double discount; 
	private Integer amount; 
	private Integer used;
	
	
	public PromolistVO(Integer coupon_id, Integer promo_id, Integer category_id, String coupon_name, Double discount,
			Integer amount, Integer used) {
		super();
		this.coupon_id = coupon_id;
		this.promo_id = promo_id;
		this.category_id = category_id;
		this.coupon_name = coupon_name;
		this.discount = discount;
		this.amount = amount;
		this.used = used;
	}
	
	
	public PromolistVO() {
		super();
	}


	public Integer getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Integer coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Integer getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(Integer promo_id) {
		this.promo_id = promo_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getUsed() {
		return used;
	}
	public void setUsed(Integer used) {
		this.used = used;
	}
	
	

}
