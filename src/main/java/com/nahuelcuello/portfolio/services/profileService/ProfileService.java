
package com.nahuelcuello.portfolio.services.profileService;

import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileCreateDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileUpdateDTO;

public interface ProfileService {
    ProfileDTO getByUserId(Long userId);
    ProfileDTO create(Long userId, ProfileCreateDTO dto);
    ProfileDTO update(Long userId, ProfileUpdateDTO dto);
}
