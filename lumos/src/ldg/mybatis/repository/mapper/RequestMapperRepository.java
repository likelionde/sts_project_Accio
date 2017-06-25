package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.Request;

@Repository
public class RequestMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer selectRequestById(int s_id){
		return sqlSession.getMapper(RequestMapper.class).selectRequestById(s_id);
	}
	public Integer insertRequest(Request req){
		return sqlSession.getMapper(RequestMapper.class).insertRequest(req);
	}
	public Integer deleteRequest(Map<String, Object> condition){
		return sqlSession.getMapper(RequestMapper.class).deleteRequest(condition);
	}
	
	public List<Request> selectRequest(int s_id){
		return sqlSession.getMapper(RequestMapper.class).selectRequest(s_id);
	}
	public Request selectRequestByPrimaryKey(int req_id) {
		return sqlSession.getMapper(RequestMapper.class).selectRequestByPrimaryKey(req_id);
	}
	public Integer deleteRequestByU_id(int u_id) {
		return sqlSession.getMapper(RequestMapper.class).deleteRequestByU_id(u_id);
	}
	public List<Request> selectRequestByS_id(int s_id) {
		return sqlSession.getMapper(RequestMapper.class).selectRequestByS_id(s_id);
	}
	public Integer deleteRequestByReq_id(int req_id) {
		return sqlSession.getMapper(RequestMapper.class).deleteRequestByReq_id(req_id);
	}
	public Integer deleteRequestByS_id(int s_id){
		return sqlSession.getMapper(RequestMapper.class).deleteRequestByS_id(s_id);
	}
}
