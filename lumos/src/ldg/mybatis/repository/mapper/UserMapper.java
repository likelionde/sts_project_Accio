package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import ldg.mybatis.model.User;

public interface UserMapper {
	User selectUserByStu_num(String stu_num);
	
//	@Select("SELECT u_id, nickname, email, pwd FROM LUMOS_USERS WHERE u_id = #{u_id}")
	User selectUserByPrimaryKey(int u_id);

//	@Select("SELECT u_id, nickname, email, pwd FROM LUMOS_USERS")
	List<User> selectUser();

	//	@Insert("INSERT INTO User(User_no, user_id, User_content, reg_date) VALUES (#{UserNo}, #{userId}, #{UserContent}, #{regDate})")
	Integer insertUser(User User);

	//	@Delete("DELETE FROM User WHERE User_no = #{UserNo}")
	Integer deleteUser(int b_id);
	
	Integer updateFlag(int u_id);
	Integer updateLike(Map<String, Object> condition);
}
