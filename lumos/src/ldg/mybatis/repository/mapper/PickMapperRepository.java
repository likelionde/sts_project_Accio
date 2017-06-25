package ldg.mybatis.repository.mapper;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.Pick;


@Repository
public class PickMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Pick> selectPickById(int u_id){
		return sqlSession.getMapper(PickMapper.class).selectPickById(u_id);
	}

	public Integer selectPickByTwoId(Pick pick){
		return sqlSession.getMapper(PickMapper.class).selectPickByTwoId(pick);
	}
	
	public Integer insertPick(Pick pick){
		Integer result = sqlSession.getMapper(PickMapper.class).insertPick(pick);
		return result;
	}

	public Integer deletePick(Pick pick){
		Integer result = sqlSession.getMapper(PickMapper.class).deletePick(pick);
		return result;
	}
	
	public Integer deletePickByU_id(int u_id) {
		return sqlSession.getMapper(PickMapper.class).deletePickByU_id(u_id);
	}
	public Integer deletePickByP_id(int p_id) {
		return sqlSession.getMapper(PickMapper.class).deletePickByP_id(p_id);
	}
	public Pick selectPickByS_id(int s_id) {
		return sqlSession.getMapper(PickMapper.class).selectPickByS_id(s_id);
	}
	
	public Integer deletePickByS_id(int s_id){
		return sqlSession.getMapper(PickMapper.class).deletePickByS_id(s_id);
	}
}