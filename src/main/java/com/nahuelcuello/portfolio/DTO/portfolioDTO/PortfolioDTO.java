
package com.nahuelcuello.portfolio.DTO.portfolioDTO;

import com.nahuelcuello.portfolio.DTO.profileDTO.ProfileDTO;
import com.nahuelcuello.portfolio.DTO.userDTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDTO {
    
    private UserDTO user;
    private ProfileDTO profile;
}
