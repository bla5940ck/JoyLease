package web.order.model;

import java.util.List;

public class PaymentOptionsService {
	
	private PaymentOptionsDAO_interface dao;

	public PaymentOptionsService(PaymentOptionsDAO_interface dao) {
		dao = new PaymentOptionsDAOImpl();
	}
	
	public PaymentOptionsVO addPaymentOptions(Integer payID, String payName) {
		PaymentOptionsVO poVO = new PaymentOptionsVO();
		poVO.setPayID(payID);
		poVO.setPayName(payName);
		
		dao.addPaymentOptions(poVO);
		return poVO;
	}
	
	public PaymentOptionsVO updatePaymentOptions(Integer payID, String payName) {
		PaymentOptionsVO poVO = new PaymentOptionsVO();
		poVO.setPayID(payID);
		poVO.setPayName(payName);
		dao.addPaymentOptions(poVO);
		return poVO;
	}
	
	public PaymentOptionsVO getOnePaymentOptions(Integer payID) {
		return dao.findPaymentOptionsByPK(payID);
	}
	public List<PaymentOptionsVO> getAll(){
		return dao.getAllPaymentOptions();
	}
}
