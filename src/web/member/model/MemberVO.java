package web.member.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO {
	private Integer memberId;
	private String bankCode;
	private String email;
	private String loginId;
	private String idcn;
	private String phoneNum;
	private String password;
	private Integer status;
	private String name;
	private String nickName;
	private Date birthday;
	private String address;
	private String bankAccount;
	private String accountName;
	private Double rentScore;
	private Double leaseScore;
	private Timestamp creatDate;
	private byte[] pic;
	private byte[] idcF;
	private byte[] idcB;
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getIdcn() {
		return idcn;
	}
	public void setIdcn(String idcn) {
		this.idcn = idcn;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getRentScore() {
		return rentScore;
	}
	public void setRentScore(Double rentScore) {
		this.rentScore = rentScore;
	}
	public Double getLeaseScore() {
		return leaseScore;
	}
	public void setLeaseScore(Double leaseScore) {
		this.leaseScore = leaseScore;
	}
	public Timestamp getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Timestamp  creatDate) {
		this.creatDate = creatDate;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public byte[] getIdcF() {
		return idcF;
	}
	public void setIdcF(byte[] idcF) {
		this.idcF = idcF;
	}
	public byte[] getIdcB() {
		return idcB;
	}
	public void setIdcB(byte[] idcB) {
		this.idcB = idcB;
	}
	public Integer getFoul() {
		return foul;
	}
	public void setFoul(Integer foul) {
		this.foul = foul;
	}
	private Integer foul;
}
