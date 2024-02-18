package com.example.demo.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "message")
public class Message {
  
  @Id
  private UUID id;
  private String userId;
  private String text;
  private LocalDateTime timestamp;
  
  public Message(final String userId, final String text) {
    this.id = UUID.randomUUID();
    this.userId = userId;
    this.text = text;
    this.timestamp = LocalDateTime.now();
  }
  
}
