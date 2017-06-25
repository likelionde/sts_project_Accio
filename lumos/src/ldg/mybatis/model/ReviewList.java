package ldg.mybatis.model;

public class ReviewList {

	private Review review;
	private String stu_num;
	private String sStuNum;;
	
	public ReviewList() {}

	
	public ReviewList(Review review, String stu_num, String sStuNum) {
		super();
		this.review = review;
		this.stu_num = stu_num;
		this.sStuNum = sStuNum;
	}


	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getsStuNum() {
		return sStuNum;
	}

	public void setsStuNum(String sStuNum) {
		this.sStuNum = sStuNum;
	}
	
	
	
	
}
