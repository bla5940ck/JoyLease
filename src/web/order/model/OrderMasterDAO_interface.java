package web.order.model;

import java.util.List;

public interface OrderMasterDAO_interface {
	void addOrderMaster(OrderMasterVO orderMaster);
	void updateOrderMaster(OrderMasterVO orderMaster);
	OrderMasterVO findOrderMasterByPK(Integer ordID);
	List<OrderMasterVO> getAllOrderMaster();
}
