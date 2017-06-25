package ldg.mybatis.controller.mail;

import javax.servlet.http.HttpSession;
import ldg.mybatis.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/email")
public class EmailController {
	
	@Autowired
	private EmailSender emailSender;
    
	@Autowired
	private Email email;
	
	
	@RequestMapping("/sendNumber.do")
	public String regist( HttpSession session, Model model) throws Exception {
		
		User member =(User)session.getAttribute("loginSession");
		if (member == null)
			return "redirect:/member/login.do";

		String to = member.getStu_num() + "@dongduk.ac.kr";
		String ranNum = randomNum();
		
		email.setContent("		인증번호는 [	"+ranNum+"	] 입니다.		");
        email.setReceiver(to);
        email.setSubject("ACCIO 회원 인증 메일입니다.");
        emailSender.SendEmail(email);
	
        //인증번호를 세션에 넣어줌	
		session.setAttribute("ranNum", ranNum );
       
        return "redirect:/member/authentication.do";
	}
		
	private String randomNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<7; i++){
			int n = (int)(Math.random()*10);
			buffer.append(n);
		}
		return buffer.toString();
	}


}
