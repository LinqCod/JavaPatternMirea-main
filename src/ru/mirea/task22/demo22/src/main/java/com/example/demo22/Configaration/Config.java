package com.example.demo22.Configaration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo22.repositories")
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class Config {

}
