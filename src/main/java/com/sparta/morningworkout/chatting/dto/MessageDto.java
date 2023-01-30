package com.sparta.morningworkout.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
	private long roomId;
	private long productId;
	private String sender;
	private String receiver;
	private String message;

	// public MessageDto(Message message) {
	// 	this.roomId = message.getRoom().getId();
	// 	this.productId = message.getProductId();
	// 	this.sender = message.getSender();
	// 	this.message = message.getMessage();
	// 	this.sendDate = message.getSendDate();
	// }
}
