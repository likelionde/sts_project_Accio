package ldg.mybatis.controller.mail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.model.User;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/member/authentication.do")
public class AuthenticationController {
	
	private static final String AUTH_FORM = "/member/authentication";
	@Autowired
	private UserService emailService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("AuthenticationForm")AuthenticationForm authform, HttpSession session) {
		
		User member =(User)session.getAttribute("loginSession");
		if (member == null)
			return "redirect:/member/login.do";
		
		return AUTH_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("AuthenticationForm")AuthenticationForm authform, HttpSession session,
			 BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "redirect:/sale/salelist.do";
		}
		
		String authNum = (String)session.getAttribute("ranNum");
		if(authNum == null)
			return "/errors/error";
		
		System.out.println("생성된 번호 : " + authNum);
		System.out.println("입력 번호 : " + authform);
		
		if(authNum.equals(authform.getNumber()) == true){
			System.out.println("ok");
			
			User user = (User)session.getAttribute("loginSession");
			if (user == null)
				return "redirect:/member/login.do";
			
			emailService.updateFlag(user.getU_id());

			session.setAttribute("loginSession", (User)emailService.selectUserByPrimaryKey(user.getU_id()));
			return "/auth/success";
		}
		else{
			System.out.println("fail");
			return "/auth/fail";
			}
	}
	

}
