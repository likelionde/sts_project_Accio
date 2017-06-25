package ldg.mybatis.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ldg.mybatis.model.User;
import ldg.mybatis.service.UserService;

public class LoginValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stu_num", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required.password");

	}
}
