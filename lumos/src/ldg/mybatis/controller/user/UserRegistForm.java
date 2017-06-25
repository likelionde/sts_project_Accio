package ldg.mybatis.controller.user;

import java.io.Serializable;

import ldg.mybatis.model.User;

@SuppressWarnings("serial")
public class UserRegistForm implements Serializable {

	private User user;
	private boolean newUser;
	private String confirmPassword;

	public UserRegistForm(User user) {
		this.user = user;
		this.newUser = false;
	}

	public UserRegistForm() {
		this.user = user;
		this.newUser = true;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public boolean isNewUser() {
		return newUser;
	}

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isSamePasswordConfirmPassword() {
		if (user.getPwd() == null || confirmPassword == null)
			return false;
		return user.getPwd().equals(confirmPassword);
	}

	public boolean hasPassword() {
		return user.getPwd() != null && user.getPwd().trim().length() > 0;
	}
}
