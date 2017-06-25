package ldg.mybatis.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SaleInfo implements Serializable{
	private int info_id;
	private Sale sale;
	private User user;
	private Date info_date;
	
	public SaleInfo() {}
	
	public SaleInfo(int info_id, Sale sale, User user, Date info_date) {
		super();
		this.info_id = info_id;
		this.sale = sale;
		this.user = user;
		this.info_date = info_date;
	}
	
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
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
	public Date getInfo_date() {
		return info_date;
	}
	public void setInfo_date(Date info_date) {
		this.info_date = info_date;
	}

	
	
}
