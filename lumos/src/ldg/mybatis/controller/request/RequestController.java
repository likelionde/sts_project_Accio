package ldg.mybatis.controller.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Message;
import ldg.mybatis.model.Request;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.model.User;
import ldg.mybatis.service.MessageService;
import ldg.mybatis.service.RequestService;
import ldg.mybatis.service.SaleInfoService;
import ldg.mybatis.service.SaleService;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private SaleInfoService saleinfoService;
	
	@RequestMapping("/{saleId}/{userId}")
	public String req(@PathVariable int saleId, @PathVariable int userId, Message message){
		Request request = new Request();
		
		Sale sale = saleService.selectSaleByPrimaryKey(saleId);
		if(sale == null)
			return "/errors/error";
		User user = userService.selectUserByPrimaryKey(userId);
		if(user == null)
			return "/errors/error";
		request.setSale(sale);
		request.setUser(user);
		
		requestService.insertRequest(request);
		
		//구매요청시 판매자에게 메세지 보내기
		Date date = new Date();
		message.setContents(sale.getTitle() + "&nbsp;글에 구매요청이 들어왔습니다. \r\n확인해주세요!");
		message.setSend_user("admin");
		message.setM_date(date);
		message.setRec_user(sale.getUser().getStu_num());
		messageService.insertMessage(message);
		return "redirect:/sale/salelist.do";
	}
	
	@RequestMapping("/success/{req_id}")
	public String success(@PathVariable int req_id, Message message, SaleInfo saleinfo) {
		Request request = requestService.selectRequestByPrimaryKey(req_id);
		
//		수락 메세지 보내기
		Date date = new Date();
		message.setContents(request.getUser().getStu_num() + "님의 요청이 수락되었습니다. \r\n글제목 : " + request.getSale().getTitle());
		message.setM_date(date);
		message.setSend_user("admin");
		message.setRec_user(request.getUser().getStu_num());
		messageService.insertMessage(message);
		
		requestService.deleteRequest(request.getUser().getU_id(), request.getSale().getS_id());
		
//		구매 이력 추가하기 
		saleinfo.setSale(request.getSale());
		saleinfo.setUser(request.getUser());
		saleinfo.setInfo_date(date);
		saleinfoService.insertSaleInfo(saleinfo);
		saleService.updateFlag(request.getSale().getS_id());
		return "redirect:/sale/salelist.do";
	}
	
	@RequestMapping("/deny/{req_id}")
	public String deny(@PathVariable int req_id, Message message) {
		Request request = requestService.selectRequestByPrimaryKey(req_id);
		Date date = new Date();

		message.setContents(request.getUser().getStu_num() + "님의 요청이 거절되었습니다. \r\n글제목 : " + request.getSale().getTitle());
		message.setM_date(date);
		message.setSend_user("admin");
		message.setRec_user(request.getUser().getStu_num());
		messageService.insertMessage(message);
		
		requestService.deleteRequest(request.getUser().getU_id(), request.getSale().getS_id());
		return "redirect:/sale/salelist.do";
	}
}
