package ru.mirea.task8.chainOfResponsibility;

public class DataChecking extends BaseCheck{
    private Server server;

    public DataChecking(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(User user) {
        if (!server.hasEmail(user)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(user)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(user);
    }
}
