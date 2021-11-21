package web.promo.model;

import java.util.List;

public class testPromo {
	public static void main(String[] args) {
		Promo_impl dao = new PromoDAO();

		// 新增
//		PromoVO emp1 = new PromoVO();
//		emp1.setPromo_name("David");
//		emp1.setPromo_start(java.sql.Date.valueOf("2016-08-07"));
//		emp1.setPromo_end(java.sql.Date.valueOf("2017-01-01"));
//		emp1.setPromo_text("David");
//		emp1.setStatus(1);
//		dao.insert(emp1);
//
//		// 修改
//		PromoVO emp2 = new PromoVO();
//		emp2.setPromo_id(100004);
//		emp2.setPromo_name("David Jr");
//		emp2.setPromo_start(java.sql.Date.valueOf("2017-08-07"));
//		emp2.setPromo_end(java.sql.Date.valueOf("2018-01-01"));
//		emp2.setPromo_text("DavidTT");
//		emp2.setStatus(0);
//
//		dao.update(emp2);
//
//		// 刪除
//		dao.delete(100004);
//
//		// 查詢
//		PromoVO emp3 = dao.findByPrimaryKey(102);
//		System.out.print(emp3.getPromo_id() + ",");
//		System.out.print(emp3.getPromo_name() + ",");
//		System.out.print(emp3.getPromo_start() + ",");
//		System.out.print(emp3.getPromo_end() + ",");
//		System.out.print(emp3.getPromo_text() + ",");
//		System.out.print(emp3.getStatus() + ",");
//		System.out.println("---------------------");
//
		// 查詢
		List<PromoVO> list = dao.getAll();
		for (PromoVO emp : list) {
			System.out.print(emp.getPromo_id() + ",");
			System.out.print(emp.getPromo_name() + ",");
			System.out.print(emp.getPromo_start() + ",");
			System.out.print(emp.getPromo_end() + ",");
			System.out.print(emp.getPromo_text() + ",");
			System.out.print(emp.getStatus() + ",");
			System.out.println();
		}
	}
}
