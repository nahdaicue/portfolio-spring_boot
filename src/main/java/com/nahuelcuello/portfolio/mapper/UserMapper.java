package com.nahuelcuello.portfolio.mapper;

import com.nahuelcuello.portfolio.DTO.user.UserProfileResponseDTO;
import com.nahuelcuello.portfolio.entitys.User;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserProfileResponseDTO toProfileDto(User user) {

        UserProfileResponseDTO dto = new UserProfileResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUrlImg(user.getUrlImg());

        dto.setProjects(
                user.getProjects()
                        .stream()
                        .map(ProjectMapper::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
