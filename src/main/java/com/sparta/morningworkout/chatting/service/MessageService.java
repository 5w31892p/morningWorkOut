package com.sparta.morningworkout.chatting.service;

import org.springframework.stereotype.Service;

import com.sparta.morningworkout.chatting.dto.MessageDto;
import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.chatting.entity.Message;
import com.sparta.morningworkout.chatting.repository.MessageRepository;
import com.sparta.morningworkout.chatting.repository.RoomRepository;
import com.sparta.morningworkout.repository.PointRepository;
import com.sparta.morningworkout.repository.ProductRepository;
import com.sparta.morningworkout.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
	private final MessageRepository messageRepository;
	private final RoomRepository roomRepository;
	private final ProductRepository productRepository;
	private final ProfileRepository profileRepository;
	private final PointRepository pointRepository;

	/**
	 * 채팅 생성
	 */
	public Message createChat(MessageDto message) {

		ChatRooms rooms = roomRepository.findById(message.getRoomId()).orElseThrow(
			() -> new IllegalArgumentException("채팅방이 존재하지 않습니다.")
		);

		if (message.getProductId() != rooms.getProductId()) {
			throw new IllegalArgumentException("해당 상품의 채팅방이 존재하지 않습니다.");
		} else {
			Message messages = new Message(message.getMessage(), rooms);
			messageRepository.save(messages);

			return messages;
		}
	}
}