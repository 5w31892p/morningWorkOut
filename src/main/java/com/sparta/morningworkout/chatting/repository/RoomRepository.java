package com.sparta.morningworkout.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.morningworkout.chatting.entity.ChatRooms;

public interface RoomRepository extends JpaRepository<ChatRooms,Long> {
	ChatRooms findByProductId(long productId);
}