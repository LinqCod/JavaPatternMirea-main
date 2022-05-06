package ru.mirea.task8.chainOfResponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestChain {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //private static Server server;
    private  Server server;
    /*public static void init(){
        server = new Server();//создаем сервер

        //заполняем "базу данных"
        server.register("admin@yandex.ru", "admin_pass");
        server.register("user@example.com", "user_pass");

        // Проверки связаны в одну цепь. Клиент может строить различные цепи, используя одни и те же компоненты.
        BaseCheck baseCheck = new LimitChecking(2);
        baseCheck.baseCheckLink(new DataChecking(server)).
                baseCheckLink(new EmailChecking());


        // Сервер получает цепочку от клиентского кода.
        // Можем делать несколько
        server.setBaseCheck(baseCheck);
    }
    */
    public static void main(String[] args) throws IOException {
        //init();
        App app = new App();
        app.init();
        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = app.auth(new User(email,password));
        } while (!success);
    }
    }

