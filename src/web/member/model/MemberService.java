package web.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}
	
	public MemberVO addMem(String bankCode ,String email, String loginId ,
			String idcn ,String phoneNum ,String password ,Integer status ,String name ,
			String nickName , Date birthday ,String address ,String bankAccount ,String accountName,
			Double rentScore ,Double leaseScore, Timestamp creatDate, byte[] pic ,byte[] idcF ,byte[] idcB,Integer foul) {
		MemberVO memberVO = new MemberVO();
		memberVO.setBankCode(bankCode);
		memberVO.setEmail(email);
		memberVO.setLoginId(loginId);
		memberVO.setIdcn(idcn);
		memberVO.setPhoneNum(phoneNum);
		memberVO.setPassword(password);
		memberVO.setStatus(status);
		memberVO.setName(name);
		memberVO.setNickName(nickName);
		memberVO.setBirthday(birthday);
		memberVO.setAddress(address);
		memberVO.setBankAccount(bankAccount);
		memberVO.setAccountName(accountName);
		memberVO.setRentScore(rentScore);
		memberVO.setLeaseScore(leaseScore);
		memberVO.setCreatDate(creatDate);
		memberVO.setPic(pic);
		memberVO.setIdcF(idcF);
		memberVO.setIdcB(idcB);
		memberVO.setFoul(foul);
		dao.insert(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(String bankCode ,String email, String loginId ,
			String idcn ,String phoneNum ,String password ,Integer status ,String name ,
			String nickName , Date birthday ,String address ,String bankAccount ,String accountName,
			Double rentScore ,Double leaseScore, Timestamp creatDate, byte[] pic ,byte[] idcF ,byte[] idcB,Integer foul) {
		MemberVO memberVO = new MemberVO();
//		memberVO.setMemberId(memberId);
		memberVO.setBankCode(bankCode);
		memberVO.setEmail(email);
		memberVO.setLoginId(loginId);
		memberVO.setIdcn(idcn);
		memberVO.setPhoneNum(phoneNum);
		memberVO.setPassword(password);
		memberVO.setStatus(status);
		memberVO.setName(name);
		memberVO.setNickName(nickName);
		memberVO.setBirthday(birthday);
		memberVO.setAddress(address);
		memberVO.setBankAccount(bankAccount);
		memberVO.setAccountName(accountName);
		memberVO.setRentScore(rentScore);
		memberVO.setLeaseScore(leaseScore);
		memberVO.setCreatDate(creatDate);
		memberVO.setPic(pic);
		memberVO.setIdcF(idcF);
		memberVO.setIdcB(idcB);
		memberVO.setFoul(foul);
		dao.update(memberVO);
		return memberVO;
	}
	
	public MemberVO 	getOneMember(Integer memberId) {
		return dao.findByPrimaryKey(memberId);
	}
	
	public MemberVO 	getLoginMember(String loginId) {
		return dao.findLoginID(loginId);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
}
