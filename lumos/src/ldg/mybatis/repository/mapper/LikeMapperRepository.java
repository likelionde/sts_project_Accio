package ldg.mybatis.repository.mapper;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.Likes;

@Repository
public class LikeMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer selectLikeById(int u_id){
		return sqlSession.getMapper(LikeMapper.class).selectLikeById(u_id);
	}

	public Integer selectLikeByTwoId(Map<String, Object> condition){
		return sqlSession.getMapper(LikeMapper.class).selectLikeByTwoId(condition);
	}
	
	public Integer insertLike(Likes likes){
		Integer result = sqlSession.getMapper(LikeMapper.class).insertLike(likes);
		return result;
	}

	public Integer deleteLike(Map<String, Object> condition){
		Integer result = sqlSession.getMapper(LikeMapper.class).deleteLike(condition);
		return result;
	}
	public Integer deleteLikeByU_id(int u_id) {
		return sqlSession.getMapper(LikeMapper.class).deleteLikeByU_id(u_id);
	}

}
