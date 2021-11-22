package web.promo_list.model;

import java.util.List;

public class PromolistServive {
	
	private Promolist_impl dao;
	public PromolistServive() {
		dao = new PromolistDAO();
	}
	public PromolistVO insert(Integer promo_id, Integer category_id, String coupon_name, Double discount,
			Integer amount, Integer used, java.sql.Date start_date, java.sql.Date end_date) {
		PromolistVO promolistVO = new PromolistVO();
		
		promolistVO.setCategory_id(category_id);
		promolistVO.setCoupon_name(coupon_name);
		promolistVO.setDiscount(discount);
		promolistVO.setAmount(amount);
		promolistVO.setUsed(used);
		promolistVO.setStart_date(start_date);
		promolistVO.setEnd_date(end_date);
		dao.insert(promolistVO);
		
		return promolistVO;
	}
	public PromolistVO update(Integer coupon_id, Integer promo_id, Integer category_id, String coupon_name, Double discount,
			Integer amount, Integer used, java.sql.Date start_date, java.sql.Date end_date) {
		PromolistVO promolistVO = new PromolistVO();

		promolistVO.setCoupon_id(coupon_id);
		promolistVO.setCategory_id(category_id);
		promolistVO.setCoupon_name(coupon_name);
		promolistVO.setDiscount(discount);
		promolistVO.setAmount(amount);
		promolistVO.setUsed(used);
		promolistVO.setStart_date(start_date);
		promolistVO.setEnd_date(end_date);
		dao.update(promolistVO);
		
		return promolistVO;
	}
	public void delete(Integer coupon_id) {
		dao.delete(coupon_id);
	}
	public PromolistVO findByPrimaryKey(Integer coupon_id) {
		return dao.findByPrimaryKey(coupon_id);
	}
	public List<PromolistVO> getAll() {
		return dao.getAll();
	}
	
	
}
