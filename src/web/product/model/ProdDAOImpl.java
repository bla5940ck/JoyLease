package web.product.model;

import java.util.List;

public interface ProdDAOImpl {
	public void add(ProdVO prod);
	public void update(ProdVO prod);
	public void deleteProudct(ProdVO prod);
	public ProdVO findProductByPK(Integer prodId);
	public List<ProdVO> getAll();
	public Integer getLastKey();
		
	
	
}
