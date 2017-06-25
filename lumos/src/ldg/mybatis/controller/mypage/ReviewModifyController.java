package ldg.mybatis.controller.mypage;

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

import ldg.mybatis.model.Review;
import ldg.mybatis.model.User;
import ldg.mybatis.service.ReviewService;

@Controller
@RequestMapping("/reviewModify/{r_id}")
public class ReviewModifyController {

	private static final String REVIEW_MODIFY_FORM = "mypage/reviewModify";

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("reviewForm")Review reviewForm, Model model, @PathVariable int r_id, HttpSession session) {
		User user = (User)session.getAttribute("loginSession");
		if(user == null)
			return "redirect:/member/login.do";
		
		reviewForm = reviewService.selectReviewByPrimaryKey(r_id);
		if (reviewForm == null)
			return "redirect:/sale/salelist.do"; //여기 오류페이지 넣어야함
		reviewForm.setContent(reviewForm.getContent().replace("<br>","\r\n"));
		
		model.addAttribute("review", reviewForm);
		return REVIEW_MODIFY_FORM;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String send(@ModelAttribute("reviewForm")Review reviewForm, HttpServletRequest request,
			 BindingResult result, @PathVariable int r_id) throws Exception {
		
		if (result.hasErrors()) {
			return REVIEW_MODIFY_FORM;
		}
		Review review = reviewService.selectReviewByPrimaryKey(r_id);
		if(review == null)
			return "/errors/error";
		
		Date date = new Date();
		reviewForm.setR_date(date);
		reviewForm.setSaleInfo(review.getSaleInfo());
		reviewForm.setContent(reviewForm.getContent().replace("\r\n","<br>"));
		
		reviewService.updateReview(reviewForm);
		
		return "redirect:/sale/salelist.do";
	}
}
