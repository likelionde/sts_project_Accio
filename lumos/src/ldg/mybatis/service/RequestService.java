package ldg.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.Request;
import ldg.mybatis.repository.mapper.RequestMapperRepository;

@Service
public class RequestService {
	
	@Autowired
	private RequestMapperRepository requestRepository;
	
	public Integer selectRequestById(int s_id){
		return requestRepository.selectRequestById(s_id);
	}
	@Transactional
	public Integer insertRequest(Request req){
		return requestRepository.insertRequest(req);
	}
	@Transactional
	public Integer deleteRequest(int u_id, int s_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		condition.put("s_id", s_id);
		
		return requestRepository.deleteRequest(condition);
	}
	
	public List<Request> selectRequest(int s_id) {
		return requestRepository.selectRequest(s_id);
	}
	public Request selectRequestByPrimaryKey(int req_id){
		return requestRepository.selectRequestByPrimaryKey(req_id);
	}

	public Integer deleteRequestByU_id(int u_id) {
		return requestRepository.deleteRequestByU_id(u_id);
	}
	public List<Request> selectRequestByS_id(int s_id) {
		return requestRepository.selectRequestByS_id(s_id);
	}
	public Integer deleteRequestByReq_id(int req_id) {
		return requestRepository.deleteRequestByReq_id(req_id);
	}
	public Integer deleteRequestByS_id(int s_id){
		return requestRepository.deleteRequestByS_id(s_id);
	}
}
