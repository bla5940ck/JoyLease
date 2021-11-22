package web.promo.model;

public class xxx {
	public static void main(String[] args) {
		Promo_impl dao = new PromoDAO();
		PromoVO emp1 = new PromoVO();
		emp1.setPromo_name("David");
		emp1.setPromo_start(java.sql.Date.valueOf("2016-08-07"));
		emp1.setPromo_end(java.sql.Date.valueOf("2017-01-01"));
		emp1.setPromo_text("David");
		emp1.setStatus(1);
		dao.insert(emp1);}
}
