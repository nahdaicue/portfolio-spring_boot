package com.nahuelcuello.portfolio.mail.controller;


import com.nahuelcuello.portfolio.mail.DTO.EmailDTO;
import com.nahuelcuello.portfolio.mail.service.IEmailService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class MailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());
        
        Map<String,String> response = new HashMap<>();
        response.put("Estado", "Enviado");
        
        return ResponseEntity.ok(response);
    }
}