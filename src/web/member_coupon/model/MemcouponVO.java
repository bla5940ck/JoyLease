package web.member_coupon.model;

import java.sql.Date;

public class MemcouponVO implements java.io.Serializable{
	private Integer mem_coupon_id;
	private Integer member_id;
	private Integer category_id;
	private Integer coupon_id; 
	private Double discount; 
	private String coupon_name; 
	private Integer status;
	private Date start_date;
	private Date end_date;
	
	
	
	public MemcouponVO(Integer mem_coupon_id, Integer member_id, Integer category_id, Integer coupon_id,
			Double discount, String coupon_name, Integer status, Date start_date, Date end_date) {
		super();
		this.mem_coupon_id = mem_coupon_id;
		this.member_id = member_id;
		this.category_id = category_id;
		this.coupon_id = coupon_id;
		this.discount = discount;
		this.coupon_name = coupon_name;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public MemcouponVO() {
		super();
	}

	public Integer getMem_coupon_id() {
		return mem_coupon_id;
	}
	public void setMem_coupon_id(Integer mem_coupon_id) {
		this.mem_coupon_id = mem_coupon_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Integer coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
	
	
}
