package com.example.demo.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MessageDto {
    private String text;
    private LocalDateTime timestamp;
}