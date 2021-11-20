package web.chat_room.model;

import java.util.*;

public interface chat_roomDAO_interface {
	
	public void insert(chat_roomVO chat_roomVO);
    public void update(chat_roomVO chat_roomVO);
    public void delete(Integer chat_room_No);
    public chat_roomVO findByPrimaryKey(Integer chat_roomVO);
    public List<chat_roomVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
