package ldg.mybatis.controller.pick;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.model.User;
import ldg.mybatis.service.PickService;
import ldg.mybatis.service.SaleService;
import ldg.mybatis.service.UserService;
import ldg.mybatis.model.Pick;


@Controller
@RequestMapping("/pick/{saleId}")
public class PickController {
	
	@Autowired
	private PickService pickService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String pick(@PathVariable int saleId, Model model, HttpSession session){
		User user = (User)session.getAttribute("loginSession");
		if(user == null)
			return "redirect:/member/login.do";
		
		Pick pick = new Pick();
		pick.setSale(saleService.selectSaleByPrimaryKey(saleId));
		pick.setUser(userService.selectUserByPrimaryKey(user.getU_id()));
		
		int num = pickService.selectPickByTwoId(pick);
		if(num == 0)
			pickService.insertPick(pick);
		else 
			pickService.deletePick(pick);

		return "redirect:/sale/saler/"+saleId;
		
	}
}
