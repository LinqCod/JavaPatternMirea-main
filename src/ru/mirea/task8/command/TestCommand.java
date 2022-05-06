package ru.mirea.task8.command;

public class TestCommand {
    private CommandHistory history = new CommandHistory();
    public static void main(String[] args) {
        Cooker cooker = new Cooker();
        Command command1 = new TurnOnCookerCommand(cooker);
        Command command2 = new TurnOfCookerCommand(cooker);


        Person person = new Person();

        person.addCommand(command1);
        person.addCommand(command2);
        person.executeCommand();
    }
}
