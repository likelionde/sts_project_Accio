package ldg.mybatis.controller.chat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.User;

@Controller
public class ChatController {
	
	@RequestMapping("/chat.do")
	public String buy(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loginSession");
		if (user == null)
			return "redirect:/member/login.do";
		if (user.getFlag() == 0)
			return "redirect:/member/email/sendPage.do";
		
		model.addAttribute("user", user);
		return "member/chat";
	}
}
