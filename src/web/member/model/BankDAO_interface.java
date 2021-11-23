package web.member.model;

import java.util.*;

public interface BankDAO_interface {
	public void insert(BankVO bankVO);
    public void update(BankVO bankVO);
//    public void delete(String code);
    public BankVO findByPrimaryKey(String code);
    public List<BankVO> getAll();
    // //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<BankVO> getAll(Map<String, String[]> map); 
}
