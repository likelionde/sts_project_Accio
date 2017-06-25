package ldg.mybatis.controller.mail;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuthenticationForm implements Serializable{

	public AuthenticationForm() {}
		

	public AuthenticationForm(String number) {
		super();
		this.number = number;
	}


	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
