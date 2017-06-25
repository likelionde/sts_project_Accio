package ldg.mybatis.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.controller.validator.RegistrationValidator;
import ldg.mybatis.model.User;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/member/regist.do")
public class UserRegistrationController {
	private static final String MEMBER_REGISTRATION_FORM = "member/registrationForm";
	

	@Autowired
	private UserService userservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("UserForm")UserRegistForm UserForm) {
		return MEMBER_REGISTRATION_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("UserForm")UserRegistForm UserForm, HttpServletRequest request, HttpSession session,
			 BindingResult result) throws Exception {
		
		new RegistrationValidator().validate(UserForm, result);
		if (result.hasErrors()) {
			return MEMBER_REGISTRATION_FORM;
		}
		User user = new User();
		user.setStu_num(UserForm.getUser().getStu_num());
		user.setPwd(UserForm.getUser().getPwd());
		userservice.insertUser(user);
		
		return "redirect:/sale/salelist.do";
	}


}
