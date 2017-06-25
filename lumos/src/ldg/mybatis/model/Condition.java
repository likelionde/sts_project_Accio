package ldg.mybatis.model;

public class Condition {
	private String stu_num;
	private String title;
	private String transport;
	private String like;
	private String priceStart;
	private String priceEnd;
	private String img;
	
	
	public Condition() {
		super();
	}


	public Condition(String stu_num, String title, String transport, String like, String priceStart, String priceEnd,
			String img) {
		super();
		this.stu_num = stu_num;
		this.title = title;
		this.transport = transport;
		this.like = like;
		this.priceStart = priceStart;
		this.priceEnd = priceEnd;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTransport() {
		return transport;
	}


	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getPriceStart() {
		return priceStart;
	}

	public String getLike() {
		return like;
	}


	public void setLike(String like) {
		this.like = like;
	}


	public void setPriceStart(String priceStart) {
		
		this.priceStart = priceStart;
	}


	public String getPriceEnd() {
		return priceEnd;
	}


	public void setPriceEnd(String priceEnd) {
	
		this.priceEnd = priceEnd;
	}


	public String getStu_num() {
		return stu_num;
	}


	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

