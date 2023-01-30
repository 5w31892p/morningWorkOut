package com.sparta.morningworkout.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.morningworkout.dto.profile.ShowProfileResponseDto;
import com.sparta.morningworkout.dto.profile.UpdateProfileRequestDto;
import com.sparta.morningworkout.entity.Profile;
import com.sparta.morningworkout.repository.ProfileRepository;
import com.sparta.morningworkout.service.serviceInterface.ProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

	private final ProfileRepository profileRepository;

	@Override
	public void updateProfile(long profileId, UpdateProfileRequestDto request, long userId) {
		Profile profile = profileRepository.findById(profileId).orElseThrow(
			() -> new RuntimeException("수정할 프로필이 없습니다.")
		);
		profile.profileUpdate(request);
		this.profileRepository.save(profile);
	}

	@Override
	@Transactional(readOnly = true)
	public ShowProfileResponseDto showMyProfile(long id) {
		Profile profile = profileRepository.findById(id).orElseThrow(
			() -> new RuntimeException("조회할 프로필이 없습니다.")
		);
		return new ShowProfileResponseDto(profile);
	}
}
