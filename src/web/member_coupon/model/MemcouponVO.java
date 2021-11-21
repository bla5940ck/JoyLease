package web.member_coupon.model;

import java.sql.Date;

public class MemcouponVO implements java.io.Serializable{
	private Integer mem_coupon_id;
	private Integer member_id;
	private Integer coupon_id; 
	private Integer status;
	private Date start_date;
	private Date end_date;
	
	
	public MemcouponVO(Integer mem_coupon_id, Integer member_id, Integer coupon_id, Integer status, Date start_date,
			Date end_date) {
		super();
		this.mem_coupon_id = mem_coupon_id;
		this.member_id = member_id;
		this.coupon_id = coupon_id;
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
	public Integer getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Integer coupon_id) {
		this.coupon_id = coupon_id;
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
