package ldg.mybatis.controller.message;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.model.User;
import ldg.mybatis.controller.validator.MessageValidator;
import ldg.mybatis.model.Message;
import ldg.mybatis.service.MessageService;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/message/{stu_num}")
public class MessageController {
	private static final String MESSAGE_SEND_FORM = "message/messageSend";
	
	@Autowired
	private MessageService messageservice;
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("messageForm")Message messageForm, @PathVariable String stu_num, Model model) {
		User recv_user = userservice.selectUserByStu_num(stu_num);
		if (recv_user == null)
			return "/errors/error";
		
		model.addAttribute("user", recv_user);
		return MESSAGE_SEND_FORM;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String send(@ModelAttribute("messageForm")Message messageForm, HttpServletRequest request, HttpSession session,
			 BindingResult result, @PathVariable String stu_num, Model model) throws Exception {
		
		new MessageValidator().validate(messageForm, result);
		User recv_user = userservice.selectUserByStu_num(stu_num);
		if(recv_user == null)
			return "/errors/error";
		
		model.addAttribute("user", recv_user);
		if (result.hasErrors()) {
			return MESSAGE_SEND_FORM;
		}
		
		User send_user = (User) session.getAttribute("loginSession");
		if (send_user == null)
			return "redirect:/member/login.do";
		Date dt = new Date();
		messageForm.setRec_user(stu_num);
		messageForm.setM_date(dt);
		messageForm.setSend_user(send_user.getStu_num());
		messageForm.setContents(messageForm.getContents().replace("\r\n","<br>"));

		messageservice.insertMessage(messageForm);
		
		return "message/messageView";
	}

}
