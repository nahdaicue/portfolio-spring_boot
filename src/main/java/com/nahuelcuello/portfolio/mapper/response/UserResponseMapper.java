package com.nahuelcuello.portfolio.mapper.response;

import com.nahuelcuello.portfolio.mapper.response.ProjectResponseMapper;
import com.nahuelcuello.portfolio.DTO.user.UserProfileResponseDTO;
import com.nahuelcuello.portfolio.entitys.User;
import java.util.stream.Collectors;

public class UserResponseMapper {

    public static UserProfileResponseDTO toProfileDto(User user) {

        UserProfileResponseDTO dto = new UserProfileResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUrlImg(user.getUrlImg());

        dto.setProjects(user.getProjects()
                        .stream()
                        .map(ProjectResponseMapper::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
