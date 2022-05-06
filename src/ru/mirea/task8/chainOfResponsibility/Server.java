package ru.mirea.task8.chainOfResponsibility;

import java.util.ArrayList;

public class Server {
    private ArrayList<User> users = new ArrayList<User>();
    private  BaseCheck baseCheck;

    public void setBaseCheck(BaseCheck baseCheck) {
        this.baseCheck = baseCheck;
    }

    public boolean logIn(User user) {
        if (baseCheck.check(user)) {
            System.out.println("Authorization have been successful!");
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.add(new User(email,password));
    }

    public boolean hasEmail(User user) {
        for (User oneuser:users) {
            if (oneuser.getEmail().equals(user.getEmail())) return true;
        }
        return false;
    }

    public boolean isValidPassword(User user) {
        for (User oneuser:users) {
            if (oneuser.getPassword().equals(user.getPassword())) return true;
        }
        return false;
    }
}
