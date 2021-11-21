package web.member.model;

import java.io.Serializable;

public class BankVO implements Serializable{
	
	private String code;
	private String chineseName;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
}
