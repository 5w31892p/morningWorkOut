package com.sparta.morningworkout.chatting.entity;

import java.util.ArrayList;
import java.util.List;

import com.sparta.morningworkout.entity.Product;
import com.sparta.morningworkout.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRooms {
	@Id
	@GeneratedValue
	@Column(name = "room_id")
	private long id;

	@Column(nullable = false, name = "product_id")
	private long productId;

	@Column(nullable = false, name = "seller_id")
	private long sellerId;

	@Column(nullable = false, name = "customer_id")
	private long customerId;

	@OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
	private List<Message> message = new ArrayList<>();

	public ChatRooms(Product product, User user) {
		this.productId = product.getId();
		this.sellerId = product.getUserId();
		this.customerId = user.getId();
	}

	// public boolean checkAuthorization(User user) {
	// 	return Objects.equals(id, user.getId());
	// }
}
