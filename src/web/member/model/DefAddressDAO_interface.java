package web.member.model;

import java.util.*;

public interface DefAddressDAO_interface {
	public void insert(DefAddressVO defAddressVO);
    public void update(DefAddressVO defAddressVO);
//    public void delete( Integer def711);
    public DefAddressVO findByPrimaryKey(Integer def711);
    public List<DefAddressVO> getAll();
    // //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<DefAddressVO> getAll(Map<String, String[]> map); 
}
