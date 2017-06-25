package ldg.mybatis.controller.mypage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Review;
import ldg.mybatis.model.ReviewList;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.User;
import ldg.mybatis.service.ReviewService;
import ldg.mybatis.service.SaleService;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/review")
public class ReviewViewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private UserService userService;
	@Autowired
	private SaleService saleService;

	@RequestMapping("/{stu_num}")
	public String view(@PathVariable String stu_num, Model model) throws Exception {
	
		List<Review> reviews = reviewService.selectReview();
		if(reviews == null)
			return "/errors/error";
		List<ReviewList> mList = new ArrayList<ReviewList>(); 
		List<ReviewList> aList = new ArrayList<ReviewList>(); 

		for (Review r: reviews) {
			ReviewList reviewListMy = new ReviewList();
			ReviewList reviewListAboutMe = new ReviewList();
			User user = userService.selectUserByPrimaryKey(r.getSaleInfo().getUser().getU_id());
			if(user == null)
				return "/errors/error";
			Sale sale = saleService.selectSaleByPrimaryKey(r.getSaleInfo().getSale().getS_id());
			if(sale == null)
				return "/errors/error";
			
			if (stu_num.equals(user.getStu_num())) {
				reviewListMy.setReview(r);
				reviewListMy.setStu_num(stu_num);
				reviewListMy.setsStuNum(sale.getUser().getStu_num());
				mList.add(reviewListMy);
			}
			else if (stu_num.equals(sale.getUser().getStu_num())) {
				reviewListAboutMe.setReview(r);
				reviewListAboutMe.setStu_num(stu_num);
				reviewListAboutMe.setsStuNum(sale.getUser().getStu_num());
				aList.add(reviewListAboutMe);
			}
		}
		model.addAttribute("My", mList);
		model.addAttribute("aboutMe", aList);
		return "mypage/reviewView";
	}
}
