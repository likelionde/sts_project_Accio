package ldg.mybatis.controller.validator;

import org.springframework.validation.Validator;
import ldg.mybatis.model.Message;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class MessageValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Message.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "required");
	}
}
