# example-send_email_sendinblue

  ini adalah contoh pengiriman email menggunakan springboot dengan memanfaatkan pihak ke 3 [sendinblue](https://www.sendinblue.com/). Dengan hanya membuat config di `application.properties`nya seperti yang ada di bawah ini


```
spring.mail.host=smtp-relay.sendinblue.com
spring.mail.port=587
spring.mail.username=<email-sendinblue-mu>
spring.mail.password=<password-master-sendinblue-mu>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=false
spring.mail.smtp.debug=true
```

kalian tinggal ganti aja tu `spring.mail.username` & `spring.mail.password` yang ada di SMTP kalian

## end point
- Method post: `http://127.0.0.1:9090/email`
- Request Body:
```
{
    "mailTo": "masngamen@gmail.com",
    "message": "Halloo gaess",
    "subject": "aku subject"
}
```

