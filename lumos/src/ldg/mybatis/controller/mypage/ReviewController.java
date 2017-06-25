package ldg.mybatis.controller.mypage;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ldg.mybatis.model.Review;
import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.model.User;
import ldg.mybatis.service.ReviewService;
import ldg.mybatis.service.SaleInfoService;

@Controller
@RequestMapping("/review/{u_id}/{info_id}")
public class ReviewController {

	private static final String REVIEW_SEND_FORM = "mypage/reviewForm";

	@Autowired
	private SaleInfoService saleInfoService;
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("reviewForm")Review reviewForm,HttpSession session) {
		User user = (User)session.getAttribute("loginSession");
		if(user == null)
			return "redirect:/member/login.do";
		
		return REVIEW_SEND_FORM;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String send(@ModelAttribute("reviewForm")Review reviewForm, HttpServletRequest request,
			 BindingResult result, @PathVariable int u_id, @PathVariable int info_id) throws Exception {
		
		if (result.hasErrors()) {
			return REVIEW_SEND_FORM;
		}
		SaleInfo s_info = saleInfoService.selectInfoByPrimayKey(info_id);
		if(s_info == null)
			return "/errors/error";
		
		Date date = new Date();
		reviewForm.setR_date(date);
		reviewForm.setSaleInfo(s_info);
		reviewForm.setContent(reviewForm.getContent().replace("\r\n","<br>"));
		
		reviewService.insertReview(reviewForm);
		
		return "redirect:/sale/salelist.do";
	}
}
