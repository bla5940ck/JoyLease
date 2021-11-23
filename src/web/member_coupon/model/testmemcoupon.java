package web.member_coupon.model;

import java.util.List;

public class testmemcoupon {
	public static void main(String[] args) {
	Memcoupon_impl dao = new MemcouponDAO();
	
	MemcouponVO VO = new MemcouponVO();
	
//	VO.setMember_id(2);
//	VO.setCategory_id(2);
//	VO.setCoupon_id(1003);
//	VO.setCoupon_name("ooo");
//	VO.setDiscount(10.00);
//	VO.setStatus(1);
//	VO.setStart_date(java.sql.Date.valueOf("2021-12-20"));
//	VO.setEnd_date(java.sql.Date.valueOf("2023-12-20"));
//	VO.setMem_coupon_id(10000010);
//	dao.update(VO);
	
	dao.delete(10000010);
	
//	MemcouponVO VO1 = dao.findByPrimaryKey(10002);
//	System.out.print(VO1.getCoupon_id() + ",");

//	List<MemcouponVO> list = dao.getAll();
//	for (MemcouponVO emp : list) {
//		System.out.print(emp.getCoupon_id() + ",");
//		System.out.print(emp.getCategory_id() + ",");
//		System.out.print(emp.getCoupon_name() + ",");
//		System.out.print(emp.getDiscount() + ",");
//		System.out.print(emp.getStatus() + ",");
//		System.out.print(emp.getMem_coupon_id() + ",");
//		System.out.print(emp.getStart_date() + ",");
//		System.out.print(emp.getEnd_date() + ",");
//		System.out.println();}

	}

}
