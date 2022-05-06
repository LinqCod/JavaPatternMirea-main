package ru.mirea.task8.chainOfResponsibility;

public class LimitChecking extends BaseCheck{
    private int requestPerMinute;//число запросов в минуту
    private int request;    //число запросов
    private long currentTime;//текущее время

    //сами будет задавать сколько запросов за минуту можно делать
    public LimitChecking(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(User user) {

        //если запросы совершаются реже чем минуты, но будем обнулять
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();//прекращение потока - переписать потом нормально - устарело
        }
        return checkNext(user);
    }
}
