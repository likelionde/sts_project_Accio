package ldg.mybatis.controller.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.service.ReviewService;

@Controller
@RequestMapping("/reviewDelete")
public class ReviewDeleteController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/{r_id}")
	public String delete(@PathVariable int r_id) {
		reviewService.deleteReview(r_id);
		return "redirect:/sale/salelist.do";
	}
}
