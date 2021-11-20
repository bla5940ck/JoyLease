package web.chat_room.model;

import java.sql.Timestamp;

public class chat_roomVO implements java.io.Serializable {
	
	private Integer chat_room_No;
	private Integer rent_id;
	private Integer lease_id;
	private Integer chat_No;
	private String chat_text;
	private Timestamp chat_time;
	
	
	public chat_roomVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public chat_roomVO(Integer chat_room_No, Integer rent_id, Integer lease_id, Integer chat_No, String chat_text,
			Timestamp chat_time) {
		super();
		this.chat_room_No = chat_room_No;
		this.rent_id = rent_id;
		this.lease_id = lease_id;
		this.chat_No = chat_No;
		this.chat_text = chat_text;
		this.chat_time = chat_time;
	}


	/**
	 * @return the chat_room_No
	 */
	public Integer getChat_room_No() {
		return chat_room_No;
	}


	/**
	 * @param chat_room_No the chat_room_No to set
	 */
	public void setChat_room_No(Integer chat_room_No) {
		this.chat_room_No = chat_room_No;
	}


	/**
	 * @return the rent_id
	 */
	public Integer getRent_id() {
		return rent_id;
	}


	/**
	 * @param rent_id the rent_id to set
	 */
	public void setRent_id(Integer rent_id) {
		this.rent_id = rent_id;
	}


	/**
	 * @return the lease_id
	 */
	public Integer getLease_id() {
		return lease_id;
	}


	/**
	 * @param lease_id the lease_id to set
	 */
	public void setLease_id(Integer lease_id) {
		this.lease_id = lease_id;
	}


	/**
	 * @return the chat_No
	 */
	public Integer getChat_No() {
		return chat_No;
	}


	/**
	 * @param chat_No the chat_No to set
	 */
	public void setChat_No(Integer chat_No) {
		this.chat_No = chat_No;
	}


	/**
	 * @return the chat_text
	 */
	public String getChat_text() {
		return chat_text;
	}


	/**
	 * @param chat_text the chat_text to set
	 */
	public void setChat_text(String chat_text) {
		this.chat_text = chat_text;
	}


	/**
	 * @return the chat_time
	 */
	public Timestamp getChat_time() {
		return chat_time;
	}


	/**
	 * @param chat_time the chat_time to set
	 */
	public void setChat_time(Timestamp chat_time) {
		this.chat_time = chat_time;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
