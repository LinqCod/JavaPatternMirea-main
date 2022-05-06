package ru.mirea.task8.chainOfResponsibility;

public class BaseCheck implements  Checking{
    private  BaseCheck next;

    public BaseCheck baseCheckLink(BaseCheck next){
        this.next=next;
        return next;
    }

    @Override
    public boolean check(User user) {
        return false;
    }

    @Override
    public boolean checkNext(User user) {
        if (next == null) {
            return true;
        }
        return next.check(user);
    }
}
