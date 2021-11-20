package web.member.model;

import java.sql.Timestamp;

public class DefAddressVO {
	
	private Integer def711;
	private Integer memberId;
	private Integer code711;
	private String name711;
	private String add711;
	private Integer status;
	private String recipient;
	private String recptPhone;

	public Integer getDef711() {
		return def711;
	}
	public void setDef711(Integer def711) {
		this.def711 = def711;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getCode711() {
		return code711;
	}
	public void setCode711(Integer code711) {
		this.code711 = code711;
	}
	public String getName711() {
		return name711;
	}
	public void setName711(String name711) {
		this.name711 = name711;
	}
	public String getAdd711() {
		return add711;
	}
	public void setAdd711(String add711) {
		this.add711 = add711;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecptPhone() {
		return recptPhone;
	}
	public void setRecptPhone(String recptPhone) {
		this.recptPhone = recptPhone;
	}
}
