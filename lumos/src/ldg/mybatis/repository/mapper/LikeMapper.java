package ldg.mybatis.repository.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import ldg.mybatis.model.Likes;

public interface LikeMapper {

	Integer selectLikeById(int u_id);
	
	Integer selectLikeByTwoId(Map<String, Object> condition);
	
	@Insert("INSERT INTO likes(u_id, push_id) VALUES (#{u_id}, #{push_id})")
	Integer insertLike(Likes likes);

	@Delete("DELETE FROM likes WHERE u_id = #{u_id} and push_id = #{push_id}")
	Integer deleteLike(Map<String, Object> condition);
	
	@Delete("DELETE FROM likes WHERE u_id = #{u_id}")
	Integer deleteLikeByU_id(int u_id);
}
