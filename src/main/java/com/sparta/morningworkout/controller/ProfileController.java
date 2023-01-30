package com.sparta.morningworkout.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.morningworkout.dto.profile.ShowCustomerProfileResponseDto;
import com.sparta.morningworkout.dto.profile.UpdateCustomerProfileRequestDto;
import com.sparta.morningworkout.security.UserDetailsImpl;
import com.sparta.morningworkout.service.ProfileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {
	private final ProfileServiceImpl profileService;

	//따로 일치하는 유저인지 검사해주는 api가 필요할듯함
	@PutMapping("/update/{profileId}")
	public ResponseEntity<String> updateProfile(@PathVariable long profileId,
		@RequestBody UpdateCustomerProfileRequestDto request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		if (profileId != userDetails.getUserId()) {
			return new ResponseEntity<>("프로필은 본인만 수정할수 있습니다.", HttpStatus.FORBIDDEN);
		}
		profileService.updateProfile(profileId, request, userDetails.getUserId());
		return new ResponseEntity<>("프로필 수정이 완료되었습니다.", HttpStatus.OK);
	}

	@GetMapping("/{profileId}")
	public ResponseEntity<ShowCustomerProfileResponseDto> showMyProfile(@PathVariable Long profileId,
		@AuthenticationPrincipal UserDetailsImpl userDetails) {

		if (profileId != userDetails.getUserId()) {
			new ResponseEntity<>("프로필은 본인만 조회할수 있습니다.", HttpStatus.FORBIDDEN);
		}

		ShowCustomerProfileResponseDto showProfile = profileService.showMyProfile(userDetails.getUserId());
		return ResponseEntity.status(HttpStatus.OK).body(showProfile);
	}
}
