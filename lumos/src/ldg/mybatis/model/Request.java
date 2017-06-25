package ldg.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Request implements Serializable{
	private int req_id;
	private Sale sale;
	private User user;
	
	public Request() {}
	
	public Request(int req_id, Sale sale, User user) {
		this.req_id = req_id;
		this.sale = sale;
		this.user = user;
	}
	
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
