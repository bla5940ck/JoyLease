package web.order.model;

import java.util.List;

public interface PaymentOptionsDAO_interface {
	void addPaymentOptions (PaymentOptionsVO paymentOptions);
	void update(PaymentOptionsVO paymentOptions);
	void delete(Integer payID);
	PaymentOptionsVO findPaymentOptionsByPK (Integer payID);
	List<PaymentOptionsVO> getAllPaymentOptions();
}
