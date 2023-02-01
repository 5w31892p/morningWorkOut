package com.sparta.morningworkout.chatting.dto;

import java.util.ArrayList;
import java.util.List;

import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.chatting.entity.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
	private long roomId;
	private long productId;
	private List<MessageDto> messageList;

	public RoomDto(ChatRooms rooms) {
		this.roomId = rooms.getId();
		this.productId = rooms.getProductId();
		List<MessageDto> list = new ArrayList<>();
		for (Message message : rooms.getMessage()){
			list.add(new MessageDto(message));
		}
		this.messageList =list;
	}
}