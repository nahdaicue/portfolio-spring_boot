
package com.nahuelcuello.portfolio.mail.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO{
    
    private String[] toUser;
    private String subject;
    private String message;
    
}
