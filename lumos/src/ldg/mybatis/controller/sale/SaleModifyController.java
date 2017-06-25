package ldg.mybatis.controller.sale;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import ldg.mybatis.controller.validator.SaleValidator;
import ldg.mybatis.model.Sale;
import ldg.mybatis.service.SaleService;

@Controller
@RequestMapping("/sale/saleModify/{saleId}")
public class SaleModifyController {
	
	private String uploadPath;
	private static final String SALE_FORM = "sale/saleModify";
	
	@Autowired
	private SaleService saleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@PathVariable int saleId, Model model, @ModelAttribute("saleForm")Sale sale) {
		sale = saleService.selectSaleByPrimaryKey(saleId);
		if (sale == null)
			return "/errors/error";
		
		sale.setContent(sale.getContent().replace("<br>","\r\n"));
		model.addAttribute("saler", sale);

		return SALE_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String write(@ModelAttribute("saleForm")Sale sale, @PathVariable int saleId, HttpServletRequest request, HttpSession session,
			 BindingResult result) throws Exception {
		
		new SaleValidator().validate(sale, result);
		if (result.hasErrors()) {
			return SALE_FORM;
		}

		uploadPath = request.getSession().getServletContext().getRealPath("/") + "\\image\\";
		MultipartFile multipartFile = sale.getFile();
		//Random ran = new Random();
		String title = sale.getFile().getOriginalFilename();
	
		Sale oldsale = saleService.selectSaleByPrimaryKey(saleId);
		
			if (!sale.getFile().isEmpty()) {	
				File file = new File(uploadPath, title);
				System.out.println(file.getAbsolutePath());
				multipartFile.transferTo(file);			
			}else{
				
				title = oldsale.getImg();
			}
		
		Date dt = new Date();

		sale.setS_date(dt);
		sale.setS_id(saleId);
		sale.setContent(sale.getContent().replace("\r\n","<br>"));
		sale.setImg(title);
		saleService.updateSale(sale);

		return "redirect:/sale/salelist.do";
	}

}
