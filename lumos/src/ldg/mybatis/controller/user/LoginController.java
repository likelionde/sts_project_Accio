package ldg.mybatis.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.controller.validator.LoginValidator;
import ldg.mybatis.model.User;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/member/login.do")
public class LoginController {
	
	private static final String LOGIN_FORM = "member/loginForm";
	

	@Autowired
	private UserService userservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("loginForm")User user) {
		return LOGIN_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("loginForm")User user, HttpServletRequest request, HttpSession session,
			 BindingResult result) throws Exception {
		
		new LoginValidator().validate(user, result);
		if (result.hasErrors()) {
			return LOGIN_FORM;
		}
		
		User buyer = userservice.selectUserByStu_num(user.getStu_num());
		session.setAttribute("loginSession", buyer);
		
		return "redirect:/sale/salelist.do";
	}

}

