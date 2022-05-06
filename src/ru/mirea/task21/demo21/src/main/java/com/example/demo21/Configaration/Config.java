package com.example.demo21.Configaration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo21.repositories")
@EnableAspectJAutoProxy
@EnableAsync
public class Config {

}
