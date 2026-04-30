
package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileCreateDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileDTO;
import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileUpdateDTO;
import com.nahuelcuello.portfolio.services.profileService.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDTO> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getByUserId(userId));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ProfileDTO> create(
            @PathVariable Long userId,
            @RequestBody ProfileCreateDTO dto) {
        return new ResponseEntity<>(profileService.create(userId, dto), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ProfileDTO> update(
            @PathVariable Long userId,
            @RequestBody ProfileUpdateDTO dto) {
        return ResponseEntity.ok(profileService.update(userId, dto));
    }
}
