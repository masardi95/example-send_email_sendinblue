package com.mase.examplesendsmtpsendinblue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mase.examplesendsmtpsendinblue.entity.dto.RequestSendEmailDto;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(RequestSendEmailDto requestSendEmailDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(requestSendEmailDto.getMessage());

            // set pesan yang mau di kirim ke email
            mailMessage.setText(String.valueOf(stringBuilder));

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            String sendMessage = "" + stringBuilder;

            mimeMessage.setContent(sendMessage, "text/html");
            helper.setText(sendMessage, true);

            
            helper.setFrom("masngamen@gmail.com");
            helper.setSubject(requestSendEmailDto.getSubject());
            helper.setTo(InternetAddress.parse(requestSendEmailDto.getMailTo()));

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }
    
}
