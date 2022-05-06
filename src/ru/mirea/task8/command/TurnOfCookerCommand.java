package ru.mirea.task8.command;

public class TurnOfCookerCommand implements Command{
    private  Cooker cooker;

    public TurnOfCookerCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.turnOff();
    }
}
