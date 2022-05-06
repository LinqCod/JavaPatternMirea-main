package com.example.demo24.services;

import com.example.demo24.tables.Groups;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class EmailServiceTest {

    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    private EmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailService(javaMailSenderImpl);
    }

    @Test
    void sendNotification() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-03-20");

        Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        // when
        underTest.sendNotification(groups);

        // then
        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));
    }
}