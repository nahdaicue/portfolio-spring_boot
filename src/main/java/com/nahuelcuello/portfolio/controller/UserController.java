package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.DTO.user.UserChangePasswordDTO;
import com.nahuelcuello.portfolio.DTO.user.UserCreateDTO;
import com.nahuelcuello.portfolio.DTO.user.UserDTO;
import com.nahuelcuello.portfolio.DTO.user.UserUpdateDTO;
import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.mapper.UserMapper;
import com.nahuelcuello.portfolio.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDTO userDTO = UserMapper.toDto(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    
    // CREATE
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO userCreateDTO) {
        User user = UserMapper.fromCreateDTO(userCreateDTO);
        User savedUser = userService.save(user);
        UserDTO savedDTO = UserMapper.toDto(savedUser);
        return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long id,
            @RequestBody UserUpdateDTO userUpdateDTO
    ) {
        User user = userService.findById(id);
        UserMapper.updateFromDTO(userUpdateDTO, user);
        User updatedUser = userService.update(id, user);
        UserDTO updatedDTO = UserMapper.toDto(updatedUser);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }
    
    // CHANGE PASSWORD
    @PutMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long id,
            @RequestBody UserChangePasswordDTO passwordDTO
    ) {
        userService.changePassword(id, passwordDTO.getOldPassword(), passwordDTO.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}