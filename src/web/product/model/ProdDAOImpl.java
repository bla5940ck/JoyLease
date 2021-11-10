package web.product.model;

import java.util.List;

public interface ProdDAOImpl {
	public void addPoduct(ProdVO prod);
	public void updateProduct(ProdVO prod);
	public void deleteProudct(ProdVO prod);
	public ProdVO findProductByPK(Integer prodId);
	public List<ProdVO> getAllProduct();
	
}
