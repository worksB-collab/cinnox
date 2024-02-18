package com.example.demo.message;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageDao extends MongoRepository<Message, String> {
}