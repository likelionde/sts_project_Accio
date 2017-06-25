package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import ldg.mybatis.model.Request;

public interface RequestMapper {
	
	Integer selectRequestById(int s_id);
	Integer insertRequest(Request req);
	Integer deleteRequest(Map<String, Object> condition);
	List<Request> selectRequest(int s_id);
	Request selectRequestByPrimaryKey(int req_id);
	
	@Delete("DELETE FROM REQUEST WHERE u_id = #{u_id}")
	Integer deleteRequestByU_id(int u_id);
	@Delete("DELETE FROM REQUEST WHERE req_id = #{req_id}")
	Integer deleteRequestByReq_id(int req_id);
	@Delete("DELETE FROM REQUEST WHERE s_id = #{s_id}")
	Integer deleteRequestByS_id(int s_id);
	List<Request> selectRequestByS_id(int s_id);
}
