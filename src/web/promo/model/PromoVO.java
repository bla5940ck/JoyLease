package web.promo.model;

import java.sql.Date;

public class PromoVO implements java.io.Serializable{
	private Integer promo_id;
	private String promo_name;
	private Date promo_start; 
	private Date promo_end;
	private String promo_text;
	private Integer status;
	
	
	public PromoVO(Integer promo_id, String promo_name, Date promo_start, Date promo_end, String promo_text,
			Integer status) {
		super();
		this.promo_id = promo_id;
		this.promo_name = promo_name;
		this.promo_start = promo_start;
		this.promo_end = promo_end;
		this.promo_text = promo_text;
		this.status = status;
	}
	
	
	public PromoVO() {
		super();
	}


	public Integer getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(Integer promo_id) {
		this.promo_id = promo_id;
	}
	public String getPromo_name() {
		return promo_name;
	}
	public void setPromo_name(String promo_name) {
		this.promo_name = promo_name;
	}
	public Date getPromo_start() {
		return promo_start;
	}
	public void setPromo_start(Date promo_start) {
		this.promo_start = promo_start;
	}
	public Date getPromo_end() {
		return promo_end;
	}
	public void setPromo_end(Date promo_end) {
		this.promo_end = promo_end;
	}
	public String getPromo_text() {
		return promo_text;
	}
	public void setPromo_text(String promo_text) {
		this.promo_text = promo_text;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
