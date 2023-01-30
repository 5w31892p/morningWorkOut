package com.sparta.morningworkout.service.serviceInterface;

import org.springframework.transaction.annotation.Transactional;

import com.sparta.morningworkout.dto.profile.ShowProfileResponseDto;
import com.sparta.morningworkout.dto.profile.UpdateProfileRequestDto;

public interface ProfileService {
    void updateProfile(long id, UpdateProfileRequestDto request, long userId);
    // ShowSellerProfileResponseDto showProfile(long id);

    @Transactional(readOnly = true)
    ShowProfileResponseDto showMyProfile(long id);

}
