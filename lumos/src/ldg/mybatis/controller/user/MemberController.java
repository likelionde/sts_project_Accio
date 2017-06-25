package ldg.mybatis.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.User;
import ldg.mybatis.model.Likes;
import ldg.mybatis.model.Review;
import ldg.mybatis.model.ReviewList;
import ldg.mybatis.model.Sale;
import ldg.mybatis.service.UserService;
import ldg.mybatis.service.LikeService;
import ldg.mybatis.service.ReviewService;
import ldg.mybatis.service.SaleService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private LikeService likeservice;
	@Autowired
	private SaleService saleService;
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.setAttribute("loginSession", null);
		return "redirect:/sale/salelist.do";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage(HttpSession session, Model model) {
		User user = (User)session.getAttribute("loginSession");
		if(user == null)
			return "redirect:/member/login.do";
		
		model.addAttribute("detail", user);
		
		return "/mypage/mypageForm";
	}
	
	@RequestMapping("/detail/{memberId}")
	public String memberDetail(@PathVariable int memberId, Model model) {
		User user = userservice.selectUserByPrimaryKey(memberId);
		if (user == null) {
			return "/errors/error";
		}
		int like = likeservice.selectLikeById(memberId);
		List<Sale> sales = saleService.selectSaleByUserId(memberId);
		if(sales == null)
			return "/errors/error";
		model.addAttribute("sales", sales);
		model.addAttribute("like",like);
		model.addAttribute("member", user);
		
		//¸®ºäÃâ·Â
		List<Review> reviews = reviewService.selectReview();

		List<ReviewList> rList = new ArrayList<ReviewList>(); 
		for (Review r: reviews) {
			ReviewList reviewList = new ReviewList();
			User rUser = userservice.selectUserByPrimaryKey(r.getSaleInfo().getUser().getU_id());
			Sale sale = saleService.selectSaleByPrimaryKey(r.getSaleInfo().getSale().getS_id());
				if (user.getStu_num().equals(sale.getUser().getStu_num())) {
					reviewList.setReview(r);
					reviewList.setStu_num(rUser.getStu_num());
					reviewList.setsStuNum(sale.getUser().getStu_num());
					rList.add(reviewList);
				}
		}
		model.addAttribute("review", rList);
		
		return "member/memberDetail";
	}
	
	@RequestMapping("/like/{memberId}")
	public String pushLike(@PathVariable int memberId, Model model, HttpSession session) {
		User user = (User)session.getAttribute("loginSession");
		if(user == null)
			return "redirect:/member/login.do";
		
		Likes like = new Likes();
		like.setU_id(memberId);
		like.setPush_id(user.getU_id());
		
		int num = likeservice.selectLikeByTwoId(memberId, user.getU_id());
		if(num == 1) {
			likeservice.deleteLike(memberId, user.getU_id());
			userservice.updateLike(likeservice.selectLikeById(memberId), memberId);
		}
		else {
			likeservice.insertLike(like);
			userservice.updateLike(likeservice.selectLikeById(memberId), memberId);
		}
		
		return memberDetail(memberId, model);
		
	}
	
	
}


