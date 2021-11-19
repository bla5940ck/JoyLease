package web.promo_list.model;

import java.util.List;


public class PromolistInterface {
	
	public interface promolist_interface {
		public void insert(PromolistVO promolist);
		public void update(PromolistVO promolist);
		public void delete(PromolistVO promolist);
		public PromolistVO findByPrimaryKey(Integer promolistVO);
		public List<PromolistVO> getAll();
	}

}
