package com.example.demo.message;

import lombok.Data;

@Data
public class MessageRequest {
  private String userId;
  private String text;
}
