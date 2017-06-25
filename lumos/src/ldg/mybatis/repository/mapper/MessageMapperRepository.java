package ldg.mybatis.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ldg.mybatis.model.Message;

@Repository
public class MessageMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Message> selectSendMessage(String u_num) {
		return sqlSession.getMapper(MessageMapper.class).selectSendMessage(u_num);
	}
	public List<Message> selectRecMessage(String u_num) {
		return sqlSession.getMapper(MessageMapper.class).selectRecMessage(u_num);
	}
	public Message selectMessageByPrimaryKey(int m_id) {
		return sqlSession.getMapper(MessageMapper.class).selectMessageByPrimaryKey(m_id);
	}
	
	public Integer insertMessage(Message message) {
		Integer result = sqlSession.getMapper(MessageMapper.class).insertMessage(message);
		return result;
	}
	public Integer flagMessage(int m_id) {
		Integer result = sqlSession.getMapper(MessageMapper.class).flagMessage(m_id);
		return result;
	}
	public Integer updateMessageRecvUser(String stu_num) {
		return sqlSession.getMapper(MessageMapper.class).updateMessageRecvUser(stu_num);
	}
	public Integer updateMessageSendUser(String stu_num) {
		return sqlSession.getMapper(MessageMapper.class).updateMessageSendUser(stu_num);
	}
}
