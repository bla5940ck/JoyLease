package web.order.model;

import java.util.List;

public class OrderListService {
	
	private OrderListDAO_interface dao;

	public OrderListService() {
		dao = new OrderListDAOImpl();
	}
	
	public OrderListVO addOrderList(Integer listID, Integer prodID, Integer ordID, Integer price) {
		
		OrderListVO olVO = new OrderListVO();
		olVO.setListID(listID);
		olVO.setProdID(prodID);
		olVO.setOrdID(ordID);
		olVO.setPrice(price);
		return olVO;
	}

	public OrderListVO getOneOrderList(Integer listID) {
		return dao.findOrderListByPK(listID);
	}
	
	public List<OrderListVO> getAll(){
		return dao.getAllOrderList();
	}
}
