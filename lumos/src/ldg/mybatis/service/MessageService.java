package ldg.mybatis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ldg.mybatis.model.Message;
import ldg.mybatis.repository.mapper.MessageMapperRepository;

@Service
public class MessageService {
	@Autowired
	private MessageMapperRepository messageRepository;
	
	public List<Message> selectSendMessage(String u_num) {
		return messageRepository.selectSendMessage(u_num);  
	}
	public List<Message> selectRecMessage(String u_num) {
		return messageRepository.selectRecMessage(u_num);  
	}
	public Message selectMessageByPrimaryKey(int m_id) {
		return messageRepository.selectMessageByPrimaryKey(m_id);
	}
	@Transactional
	public Integer flagMessage(int m_id) {
		return messageRepository.flagMessage(m_id);
	}
	@Transactional
	public Integer insertMessage(Message message) {
		int a = messageRepository.insertMessage(message);
		return a;
	}
	public Integer updateMessageRecvUser(String stu_num) {
		return messageRepository.updateMessageRecvUser(stu_num);
	}
	public Integer updateMessageSendUser(String stu_num) {
		return messageRepository.updateMessageSendUser(stu_num);
	}
}
