package ldg.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private int u_id;
	private String pwd;
	private String stu_num;
	private int flag;
	private int like_cnt;
	
	public User() {}
	public User(int u_id, String pwd, String stu_num, int flag) {
		super();
		this.u_id = u_id;
		this.pwd = pwd;
		this.stu_num = stu_num;
		this.flag = flag;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	

}
