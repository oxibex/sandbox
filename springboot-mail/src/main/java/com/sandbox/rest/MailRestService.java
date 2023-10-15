package com.sandbox.rest;

import com.sandbox.dto.MailRequestDto;
import com.sandbox.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailRestService {

    @Autowired
    private MailService mailService;

    @RequestMapping
    public String sendMail(@RequestBody MailRequestDto requestDto){
        return mailService.sendMail(requestDto.getFromMail(), requestDto.getMessage());
    }

}
