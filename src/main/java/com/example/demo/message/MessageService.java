package com.example.demo.message;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MessageService {

  @Autowired
  private MessageDao messageDao;

  @Autowired
  private LineMessagingClient lineMessagingClient;


  public void receiveMessage(final String userId, final String text) {
    final Message message = new Message(userId, text);
    messageDao.save(message);
  }

  public void sendMessage(final String userId, final String messageText) {
    final TextMessage textMessage = new TextMessage(messageText);
    try {
      lineMessagingClient
              .pushMessage(new PushMessage(userId, textMessage))
              .get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
