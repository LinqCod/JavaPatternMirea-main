package com.example.demo24.services;

import com.example.demo24.entity.UserApp;
import com.example.demo24.repositories.UserRepository;
import com.example.demo24.tables.Groups;
import com.example.demo24.tables.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAppServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserAppService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserAppService(new BCryptPasswordEncoder(10), userRepository);
    }

    @Test
    public void getUsers() {
        // given
        User user = new User();
        user.setUserName("user");

        // when
        Mockito.when(userRepository.findUserByUserName(user.getUserName())).thenReturn(user);

        // then
        Assertions.assertEquals(user.getUserName(), underTest.loadUserByUsername(user.getUserName()).getUsername());
    }

    @Test
    //Todo: переписать
    void loadUserByUsername() {
        // given
        User user = new User();
        user.setUserName("user");
        user.setPassword("pswd");

        UserApp userApp = new UserApp(user);
        //underTest.signUpUser(user);

        Mockito.when(userRepository.findUserByUserName(userApp.getUsername())).thenReturn(user);

        //when
        User expected = userRepository.findUserByUserName(userApp.getUsername());

        //then
        Mockito.verify(userRepository).findUserByUserName(userApp.getUsername());
        assertThat(expected).isEqualTo(user);
        /*Mockito.doReturn(expected)
                .when(userRepository)
                .findUserByUserName(userApp.getUsername());*/
    }

}