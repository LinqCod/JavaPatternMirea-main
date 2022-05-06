package ru.mirea.task8.chainOfResponsibility;

public interface Checking {
    boolean check(User user);
    boolean  checkNext(User user);
}
