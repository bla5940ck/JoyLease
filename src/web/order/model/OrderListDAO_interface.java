package web.order.model;

import java.util.List;

public interface OrderListDAO_interface {

	void addOrderList(OrderListVO orderList);	//新增訂單明細
	OrderListVO findOrderListByPK(int listID);	//用pk查詢
	List<OrderListVO> getAllOrderList();		//找全部
	List<OrderListVO> findOrderListByStatus(Integer staus); // 用狀態查詢
}
