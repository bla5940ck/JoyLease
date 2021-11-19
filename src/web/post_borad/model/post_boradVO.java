package web.post_borad.model;

import java.sql.Timestamp;

public class post_boradVO {
	
	private Integer post_id;
	private Integer category_id;
	private Integer member_id;
	private String post_title;
	private String post_cont;
	private Timestamp post_time;
	private Integer reply_count;
	
	
	public post_boradVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public post_boradVO(Integer post_id, Integer category_id, Integer member_id, String post_title, String post_cont,
			Timestamp post_time, Integer reply_count) {
		super();
		this.post_id = post_id;
		this.category_id = category_id;
		this.member_id = member_id;
		this.post_title = post_title;
		this.post_cont = post_cont;
		this.post_time = post_time;
		this.reply_count = reply_count;
	}


	/**
	 * @return the post_id
	 */
	public Integer getPost_id() {
		return post_id;
	}


	/**
	 * @param post_id the post_id to set
	 */
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}


	/**
	 * @return the category_id
	 */
	public Integer getCategory_id() {
		return category_id;
	}


	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	/**
	 * @return the member_id
	 */
	public Integer getMember_id() {
		return member_id;
	}


	/**
	 * @param member_id the member_id to set
	 */
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}


	/**
	 * @return the post_title
	 */
	public String getPost_title() {
		return post_title;
	}


	/**
	 * @param post_title the post_title to set
	 */
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}


	/**
	 * @return the post_cont
	 */
	public String getPost_cont() {
		return post_cont;
	}


	/**
	 * @param post_cont the post_cont to set
	 */
	public void setPost_cont(String post_cont) {
		this.post_cont = post_cont;
	}


	/**
	 * @return the post_time
	 */
	public Timestamp getPost_time() {
		return post_time;
	}


	/**
	 * @param post_time the post_time to set
	 */
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}


	/**
	 * @return the reply_count
	 */
	public Integer getReply_count() {
		return reply_count;
	}


	/**
	 * @param reply_count the reply_count to set
	 */
	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}
	
	


	
	
	
	

}
