package ldg.mybatis.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ldg.mybatis.model.Pick;
import ldg.mybatis.model.Request;
import ldg.mybatis.model.Sale;
import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.service.LikeService;
import ldg.mybatis.service.MessageService;
import ldg.mybatis.service.PickService;
import ldg.mybatis.service.RequestService;
import ldg.mybatis.service.ReviewService;
import ldg.mybatis.service.SaleInfoService;
import ldg.mybatis.service.SaleService;
import ldg.mybatis.service.UserService;

@Controller
@RequestMapping("/withdrawal")
public class WithdrawalController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private SaleInfoService saleInfoService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private PickService pickService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/{stu_num}/{u_id}")
	public String withdrawalUser(@PathVariable String stu_num, @PathVariable int u_id, HttpSession session) {
		
		//message '알수없음'으로 바꿈
		messageService.updateMessageRecvUser(stu_num);
		messageService.updateMessageSendUser(stu_num);
		
		List<SaleInfo> sInfo = saleInfoService.selectSaleInfoById(u_id);
		if (sInfo != null) {	
			for (SaleInfo s: sInfo) {
				reviewService.deleteReviewByInfo_id(s.getInfo_id());
			}
		}
		List<Sale> sale = saleService.selectSaleByUserId(u_id);
		for (Sale s: sale) {
			SaleInfo saleInfo = saleInfoService.selectSaleInfoByS_Id(s.getS_id());
			if(saleInfo != null) {
				reviewService.deleteReviewByInfo_id(saleInfo.getInfo_id());
			}
		}
		for (Sale s: sale) {
			Pick pick = pickService.selectPickByS_id(s.getS_id());
			if (pick != null) {
				pickService.deletePickByP_id(pick.getP_id());
			}
		}
		for (Sale s: sale) {
			SaleInfo s_info = saleInfoService.selectSaleInfoByS_Id(s.getS_id());
			if (s_info != null) {
				saleInfoService.deleteSaleInfoByInfo_id(s_info.getInfo_id());
			}
		}
		for (Sale s: sale) {
			List<Request> requests = requestService.selectRequestByS_id(s.getS_id());
			if (requests != null) {
				for (Request r: requests) {
					requestService.deleteRequestByReq_id(r.getReq_id());
				}
			}
		}
		saleInfoService.deleteSaleInfoByU_id(u_id);
		pickService.deletePickByU_id(u_id);
		likeService.deleteLikeByU_id(u_id);
		requestService.deleteRequestByU_id(u_id);
		saleService.deleteSaleByU_id(u_id);
		userService.deleteUser(u_id);
		
		session.setAttribute("loginSession", null);
		return "mypage/withdrawal";
	}
}
