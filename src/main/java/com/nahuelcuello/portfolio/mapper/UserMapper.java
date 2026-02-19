package com.nahuelcuello.portfolio.mapper;

import com.nahuelcuello.portfolio.DTO.user.UserCreateDTO;
import com.nahuelcuello.portfolio.DTO.user.UserDTO;
import com.nahuelcuello.portfolio.DTO.user.UserUpdateDTO;
import com.nahuelcuello.portfolio.entitys.User;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUrlImg(user.getUrlImg());

        if (user.getProjects() != null) {
            userDTO.setProjects(
                    user.getProjects().stream()
                            .map(ProjectMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return userDTO;
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUrlImg(dto.getUrlImg());

        return user;
    }
     public static User fromCreateDTO(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUrlImg(dto.getUrlImg());
        return user;
    }
    
 
    public static void updateFromDTO(UserUpdateDTO dto, User user) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUrlImg(dto.getUrlImg());

    }
}
