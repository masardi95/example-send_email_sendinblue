package com.mase.examplesendsmtpsendinblue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mase.examplesendsmtpsendinblue.entity.dto.RequestSendEmailDto;
import com.mase.examplesendsmtpsendinblue.service.EmailService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "")
    public ResponseEntity<Object> check() {
        
        return ResponseEntity.ok("oke");
    }

    @PostMapping(value="")
    public ResponseEntity<Object> postMethodName(@RequestBody RequestSendEmailDto requestSendEmailDto) {
        //TODO: process POST request

        emailService.sendEmail(requestSendEmailDto);
        
        return ResponseEntity.ok(requestSendEmailDto);
    }
    
    
}
