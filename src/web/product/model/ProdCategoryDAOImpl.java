package web.product.model;

import java.util.List;

public interface ProdCategoryDAOImpl {
	public ProdCategoryVO findCategoryByPK(int id);
	public List<ProdCategoryVO> getAllCategory();
	public void addCategory(ProdCategoryVO prodCategory);

}
