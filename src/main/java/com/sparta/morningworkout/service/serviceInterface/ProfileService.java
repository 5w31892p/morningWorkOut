package com.sparta.morningworkout.service.serviceInterface;

import org.springframework.transaction.annotation.Transactional;

import com.sparta.morningworkout.dto.profile.ShowCustomerProfileResponseDto;
import com.sparta.morningworkout.dto.profile.UpdateCustomerProfileRequestDto;

public interface ProfileService {
    void updateProfile(long id, UpdateCustomerProfileRequestDto request, long userId);
    // ShowSellerProfileResponseDto showProfile(long id);

    @Transactional(readOnly = true)
    ShowCustomerProfileResponseDto showMyProfile(long id);

}
