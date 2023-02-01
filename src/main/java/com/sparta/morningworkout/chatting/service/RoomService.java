package com.sparta.morningworkout.chatting.service;

import com.sparta.morningworkout.chatting.dto.RoomDto;

public interface RoomService {

	void createRoom(long productId, long customerId);

	RoomDto goChat(long roomId);

}
