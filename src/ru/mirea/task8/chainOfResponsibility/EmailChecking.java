package ru.mirea.task8.chainOfResponsibility;

//не соответствует логике - переписать
//больше проверка для делегирования полномочий
//проверка больше для тренировки - не несет смысла

public class EmailChecking extends BaseCheck{
    EmailValidator emailValidator = new EmailValidator();
    @Override
    public boolean check(User user) {
        if (user.getEmail().equals("admin@yandex.ru")) {
            System.out.println("Hello, admin!");
            return true;
        }
        if (emailValidator.validate(user.getEmail())){
            System.out.println("Hello! You are simple user, not admin!");
            return checkNext(user);
        }
        System.out.println("Hello! You are simple user, not admin! change email");
        return checkNext(user);
        //return false;
    }
}
