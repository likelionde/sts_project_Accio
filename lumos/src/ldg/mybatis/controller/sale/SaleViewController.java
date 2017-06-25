package ldg.mybatis.controller.sale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Pick;
import ldg.mybatis.model.Request;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.model.User;
import ldg.mybatis.service.PickService;
import ldg.mybatis.service.RequestService;
import ldg.mybatis.service.ReviewService;
import ldg.mybatis.service.SaleInfoService;
import ldg.mybatis.service.SaleService;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/sale")
public class SaleViewController {
	
	@Autowired
	private PickService pickService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private UserService userService;
	@Autowired
	private RequestService requestservice;
	@Autowired
	private SaleInfoService saleInfoService;
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/saler/{saleId}")
	public String saleList(@PathVariable int saleId, Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("loginSession");
		if (user == null)
			return "redirect:/member/login.do";
		
		if (user.getFlag() == 0)
			return "redirect:/member/authentication.do";
		
		Sale sale = saleService.selectSaleByPrimaryKey(saleId);
		if (sale == null)
			return "/errors/error";
		model.addAttribute("saler", sale);
		
		if (sale.getUser().getU_id() == user.getU_id()) {
			List<Request> requests = requestservice.selectRequest(sale.getS_id());
			model.addAttribute("requests", requests);
		}
			
		Pick pick = new Pick();
		pick.setSale(saleService.selectSaleByPrimaryKey(saleId));
		pick.setUser(userService.selectUserByPrimaryKey(user.getU_id()));
		
		int num = pickService.selectPickByTwoId(pick);
		model.addAttribute("pick", num);
		
		return "sale/saleDetail";
		
	}
	
	@RequestMapping("/saleDestroy/{saleId}")
	public String saleDestroy(@PathVariable int saleId, Model model) {
		//pick,request,saleInfo,review 삭제 후 sale 삭제 가능
		pickService.deletePickByS_id(saleId);
		requestservice.deleteRequestByS_id(saleId);
		
		List<SaleInfo> sInfo = saleInfoService.selectByS_Id(saleId);
		if (sInfo != null) {	
			for (SaleInfo s: sInfo) {
				reviewService.deleteReviewByInfo_id(s.getInfo_id());
			}
		}
		
		saleInfoService.deleteSaleInfoByS_id(saleId);
		
		saleService.deleteSale(saleId);
		return "redirect:/sale/salelist.do";	
	}

	
}