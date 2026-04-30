
package com.nahuelcuello.portfolio.DTO.profileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProfileUpdateDTO {
    private String title;
    private String description;
    private String aboutMe;
    private String urlImg;
}
