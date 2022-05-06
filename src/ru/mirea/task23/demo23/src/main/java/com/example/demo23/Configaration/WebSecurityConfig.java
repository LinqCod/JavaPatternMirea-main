package com.example.demo23.Configaration;

import com.example.demo23.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(UserAppService userAppService,PasswordEncoder passwordEncoderT) {
        this.userAppService = userAppService;
        this.passwordEncoder = passwordEncoderT;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        /**
         * Стандартной и наиболее распространенной реализацией является DaoAuthenticationProvider,
         * который извлекает сведения о пользователе из простого пользовательского DAO,
         * доступного только для чтения, — UserDetailsService.
         * */
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userAppService);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.httpBasic()
                //.and()//нужно для постмана
                .csrf().disable()//Отключает CSRF Protection, поскольку она не нужна для API
                .authorizeRequests()
                .antMatchers("/", "/web-home", "/registration","/login")//исключение, какие запросы\страницы
                .permitAll()//будут разрешены всем
                .anyRequest()
                .authenticated()//Декларирует, что все запросы к любой конечной точке должны быть авторизованы, иначе они должны быть отклонены.
                .and()
                .formLogin()
                .loginPage("/login").permitAll()//разрешить всем доступ к странице логинизации
                .defaultSuccessUrl("/web-home", true)//по умолчанию страница
                .and()
                .rememberMe()
                .tokenValiditySeconds((int)TimeUnit.MINUTES.toSeconds(5))
                .key("somethingverysecret")
        ;
    }
}