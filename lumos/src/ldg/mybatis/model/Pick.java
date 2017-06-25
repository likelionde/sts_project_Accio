package ldg.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pick  implements Serializable{
	
	private int p_id;
	private Sale sale;
	private User user;
	
	public Pick(int p_id, Sale sale, User user) {
		this.p_id = p_id;
		this.sale = sale;
		this.user = user;
	}
	public Pick(){}
	
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
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
