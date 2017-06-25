package ldg.mybatis.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressWarnings("serial")
public class Message implements Serializable{
	
	private int m_id;
	private String contents;
	private Date m_date;
	private String rec_user;
	private String send_user;
	private int flag;
	
	public Message() {
		
	}
	
	public Message(int m_id, String contents, Date m_date, String rec_user, String send_user) {
		this.m_id = m_id;
		this.contents = contents;
		this.m_date = m_date;
		this.rec_user = rec_user;
		this.send_user = send_user;
	}
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getM_date() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(m_date);
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}

	public String getRec_user() {
		return rec_user;
	}

	public void setRec_user(String rec_user) {
		this.rec_user = rec_user;
	}

	public String getSend_user() {
		return send_user;
	}

	public void setSend_user(String send_user) {
		this.send_user = send_user;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
