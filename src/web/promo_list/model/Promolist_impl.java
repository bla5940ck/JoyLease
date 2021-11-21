package web.promo_list.model;

import java.util.List;
	
	public interface Promolist_impl {
		public void insert(PromolistVO promolistVO);
		public void update(PromolistVO promolistVO);
		public void delete(Integer coupon_id);
		public PromolistVO findByPrimaryKey(Integer coupon_id);
		public List<PromolistVO> getAll();
	
	}


