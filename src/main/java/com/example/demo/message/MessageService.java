package com.example.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  
  @Autowired
  private MessageDao messageDao;
  
  public void createMessage(final String userId, final String text) {
    final Message message = new Message(userId, text);
    messageDao.save(message);
  }
}
