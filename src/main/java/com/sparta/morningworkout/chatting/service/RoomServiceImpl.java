package com.sparta.morningworkout.chatting.service;

import org.springframework.stereotype.Service;

import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.chatting.repository.RoomRepository;
import com.sparta.morningworkout.entity.Product;
import com.sparta.morningworkout.entity.Profile;
import com.sparta.morningworkout.repository.ProductRepository;
import com.sparta.morningworkout.repository.ProfileRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {
	private final RoomRepository roomRepository;
	private final ProductRepository productRepository;
	private final ProfileRepository profileRepository;

	/**
	 * 채팅방 만들기
	 *
	 */
	public void createRoom(long productId, long customerId) {
		Product product = productRepository.findById(productId).orElseThrow(
			() -> new IllegalArgumentException("상품이 존재하지 않습니다.")
		);

		Profile profile = profileRepository.findById(customerId).orElseThrow(
			() -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
		);
			ChatRooms chatRooms = new ChatRooms(product, profile);
			roomRepository.save(chatRooms);
	}
}
