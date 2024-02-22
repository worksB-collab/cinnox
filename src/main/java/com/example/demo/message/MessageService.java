package com.example.demo.message;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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

  public List<MessageDto> getMessageByUserId(final String userId) {
    final List<Message> messageList = messageDao.findByUserId(userId);
    return messageList.stream()
            .map(message -> new MessageDto(message.getText(), message.getTimestamp()))
            .collect(Collectors.toList());
  }
}
