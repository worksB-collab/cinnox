package com.example.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  private MessageService messageService;

  @PostMapping("/sendMessage")
  public ResponseEntity<String> sendMessage(@RequestBody final MessageRequest messageRequest) {
    messageService.sendMessage(messageRequest.getUserId(), messageRequest.getText());
    return ResponseEntity.ok("message sent");
  }
}
