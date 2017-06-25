package ldg.mybatis.repository.mapper;

import java.util.List;

import ldg.mybatis.model.Message;

public interface MessageMapper {
	List<Message> selectSendMessage(String u_num);
	List<Message> selectRecMessage(String u_num);
	Message selectMessageByPrimaryKey(int m_id);
	Integer insertMessage(Message message);
	Integer flagMessage(int m_id);
	//탈퇴시 message 보낸사람받는사람 '알수없음' 으로 바꿈
	Integer updateMessageRecvUser(String stu_num);
	Integer updateMessageSendUser(String stu_num);
}
