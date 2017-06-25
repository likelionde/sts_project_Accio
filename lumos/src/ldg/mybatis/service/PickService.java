package ldg.mybatis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.Pick;
import ldg.mybatis.repository.mapper.PickMapperRepository;

@Service
public class PickService {

	@Autowired
	private PickMapperRepository pickRepository;
	
	public List<Pick> selectPickById(int u_id){
		return pickRepository.selectPickById(u_id);
	}
	
	public Integer selectPickByTwoId(Pick pick){
		return pickRepository.selectPickByTwoId(pick);
		}
	
	@Transactional
	public Integer insertPick(Pick pick){
		return pickRepository.insertPick(pick);
	}

	@Transactional
	public Integer deletePick(Pick pick){
		return pickRepository.deletePick(pick);
	}
	
	public Integer deletePickByP_id(int p_id) {
		return pickRepository.deletePickByP_id(p_id);
	}
	public Integer deletePickByU_id(int u_id) {
		return pickRepository.deletePickByU_id(u_id);
	}
	public Pick selectPickByS_id(int s_id) {
		return pickRepository.selectPickByS_id(s_id);
	}
	
	public  Integer deletePickByS_id(int s_id){
		return pickRepository.deletePickByS_id(s_id);
	}
}
