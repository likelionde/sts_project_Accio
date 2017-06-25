package ldg.mybatis.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Review implements Serializable{
	
	private int r_id;
	private SaleInfo saleInfo;
	private String content;
	private Date r_date;
	
	public Review() {}
	
	public Review(int r_id, SaleInfo saleInfo, String content, Date r_date) {
		super();
		this.r_id = r_id;
		this.saleInfo = saleInfo;
		this.content = content;
		this.r_date = r_date;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public SaleInfo getSaleInfo() {
		return saleInfo;
	}
	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getR_date() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(r_date);
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	
	

}
