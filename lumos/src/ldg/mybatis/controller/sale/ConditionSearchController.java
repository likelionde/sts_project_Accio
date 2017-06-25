package ldg.mybatis.controller.sale;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.model.Condition;
import ldg.mybatis.model.Sale;
import ldg.mybatis.service.SaleService;

@Controller
@RequestMapping("/sale/salelist.do")
public class ConditionSearchController {

	private static final String CONDITION_SEARCH_FORM = "index";
	@Autowired
	private SaleService saleService;

	@RequestMapping(method = RequestMethod.GET)
	public String sales(@ModelAttribute("conditionSearch")Condition condition, Model model) {
		List<Sale> sales = saleService.selectSale();
		model.addAttribute("sales", sales);
		
		return CONDITION_SEARCH_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String condition(@ModelAttribute("conditionSearch")Condition condition, HttpServletRequest request, HttpSession session,
			 BindingResult result , Model model) throws Exception {
		
		if(condition.getTitle().isEmpty())
			condition.setTitle(null);
		if(condition.getStu_num().isEmpty())
			condition.setStu_num(null);
		if(condition.getPriceStart().isEmpty())
			condition.setPriceStart("0");
		if(condition.getPriceEnd().isEmpty())
			condition.setPriceEnd("100000000");
		
		if (result.hasErrors()) {
			return  "errors/error";
		}
		
		List<Sale> sales = saleService.selectSaleByCondition(condition);
		
		model.addAttribute("sales", sales);
		
        return CONDITION_SEARCH_FORM;
	}

	
	
}
