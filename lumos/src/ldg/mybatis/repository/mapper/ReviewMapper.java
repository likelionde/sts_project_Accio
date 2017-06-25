package ldg.mybatis.repository.mapper;

import java.util.List;
import ldg.mybatis.model.Review;

public interface ReviewMapper {

	Integer insertReview(Review review);
	List<Review> selectReview();
	Review selectInfo_id(int info_id);
	Integer deleteReview(int r_id);
	
	Integer updateReview(Review review);
	Review selectReviewByPrimaryKey(int r_id);
	Integer deleteReviewByInfo_id(int info_id);
}
