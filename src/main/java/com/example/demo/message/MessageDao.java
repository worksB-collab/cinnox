package com.example.demo.message;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageDao extends MongoRepository<Message, String> {
    List<Message> findByUserId(String userId);
}