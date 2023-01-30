package com.sparta.morningworkout.chatting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.morningworkout.chatting.service.RoomService;
import com.sparta.morningworkout.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RoomController {
	private final RoomService roomService;

	/**
	 * 채팅방 등록
	 */

	@PostMapping("/chatrooms/{productId}")
	public ResponseEntity<String> createRoom(@PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		roomService.createRoom(productId, userDetails.getUserId());

		return new ResponseEntity<>("채팅방 생성 완료", HttpStatus.CREATED);
	}
}