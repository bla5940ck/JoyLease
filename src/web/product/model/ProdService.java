package web.product.model;

import java.sql.Timestamp;
import java.util.List;



public class ProdService {
	private ProdDAOImpl dao;
	public ProdService() {
		dao = new ProdDAO();
	}

	public ProdVO AddProd( Integer cate, String name, String cot, Integer rent,
			Integer price, String comt, byte[] pic1, byte[] pic2, byte[] pic3,Timestamp shelfDate) {
		ProdVO prod = new ProdVO();
		
		prod.setCategoryID(cate);
		prod.setProdName(name);
		prod.setProdRent(rent);
		prod.setProdPrice(price);
		prod.setComt(comt);
		prod.setProdCot(cot);
		prod.setProdStatus(0);// «Ý¤W¬[¥N½X
		prod.setPic1(pic1);
		prod.setPic2(pic2);
		prod.setPic3(pic3);
		prod.setShelfDate(shelfDate);
	
			dao.add(prod);
 			
		return prod;
	}
	public ProdVO updateProd(Integer prodID, Integer cate, String name, String cot, Integer rent,
			Integer price, String comt, byte[] pic1, byte[] pic2, byte[] pic3,Timestamp shelfDate,Integer status) {
		ProdVO prod = new ProdVO();
		prod.setProdID(prodID);
		prod.setCategoryID(cate);
		prod.setProdName(name);
		prod.setProdRent(rent);
		prod.setProdPrice(price);
		prod.setComt(comt);
		prod.setProdCot(cot);
		prod.setProdStatus(status);// !!!
		prod.setPic1(pic1);
		prod.setPic2(pic2);
		prod.setPic3(pic3);
		prod.setShelfDate(shelfDate);
		dao.update(prod);
		
		return prod;
	}
	public List<ProdVO> getAll() {
		return dao.getAll();
	}
	public ProdVO findProductByPK(Integer prodId) {
		return dao.findProductByPK(prodId);
	}

	
}
