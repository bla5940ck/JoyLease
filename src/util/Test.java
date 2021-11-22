package util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import web.product.model.BookingDAO;
import web.product.model.BookingVO;
import web.product.model.ProdCategoryDAO;
import web.product.model.ProdCategoryVO;
import web.product.model.ProdDAO;
import web.product.model.ProdVO;

public class Test {

	public static void main(String[] args) throws ParseException {
		ProdDAO proDAO = new ProdDAO();
		ProdVO proVO = new ProdVO();
		ProdCategoryDAO prodCategeoryDAO = new ProdCategoryDAO();
		ProdCategoryVO prodCategoryVO = new ProdCategoryVO();
		BookingVO bk = new BookingVO();
		BookingDAO bkDao = new BookingDAO();
		
//		bk.setProdID(5);
//		bk.setStatus(1);
//		SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-DD");
//		java.util.Date date = df.parse("2021-11-14");
//		bk.setEstStart(new Date(date.getTime()));
//		bk.setEstEnd(new Date(date.getTime()+3*24*60*60*1000));
//		
//		bkDao.add(bk);
		
//		bkDao.delete(7);
		
		System.out.println(bkDao.findBookingByPK(1).getEstEnd());
		System.out.println(bkDao.findBookingByPK(1).getEstStart());
		System.out.println(bkDao.findBookingByPK(1).getStatus());
		System.out.println(bkDao.findBookingByPK(1).getBkID());
//		System.out.println(proDAO.getLastKey());
		
		
//		List<BookingVO> list = bkDao.getAllBooking();
//		for(int i = 0;i<list.size();i++) {
//			System.out.println(" 租借日期: "+list.get(i).getEstStart() + " 歸還日期: "+list.get(i).getEstEnd());
//		}
//		
		
//		bk.setBkID(2);
//		bk.setStatus(1);
//		bkDao.updateBooking(bk);
		
		
		
//		List<BookingVO> list = bkDao.findBookingByProdID(1);
//		for(int i =0;i<list.size();i++) {
//			
//		long j =(list.get(i).getEstEnd().getTime()-list.get(i).getEstStart().getTime())/86400000;
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		for(j=0;j<=2;j++)
//			System.out.println( j+ " " + new Date(list.get(i).getEstStart().getTime()+86400000*j));
//		 
//		 
//		}
		
		
		
//		proVO.setProdID(30);
//		proVO.setCategoryID(3);
//		proVO.setProdName("123");
//		proVO.setProdPrice(10000);
//		proVO.setProdRent(null);
//		proVO.setProdStatus(1);
//		proVO.setProdCot("222");
//		proVO.setComt(null);
//		proDAO.addProduct(proVO);
		
//		
//		List<ProdCategoryVO> list  =prodCategeoryDAO.getAllCategory();
//		for(int i =0;i<list.size();i++) {
//			System.out.println(list.get(i).getCategoryID());
//			System.out.println(list.get(i).getCategoryName());
//			
//		}
//		
//		ProdVO prod = proDAO.findProductByPK(8);
//		System.out.println(prod.getMemberID());
//		System.out.println(prod.getCreationDate());
		
		
		
		
//		List<ProdVO> list = proDAO.getAllProduct();
//		
//		for(int i =0;i<list.size();i++) {
//			System.out.println(list.get(i).getProdName());
//		}
		
		
//		ProdCategoryVO prcy = prodCategeoryDAO.findCategoryByPK(4);
//		System.out.println(prcy.getCategoryName());
		
		
		
		
//		ProdVO vo = proDAO.findProductByPK(11);
//		System.out.println(vo.getPic1().length);
//		System.out.println(vo.getPic2().length);
//		vo.setProdStatus(2);
//		System.out.println(vo.getProdID());
//		System.out.println(vo.getProdStatus());
//		proDAO.updateProduct(vo);
		
	}

}
