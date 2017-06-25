package ldg.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.Review;
import ldg.mybatis.repository.mapper.ReviewMapperRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapperRepository reviewRepository;
	
	@Transactional
	public Integer insertReview(Review review) {
		return reviewRepository.insertReview(review);
	}
	public List<Review> selectReview() {
		return reviewRepository.selectReview();
	}
	public Review selectInfo_id(int info_id) {
		return reviewRepository.selectInfo_id(info_id);
	}
	public Integer deleteReview(int r_id) {
		return reviewRepository.deleteReview(r_id);
	}
	public Integer updateReview(Review review) {
		return reviewRepository.updateReview(review);
	}
	public Review selectReviewByPrimaryKey(int r_id) {
		return reviewRepository.selectReviewByPrimaryKey(r_id);
	}
	public Integer deleteReviewByInfo_id(int info_id) {
		return reviewRepository.deleteReviewByInfo_id(info_id);
	}
}
