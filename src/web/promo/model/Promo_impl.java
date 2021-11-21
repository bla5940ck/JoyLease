package web.promo.model;

import java.util.List;

	public interface Promo_impl {
		public void insert(PromoVO promoVO);
		public void update(PromoVO promoVO);
		public void delete(Integer promo_id);
		public PromoVO findByPrimaryKey(Integer promo_id);
		public List<PromoVO> getAll();
		
	}


