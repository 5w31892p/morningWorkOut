package com.sparta.morningworkout.dto.profile;

import com.sparta.morningworkout.entity.CategoryEnum;
import com.sparta.morningworkout.entity.Profile;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShowProfileResponseDto {
    private String nickname;
//    private String image;
    private String infoContent;
    private CategoryEnum category;

	public ShowProfileResponseDto(Profile profiles) {
		this.nickname = profiles.getNickname();
		this.infoContent = profiles.getInfoContent();
		this.category = profiles.getCategory();
	}
}