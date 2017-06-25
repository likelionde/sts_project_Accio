package ldg.mybatis.controller.sale;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import ldg.mybatis.controller.validator.SaleValidator;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.User;
import ldg.mybatis.service.SaleService;

@Controller
@RequestMapping("/sale/write.do")
public class SaleController {
	
	private String uploadPath;
	private static final String SALE_FORM = "sale/saleForm";
	
	@Autowired
	private SaleService saleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("saleForm")Sale sale, HttpSession session) {
		User writer = (User)session.getAttribute("loginSession");
		
		if (writer == null)
			return "redirect:/member/login.do";
		
		if (writer.getFlag() == 0)
			return "redirect:/member/authentication.do";
		
		return SALE_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String write(@ModelAttribute("saleForm")Sale sale, HttpServletRequest request, HttpSession session,
			 BindingResult result) throws Exception {
		
		new SaleValidator().validate(sale, result);
		if (result.hasErrors()) {
			return SALE_FORM;
		}
		
		 uploadPath = request.getSession().getServletContext().getRealPath("/") + "\\image\\";
		 MultipartFile multipartFile = sale.getFile();
		 System.out.println(uploadPath);
			String title = sale.getFile().getOriginalFilename();
			System.out.println(title);
			
			if (!sale.getFile().isEmpty()) {	
				File file = new File(uploadPath, title);
				System.out.println(file.getAbsolutePath());
				multipartFile.transferTo(file);			
			}
		
		User writer = (User)session.getAttribute("loginSession");
		if (writer == null)
			return "redirect:/member/login.do";
		
		Date dt = new Date();
		
		sale.setUser(writer);
		sale.setS_date(dt);
		sale.setContent(sale.getContent().replace("\r\n","<br>"));
		sale.setImg(title);
		saleService.insertSale(sale);

		return "redirect:/sale/salelist.do";
	}

}
