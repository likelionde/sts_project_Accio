package ldg.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Likes implements Serializable {
	private int u_id;
	private int push_id;

	
	public Likes() { 	}
	
	public Likes(int u_id, int push_id) {
		this.u_id = u_id;
		this.push_id = push_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getPush_id() {
		return push_id;
	}
	public void setPush_id(int push_id) {
		this.push_id = push_id;
	}
	
	
}
