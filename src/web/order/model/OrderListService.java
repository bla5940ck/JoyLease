package web.order.model;

import java.sql.Date;
import java.util.List;

public class OrderListService {
	
	private OrderListDAO_interface dao;

	public OrderListService() {
		dao = new OrderListDAOImpl();
	}
	
	public OrderListVO addOrderList(Integer listID, Integer prodID, Integer ordID, Integer price, Integer status, Date estStart, Date estEnd) {
		
		OrderListVO olVO = new OrderListVO();
		olVO.setListID(listID);
		olVO.setProdID(prodID);
		olVO.setOrdID(ordID);
		olVO.setPrice(price);
		olVO.setStatus(status);
		olVO.setEstStart(estStart);
		olVO.setEstEnd(estEnd);
		return olVO;
	}

	public OrderListVO getOneOrderList(Integer listID) {
		return dao.findOrderListByPK(listID);
	}
	
	public List<OrderListVO> getAll(){
		return dao.getAllOrderList();
	}
}
