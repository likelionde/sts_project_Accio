package ldg.mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.Likes;
import ldg.mybatis.repository.mapper.LikeMapperRepository;

@Service
public class LikeService {
	@Autowired
	private LikeMapperRepository likeRepository;
	
	public Integer selectLikeById(int u_id){
		return likeRepository.selectLikeById(u_id);
	}
	
	public Integer selectLikeByTwoId(int u_id, int push_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		condition.put("push_id", push_id);
		
		return likeRepository.selectLikeByTwoId(condition);
	}

	@Transactional
	public Integer insertLike(Likes likes){
		return likeRepository.insertLike(likes);
	}

	@Transactional
	public Integer deleteLike(int u_id, int push_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		condition.put("push_id", push_id);
		
		return likeRepository.deleteLike(condition);
	}
	public Integer deleteLikeByU_id(int u_id) {
		return likeRepository.deleteLikeByU_id(u_id);
	}
}
