package com.mase.examplesendsmtpsendinblue.entity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RequestSendEmailDto {
    private String mailTo;
    private String message;
    private String subject;
}
