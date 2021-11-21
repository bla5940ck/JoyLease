package web.member_coupon.model;

import java.util.List;

	public interface Memcoupon_impl {
		public void insert(MemcouponVO memcouponVO);
		public void update(MemcouponVO memcouponVO);
		public void delete(Integer mem_coupon_id);
		public MemcouponVO findByPrimaryKey(Integer mem_coupon_id);
		public List<MemcouponVO> getAll();
		
	}


