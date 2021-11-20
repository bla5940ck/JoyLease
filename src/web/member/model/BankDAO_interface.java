package web.member.model;

import java.util.*;

public interface BankDAO_interface {
	public void insert(BankVO bankVO);
    public void update(BankVO bankVO);
//    public void delete(String code);
    public BankVO findByPrimaryKey(String code);
    public List<BankVO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<BankVO> getAll(Map<String, String[]> map); 
}
