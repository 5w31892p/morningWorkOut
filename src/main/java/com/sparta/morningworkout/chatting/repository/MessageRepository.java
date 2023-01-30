package com.sparta.morningworkout.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.morningworkout.chatting.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Message findByMessage(String message);
}
