package web.product.model;

import java.sql.Date;
import java.util.List;

public class BookingService {
	
	public BookingDAOImpl dao;
	public BookingService() {
		dao = new BookingDAO();
	}
	
	
	public BookingVO addBk(Integer prodID,Integer status ,Date estStart ,Date estEnd) {
		BookingVO bk = new BookingVO();
		
		bk.setProdID(prodID);
		bk.setStatus(status);
		bk.setEstStart(estStart);
		bk.setEstEnd(estEnd);
		
		dao.add(bk);
		
		return bk;
	}
	
	public BookingVO updateBk(Integer bkID,Integer prodID,Integer status ,Date estStart ,Date estEnd) {
		BookingVO bk = new BookingVO();
		bk.setBkID(bkID);
		bk.setProdID(prodID);
		bk.setStatus(status);
		bk.setEstStart(estStart);
		bk.setEstEnd(estEnd);
		
		dao.update(bk);
		return bk;
		
	}
	public void deleteBk(Integer bkID) {
		dao.delete(bkID);
	}
	public BookingVO findBkByPK(Integer bkID) {
		return dao.findBookingByPK(bkID);
	}
	public List<BookingVO> findDateByProdID(Integer bkID) {
		return dao.findDateByProdID(bkID);
	}
	public List<BookingVO> getAll() {
		return dao.getAll();
	}
	
	
}
