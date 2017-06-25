package ldg.mybatis.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Pick;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.model.User;
import ldg.mybatis.service.PickService;
import ldg.mybatis.service.SaleInfoService;
import ldg.mybatis.service.SaleService;


@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private PickService pickService;
	@Autowired
	private SaleInfoService saleinfoService;


	@RequestMapping("/saleList.do")
	public String saleList(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loginSession");
		if (user == null)
			return "redirect:/member/login.do";
		List<Sale> sales = saleService.selectSaleByUserId(user.getU_id());
		if(sales == null)
			return "/errors/error";
		model.addAttribute("sales", sales);
		
		return "mypage/saleList";
	}
	
	@RequestMapping("/pcikList.do")
	public String pickList(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loginSession");
		if (user == null)
			return "redirect:/member/login.do";
		List<Pick> picks = pickService.selectPickById(user.getU_id());
		if(picks==null)
			return "/errors/error";
		model.addAttribute("picks", picks);
		
		return "mypage/pickList";
	}
	@RequestMapping("/buyList.do")
	public String buy(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loginSession");
		if (user == null)
			return "redirect:/member/login.do";
		List<SaleInfo> saleinfos = saleinfoService.selectSaleInfoById(user.getU_id());
		if(saleinfos == null)
			return "/errors/error";
		model.addAttribute("saleinfos", saleinfos);
		
		return "mypage/buyList";
	}
}
