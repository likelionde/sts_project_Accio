package ldg.mybatis.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import ldg.mybatis.model.Sale;

public class SaleValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Sale.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transport", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}
}
