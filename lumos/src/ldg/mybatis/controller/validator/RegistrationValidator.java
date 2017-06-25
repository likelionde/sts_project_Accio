package ldg.mybatis.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ldg.mybatis.controller.user.UserRegistForm;

public class RegistrationValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistForm.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		UserRegistForm regForm = (UserRegistForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.pwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.stu_num", "required");
	
		if (regForm.hasPassword()) {
			if (regForm.getUser().getPwd().length() < 6)
				errors.rejectValue("user.pwd", "shortPassword");
			else if (!regForm.isSamePasswordConfirmPassword())
				errors.rejectValue("confirmPassword", "notSame");
		}
		
		if (regForm.getUser().getStu_num().length() > 8) {
			errors.rejectValue("user.stu_num", "stu_num.length");
		}
	}
}
