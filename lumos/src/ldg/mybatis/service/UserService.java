package ldg.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldg.mybatis.model.User;
import ldg.mybatis.repository.mapper.UserMapperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{
	@Autowired
	private UserMapperRepository userRepository;

	public User selectUserByStu_num(String stu_num) {
		return userRepository.selectUserByStu_num(stu_num);
	}
	public User selectUserByPrimaryKey(int u_id) {
		return userRepository.selectUserByPrimaryKey(u_id);
	}
	public Integer updateLike(int like_cnt, int u_id) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		condition.put("like_cnt", like_cnt);
		
		return userRepository.updateLike(condition);
	}

	public List<User> selectUser() {
		return userRepository.selectUser();
	}

	@Transactional
	public Integer insertUser(User User) {
		return userRepository.insertUser(User);
	}

	@Transactional
	public Integer deleteUser(int u_id) {
		return userRepository.deleteUser(u_id);
	}

	@Transactional
	public Integer updateFlag(int u_id) {
		return userRepository.updateFlag(u_id);
	}

}