package com.example.demotask10.configuration;


import com.example.demotask10.components.KingOfKnights;
import com.example.demotask10.components.StrongKnight;
import com.example.demotask10.components.WeakKnight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Класс с аннотацией @Configuration говорит о том, что он является источником определения бинов
@Configuration
public class KnightConfiguration {

    // чтобы объявить Bean-объект(далее просто бин), достаточно указать аннотацию @Bean тому методу,
    // который возвращает тип бина как в классах с аннотацией @Configuration,
    // так и в классах с аннотацией @Component(или её наследниках).

    @Bean("KingOfKnights")
    public KingOfKnights kingOfKnights() {
        return new KingOfKnights();
    }

    @Bean("StrongKnight")
    public StrongKnight strongKnight() {
        return new StrongKnight();
    }

    @Bean("WeakKnight")
    public WeakKnight weakKnight() {
        return new WeakKnight();
    }
}