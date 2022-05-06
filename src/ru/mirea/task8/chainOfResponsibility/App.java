package ru.mirea.task8.chainOfResponsibility;

public class App {
    Server server = new Server();//создаем сервер
    public void init(){



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
    public   boolean auth(User user){
        return server.logIn(user);
    }
}
