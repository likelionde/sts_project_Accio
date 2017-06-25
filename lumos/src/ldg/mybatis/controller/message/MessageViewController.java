package ldg.mybatis.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Message;
import ldg.mybatis.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageViewController {
	
	@Autowired
	private MessageService messageservice;
	
	//받은메일함
	@RequestMapping("/box/{u_num}")
	public String recvView(@PathVariable String u_num, Model model) {
		List<Message> recv_m = messageservice.selectRecMessage(u_num);
		if(recv_m == null)
			return "/errors/error";
		
		model.addAttribute("recv_m", recv_m);
		List<Message> send_m = messageservice.selectSendMessage(u_num);
		if(send_m == null)
			return "/errors/error";
		
		model.addAttribute("send_m", send_m);
		return "message/messageBox";
	}

	@RequestMapping("/recv/{m_id}")
	public String recvViewForOne(@PathVariable int m_id, Model model) {
		Message msg = messageservice.selectMessageByPrimaryKey(m_id);
		if(msg == null)
			return "/errors/error";
		model.addAttribute("msg", msg);
		messageservice.flagMessage(m_id);
		return "message/recvMSGForOne";
	}
	@RequestMapping("/send/{m_id}")
	public String sendViewForOne(@PathVariable int m_id, Model model) {
		Message msg = messageservice.selectMessageByPrimaryKey(m_id);
		if(msg == null)
			return "/errors/error";
		model.addAttribute("msg", msg);
		return "message/sendMSGForOne";
	}
}
