package com.example.SuperMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;


    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String email) throws MailException{
        MimeMessagePreparator messagePreparator = mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("jjamalspring@gmail.com");
            messageHelper.setTo(email);
            messageHelper.setSubject("any");
            messageHelper.setText("gfhfugjhhoi khknkjo  ljkbjvnvh jjbmnnmbnvnjm jbjkhkjnm,bmnvv");
        };
        javaMailSender.send(messagePreparator);
        
        // SimpleMailMessage mail = new SimpleMailMessage();
        // mail.setTo(email);
        // mail.setFrom("jjamalspring60gmai.com");
        // mail.setSubject("password");
        // mail.setText("Nasra07@");
        // javaMailSender.send(mail);
    }

    public void sendMail2(String email,String username,String password) throws MailException{
        MimeMessagePreparator messagePreparator = mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("jjamalspring@gmail.com");
            messageHelper.setTo(email);
            messageHelper.setSubject("your login credentials");
            messageHelper.setText("user name: "+username +"\n"+"password: "+password);
        };
        javaMailSender.send(messagePreparator);
        
        // SimpleMailMessage mail = new SimpleMailMessage();
        // mail.setTo(email);
        // mail.setFrom("jjamalspring60gmai.com");
        // mail.setSubject("password");
        // mail.setText("Nasra07@");
        // javaMailSender.send(mail);
    }
}
