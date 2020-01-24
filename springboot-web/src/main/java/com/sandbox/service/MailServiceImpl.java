package com.sandbox.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Value("${smtp.host}")
    private String smtpHost;
    @Value("${smtp.port}")
    private String smtpPort;

    @Override
    public String sendMail(String fromEmail, String messageText) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", smtpHost);
        properties.setProperty("mail.smtp.auth", "false");
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.starttls.enable", "false");

        properties.put("mail.mime.charset", "UTF-8");
        properties.put("mail.debug", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("example@mail.com"));
            message.setSubject("Message request from " + fromEmail, "UTF-8");
            message.setContent(messageText, "text/html; charset=utf-8");

            Transport.send(message);
        }catch (Exception e) {
            e.printStackTrace();
            return "Send mail Fail!";
        }

        return "Success";
    }
}
