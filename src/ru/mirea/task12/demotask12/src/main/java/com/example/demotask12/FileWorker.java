package com.example.demotask12;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Создать приложение, которое при запуске берет данные из одного
 * файла, хеширует, а при остановке приложения удаляет исходный файл,
 * оставляя только файл с захешированными данными.
 * Названия первого и второго файла передаются в качестве аргументов при запуске.
 * При отсутствии первого файла создает второй файл и записывает в него строку null.
 * Реализовать с использованием аннотаций PostConstruct, PreDestroy
 * */

//@Component is a generic stereotype for any Spring-managed component.
//@Service annotates classes at the service layer. - Поэтому выбираем данный тип
//@Repository annotates classes at the persistence layer, which will act as a database repository.

@Service
public class FileWorker {

    /**@Value является аннотацией Java, которая используется на уровне параметра поля или метода
    / конструктора и указывает значение по умолчанию для затронутого аргумента.
    Он обычно используется для ввода значений в конфигурационные переменные

    В этом примере значения переменных считываются из файла application.properties
    и присваиваются им во время создания компонента.

    Значения по умолчанию используются как «запасной вариант», если свойство,
    которое мы хотим внедрить, не определено или отсутствует:*/
    @Value("${input:input.txt}")
    private String input;
    @Value("${output:output.txt}")
    private String output;

    private File fileInput, fileOutput;//для файла ввода и вывода

    public FileWorker() {
        System.out.println("It's started");
    }

    //готовим файлы
    //Spring calls methods annotated with @PostConstruct only once, just after the initialization of bean properties.
    @PostConstruct
    //One example usage of @PostConstruct is populating a database.
    private void init() {
        System.out.println("Preparing files to work..");
        fileInput = new File(input);
        fileOutput = new File(output);
        System.out.println("Files prepared. Go to next step...");
    }

    public void hash() {
        System.out.println("Start hashing data from file..");
        //выполнение проверки согласно условию
        if (fileInput.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));//используем баффы, для лучшего использования памяти
                String content = new String(Files.readAllBytes(Paths.get(input)));//читаем байты по пути файла
                //DigestUtils – это утильный класс позволяющий зашифровать данные в MD5 и другие типы шифрования
                //Return a hexadecimal string representation of the MD5 digest of the given bytes.
                writer.write(DigestUtils.md5DigestAsHex(content.getBytes()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                writer.write("null");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }

    //главная часть: инициализация и запуск хеширования
    public void start(String input, String output) {
        this.input = input;
        this.output = output;
        init();
        hash();
    }

    @PreDestroy
    //The purpose of this method should be to release resources or perform any other cleanup tasks before
    // the bean gets destroyed, for example closing a database connection.
    private void finish() {
        System.out.println("Deleting input file...");
        fileInput.delete();
        System.out.println("Done");
    }

}
