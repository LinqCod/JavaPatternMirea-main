package com.example.demotask10;

import com.example.demotask10.components.StrongKnight;
import com.example.demotask10.configuration.KnightConfiguration;
import com.example.demotask10.interfaces.Knight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoTask10Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(KnightConfiguration.class);

        Knight kk = (Knight) applicationContext.getBean("KingOfKnights");
        Knight sk = applicationContext.getBean(StrongKnight.class);
        Knight wk = (Knight) applicationContext.getBean("WeakKnight");

        kk.fight();
        sk.fight();
        wk.fight();


    }

}
