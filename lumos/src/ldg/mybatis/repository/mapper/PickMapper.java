package ldg.mybatis.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import ldg.mybatis.model.Pick;

public interface PickMapper {
	
	List<Pick> selectPickById(int u_id);
	
	Integer selectPickByTwoId(Pick pick);
	
	Integer insertPick(Pick pick);

	Integer deletePick(Pick pick);
	Integer deletePickByP_id(int p_id);
	Integer deletePickByU_id(int p_id);
	
	@Delete("DELETE FROM pick WHERE s_id = #{s_id}")
	Integer deletePickByS_id(int s_id);
	
	Pick selectPickByS_id(int s_id);
}
