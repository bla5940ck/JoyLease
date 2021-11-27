package web.promo.model;

import java.util.List;

public class testPromoJDBC {
	public static void main(String[] args) {
		Promo_interface dao = new PromoDAO();

	
		PromoVO promovo1 = new PromoVO();
		promovo1.setPromo_name("leo");
		promovo1.setPromo_start(java.sql.Date.valueOf("2021-11-01"));
		promovo1.setPromo_end(java.sql.Date.valueOf("2021-11-30"));
		promovo1.setPromo_text("test");
		promovo1.setStatus(1);
		dao.insert(promovo1);


//		PromoVO promovo2 = new PromoVO();
//		promovo2.setPromo_id(104);
//		promovo2.setPromo_name("leoupdate");
//		promovo2.setPromo_start(java.sql.Date.valueOf("2021-11-10"));
//		promovo2.setPromo_end(java.sql.Date.valueOf("2021-11-20"));
//		promovo2.setPromo_text("testupdate");
//		promovo2.setStatus(0);
//		dao.update(promovo2);

		
//	    dao.delete(104);


//		PromoVO promovo3 = dao.findByPrimaryKey(102);
//		System.out.print(promovo3.getPromo_id() + ",");
//		System.out.print(promovo3.getPromo_name() + ",");
//		System.out.print(promovo3.getPromo_start() + ",");
//		System.out.print(promovo3.getPromo_end() + ",");
//		System.out.print(promovo3.getPromo_text() + ",");
//		System.out.print(promovo3.getStatus() + ",");


//		List<PromoVO> list = dao.getAll();
//		for (PromoVO promovo4 : list) {
//			System.out.print(promovo4.getPromo_id() + ",");
//			System.out.print(promovo4.getPromo_name() + ",");
//			System.out.print(promovo4.getPromo_start() + ",");
//			System.out.print(promovo4.getPromo_end() + ",");
//			System.out.print(promovo4.getPromo_text() + ",");
//			System.out.print(promovo4.getStatus() + ",");
//			System.out.println();
//		}
		
		
	}
}
