package web.pb_reply.model;

import java.sql.Timestamp;

public class pb_replyVO {
	
	private Integer reply_id;
	private Integer post_id;
	private Integer member_id;
	private String reply_cont;
	private Timestamp reply_time;
	
	public pb_replyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pb_replyVO(Integer reply_id, Integer post_id, Integer member_id, String reply_cont, Timestamp reply_time) {
		super();
		this.reply_id = reply_id;
		this.post_id = post_id;
		this.member_id = member_id;
		this.reply_cont = reply_cont;
		this.reply_time = reply_time;
	}

	/**
	 * @return the reply_id
	 */
	public Integer getReply_id() {
		return reply_id;
	}

	/**
	 * @param reply_id the reply_id to set
	 */
	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
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
	 * @return the reply_cont
	 */
	public String getReply_cont() {
		return reply_cont;
	}

	/**
	 * @param reply_cont the reply_cont to set
	 */
	public void setReply_cont(String reply_cont) {
		this.reply_cont = reply_cont;
	}

	/**
	 * @return the reply_time
	 */
	public Timestamp getReply_time() {
		return reply_time;
	}

	/**
	 * @param reply_time the reply_time to set
	 */
	public void setReply_time(Timestamp reply_time) {
		this.reply_time = reply_time;
	}
	
	
	

}
