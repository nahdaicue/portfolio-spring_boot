
package com.nahuelcuello.portfolio.services.profileService;

import com.nahuelcuello.portfolio.mapper.ProfileMapper;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileCreateDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileUpdateDTO;
import com.nahuelcuello.portfolio.entitys.Profile;
import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.repository.ProfileRepository;
import com.nahuelcuello.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public ProfileDTO getByUserId(Long userId) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        return ProfileMapper.toDto(profile);
    }

    @Override
    @Transactional
    public ProfileDTO create(Long userId, ProfileCreateDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Profile profile = ProfileMapper.fromCreateDTO(dto, user);
        return ProfileMapper.toDto(profileRepository.save(profile));
    }

    @Override
    @Transactional
    public ProfileDTO update(Long userId, ProfileUpdateDTO dto) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        ProfileMapper.updateFromDTO(dto, profile);
        return ProfileMapper.toDto(profileRepository.save(profile));
    }
}