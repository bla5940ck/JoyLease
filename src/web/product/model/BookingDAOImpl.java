package web.product.model;

import java.util.List;

public interface BookingDAOImpl {
	public void add(BookingVO bk);
	public void update(BookingVO bk);
	public void delete(Integer bkID);
	public BookingVO  findBookingByPK(Integer bkID);
	public List<BookingVO> getAll();
	public List<BookingVO> findDateByProdID(Integer prodID);
}
