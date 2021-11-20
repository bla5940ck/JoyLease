package web.member_coupon.model;

import java.util.List;


public class MemcouponInterface {
	
	public interface memcoupon_interface {
		public void insert(MemcouponVO memcoupon);
		public void update(MemcouponVO memcoupon);
		public void delete(MemcouponVO memcoupon);
		public MemcouponVO findByPrimaryKey(Integer memcouponVO);
		public List<MemcouponVO> getAll();
	}

}
