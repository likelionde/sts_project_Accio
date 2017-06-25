package ldg.mybatis.repository.session;

import java.util.List;
import java.util.Map;

import ldg.mybatis.model.User;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String namespace = "ldg.mybatis.repository.mapper.UserMapper";

	public User selectUserByPrimaryKey(int b_id) {
		return (User)sqlSession.selectOne(String.format("%s.selectUserByPrimaryKey", namespace), b_id);
	}

	public List<User> selectUserByCondition(Map<String, Object> condition) {
		return sqlSession.selectList(String.format("%s.selectUserByCondition", namespace), condition);
	}
	
	public List<User> selectUser() {
		return sqlSession.selectList(String.format("%s.selectUser", namespace));
	}

	public Integer insertUser(User User) {
		int result = sqlSession.insert(String.format("%s.insertUser", namespace), User);
		return result;
	}

	public Integer deleteUser(int b_id) {
		int result = sqlSession.delete(String.format("%s.deleteUser", namespace), b_id);
		return result;
	}
}
