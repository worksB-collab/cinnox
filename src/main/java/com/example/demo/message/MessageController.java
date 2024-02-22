package com.example.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

  @Autowired
  private MessageService messageService;

  @PostMapping("/sendMessage")
  public ResponseEntity<String> sendMessage(@RequestBody final MessageRequest messageRequest) {
    messageService.sendMessage(messageRequest.getUserId(), messageRequest.getText());
    return ResponseEntity.ok("message sent");
  }

  @GetMapping("/messageList/{userId}")
  public ResponseEntity<List<MessageDto>> getMessagesByUserId(@PathVariable final String userId) {
    final List<MessageDto> messageDtoList = messageService.getMessageByUserId(userId);
    return ResponseEntity.ok(messageDtoList);
  }
}
