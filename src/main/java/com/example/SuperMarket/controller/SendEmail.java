package com.example.SuperMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SuperMarket.service.EmailService;

import lombok.Data;

@Data
@RestController
public class SendEmail {
    @Autowired
    private EmailService emailService;

   
    
    public SendEmail(EmailService emailService) {
        this.emailService = emailService;
    }



    @RequestMapping(value = "sendMail/{sendTo}",method = RequestMethod.GET)
    public String sendMail(@PathVariable("sendTo") String setTo){
        emailService.sendMail(setTo);
        return "sent to "+setTo;

    }
    
}
