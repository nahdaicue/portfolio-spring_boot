package com.nahuelcuello.portfolio.mapper;

import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileCreateDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileUpdateDTO;
import com.nahuelcuello.portfolio.entitys.Profile;
import com.nahuelcuello.portfolio.entitys.User;

public class ProfileMapper {

    public static ProfileDTO toDto(Profile profile) {
        if (profile == null) return null;
        ProfileDTO dto = new ProfileDTO();
        dto.setId(profile.getId());
        dto.setUsername(profile.getUsername());
        dto.setTitle(profile.getTitle());
        dto.setDescription(profile.getDescription());
        dto.setAboutMe(profile.getAboutMe());
        dto.setUrlImg(profile.getUrlImg());
        return dto;
    }

    public static Profile fromCreateDTO(ProfileCreateDTO dto, User user) {
        return Profile.builder()
                .username(dto.getUsername())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .aboutMe(dto.getAboutMe())
                .urlImg(dto.getUrlImg())
                .user(user)
                .build();
    }

    public static void updateFromDTO(ProfileUpdateDTO dto, Profile profile) {
        profile.setUsername(dto.getUsername());
        profile.setTitle(dto.getTitle());
        profile.setDescription(dto.getDescription());
        profile.setAboutMe(dto.getAboutMe());
        profile.setUrlImg(dto.getUrlImg());
    }
}