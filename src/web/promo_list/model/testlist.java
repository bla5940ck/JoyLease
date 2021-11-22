package web.promo_list.model;

import java.util.List;

public class testlist {
	public static void main(String[] args) {
		Promolist_impl dao = new PromolistDAO();
		PromolistVO promolistVO = new PromolistVO();
		
		// coupon_id, promo_id, category_id, coupon_name, discount, amount, used, start_date, end_date
		
		promolistVO.setPromo_id(103);
		promolistVO.setCategory_id(3);
		promolistVO.setCoupon_name("ddd");
		promolistVO.setDiscount(20.00);
		promolistVO.setAmount(20);
		promolistVO.setUsed(0);
		promolistVO.setStart_date(java.sql.Date.valueOf("2016-08-07"));
		promolistVO.setEnd_date(java.sql.Date.valueOf("2016-08-07"));
		dao.insert(promolistVO);
		
//		PromolistVO emp = dao.findByPrimaryKey(1002);
//		System.out.print(emp.getCoupon_id() + ",");
//		System.out.print(emp.getPromo_id() + ",");
//		System.out.print(emp.getCategory_id() + ",");
//		System.out.print(emp.getCoupon_name() + ",");
//		System.out.print(emp.getDiscount() + ",");
//		System.out.print(emp.getAmount() + ",");
//		System.out.print(emp.getUsed() + ",");
//		System.out.print(emp.getStart_date() + ",");
//		System.out.print(emp.getEnd_date() + ",");
//		System.out.println();
		
//		List<PromolistVO> list = dao.getAll();
//		for (PromolistVO emp : list) {
//			System.out.print(emp.getCoupon_id() + ",");
//			System.out.print(emp.getPromo_id() + ",");
//			System.out.print(emp.getCategory_id() + ",");
//			System.out.print(emp.getCoupon_name() + ",");
//			System.out.print(emp.getDiscount() + ",");
//			System.out.print(emp.getAmount() + ",");
//			System.out.print(emp.getUsed() + ",");
//			System.out.print(emp.getStart_date() + ",");
//			System.out.print(emp.getEnd_date() + ",");
//			System.out.println();}
	}
}
