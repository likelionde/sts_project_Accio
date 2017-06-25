package ldg.mybatis.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.Review;

@Repository
public class ReviewMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer insertReview(Review review) {
		return sqlSession.getMapper(ReviewMapper.class).insertReview(review);
	}
	public List<Review> selectReview() {
		return sqlSession.getMapper(ReviewMapper.class).selectReview();
	}
	public Review selectInfo_id(int info_id) {
		return sqlSession.getMapper(ReviewMapper.class).selectInfo_id(info_id);
	}
	public Integer deleteReview(int r_id) {
		return sqlSession.getMapper(ReviewMapper.class).deleteReview(r_id);
	}
	public Integer updateReview(Review review) {
		return sqlSession.getMapper(ReviewMapper.class).updateReview(review);
	}
	public Review selectReviewByPrimaryKey(int r_id) {
		return sqlSession.getMapper(ReviewMapper.class).selectReviewByPrimaryKey(r_id);
	}
	public Integer deleteReviewByInfo_id(int info_id) {
		return sqlSession.getMapper(ReviewMapper.class).deleteReviewByInfo_id(info_id);
	}
}
