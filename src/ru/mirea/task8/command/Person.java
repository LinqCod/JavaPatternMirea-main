package ru.mirea.task8.command;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Command> listCommand;

    public Person() {
        this.listCommand = new ArrayList<>();
    }

    public void addCommand(Command command){
        listCommand.add(command);
    }

    public  void executeCommand(){
        listCommand.forEach(Command::execute);
        listCommand.clear();
    }
}
