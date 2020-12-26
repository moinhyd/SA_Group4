package com.counterC.counterC.receiver;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private static List<String> emails = new ArrayList<>();

    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    String fromEmail;

    static {
        //emails.add("ToEmail@gmail.com");
        emails.add("moin.dba@gmail.com");
        emails.add("adinarayan.m@gmail.com");

    }

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {
        System.out.println(new String(message));
        System.out.println("Sending email to : "+ emails.toString());
        try {
            sendEmail(new String(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

    public void receiveMessage(String message) {
        System.out.println(new String(message));
        latch.countDown();
    }

    private void sendEmail(String message) throws UnsupportedEncodingException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress(fromEmail, "MD MOINUDDIN"))
                .to(Lists.newArrayList(new InternetAddress(
                        emails.get(0), "Alert")))
                .subject(message)
                .body(message)
                .encoding("UTF-8").build();
        emailService.send(email);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
