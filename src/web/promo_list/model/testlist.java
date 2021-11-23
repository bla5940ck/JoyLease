package web.promo_list.model;

import java.util.List;

public class testlist {
	public static void main(String[] args) {
		
		Promolist_impl dao = new PromolistDAO();
		
		PromolistVO testlist1 = new PromolistVO();
		
		// coupon_id, promo_id, category_id, coupon_name, discount, amount, used, start_date, end_date
//		
//		testlist1.setPromo_id(103);
//		testlist1.setCategory_id(3);
//		testlist1.setCoupon_name("1111");
//		testlist1.setDiscount(20.22);
//		testlist1.setAmount(20);
//		testlist1.setUsed(0);
//		testlist1.setStart_date(java.sql.Date.valueOf("2021-12-20"));
//		testlist1.setEnd_date(java.sql.Date.valueOf("2021-01-05"));
//		dao.insert(testlist1);
		
		
//		
		testlist1.setPromo_id(101);
		testlist1.setCategory_id(1);
		testlist1.setCoupon_name("2777");
		testlist1.setDiscount(88.22);
		testlist1.setAmount(90);
		testlist1.setUsed(10);
		testlist1.setStart_date(java.sql.Date.valueOf("2018-08-07"));
		testlist1.setEnd_date(java.sql.Date.valueOf("2018-08-07"));
		testlist1.setCoupon_id(1010);
		dao.update(testlist1);
		
//		dao.delete(1012);
		
		// INSERT INTO `JoyLease`.`promo_list` (`promo_id`, `category_id`, `coupon_name`, `discount`, `amount`, `used`, `start_date`, `end_date`) VALUES ('103', '2', '22', '30.00', '20', '0', '2021-12-20', '2021-01-05');
		
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
//			System.out.println();
		
	}
}
