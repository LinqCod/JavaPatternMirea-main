package com.example.demotask12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Interface used to indicate that a bean should run when it is contained within a SpringApplication - CommandLineRunner

@SpringBootApplication
public class Demotask12Application implements CommandLineRunner {

    //Аннотация Autowired попросила Spring в поле, которое она аннотирует, подставить значение.
    //Эта операция называется «инжектнуть» (inject)
    @Autowired
    private FileWorker fileWorker;

    public static void main(String[] args) {
        //D:\java\2cource\Exapmle_GUI\JavaPatternMirea\src\ru\mirea\task12\demotask12\src\main\java\com\example\demotask12\input.txt witcher.txt
        //в programme atributes
        SpringApplication app = new SpringApplication(Demotask12Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 2) fileWorker.start(args[0], args[1]);
        else fileWorker.hash();
        // else standard input.txt-output.txt we will see
    }
}
