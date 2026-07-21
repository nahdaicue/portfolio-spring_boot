
package com.nahuelcuello.portfolio.mail.service;

public interface IEmailService {
    
    void sendEmail(String[] toUser, String subject, String message); //para, asunto, mensaje
}
