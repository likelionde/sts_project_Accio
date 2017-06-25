package ldg.mybatis.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Sale implements Serializable {
	
	private int s_id;
	private String title;
	private String content;
	private int price;
	private String transport;
	private int flag;
	private Date s_date;
	private User user;
	MultipartFile file;
	private String img;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Sale(int s_id, String title, String content, int price, String transport, int flag, Date s_date, User user,
			MultipartFile file, String img) {
		super();
		this.s_id = s_id;
		this.title = title;
		this.content = content;
		this.price = price;
		this.transport = transport;
		this.flag = flag;
		this.s_date = s_date;
		this.user = user;
		this.file = file;
		this.img = img;
	}

	public Sale() {}
	
	public Sale(int s_id, String title, String content, int price, String transport, int flag, Date s_date) {
		this.s_id = s_id;
		this.title = title;
		this.content = content;
		this.price = price;
		this.transport = transport;
		this.flag = 0;
		this.s_date = s_date;
	}
	
	public Sale(int s_id, String title, String content, int price, String transport, int flag, Date s_date,
			User user) {
		super();
		this.s_id = s_id;
		this.title = title;
		this.content = content;
		this.price = price;
		this.transport = transport;
		this.flag = flag;
		this.s_date = s_date;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getS_date() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(s_date);
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

}
