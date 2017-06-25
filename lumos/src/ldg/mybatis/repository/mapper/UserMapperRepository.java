package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import ldg.mybatis.model.User;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public User selectUserByStu_num(String stu_num) {
		return sqlSession.getMapper(UserMapper.class).selectUserByStu_num(stu_num);
	}
	
	public User selectUserByPrimaryKey(int u_id) {
		return sqlSession.getMapper(UserMapper.class).selectUserByPrimaryKey(u_id);
	}

	public List<User> selectUser() {
		return sqlSession.getMapper(UserMapper.class).selectUser();
	}
	
	public Integer insertUser(User User) {
		Integer result = sqlSession.getMapper(UserMapper.class).insertUser(User);
		return result;
	}

	public Integer deleteUser(int b_id) {
		Integer result = sqlSession.getMapper(UserMapper.class).deleteUser(b_id);
		return result;
	}
	
	public Integer updateFlag(int u_id) {
		Integer result = sqlSession.getMapper(UserMapper.class).updateFlag(u_id);
		return result;
	}
	public Integer updateLike(Map<String, Object> condition) {
		return sqlSession.getMapper(UserMapper.class).updateLike(condition);
	}
}