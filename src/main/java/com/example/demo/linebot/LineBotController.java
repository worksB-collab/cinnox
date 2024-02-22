package com.example.demo.linebot;

import com.example.demo.message.MessageService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;

@LineMessageHandler
public class LineBotController {
  
  @Autowired
  private MessageService messageService;
  
  @EventMapping
  public TextMessage handleTextMessageEvent(final MessageEvent<TextMessageContent> event) {
    final String userId = event.getSource().getUserId();
    final String text = event.getMessage().getText();
    messageService.receiveMessage(userId, text);

    return new TextMessage(text);
  }
}