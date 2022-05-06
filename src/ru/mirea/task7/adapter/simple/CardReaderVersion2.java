package ru.mirea.task7.adapter.simple;

public class CardReaderVersion2 extends MemoryCard implements USB {

    @Override
    public void connectWithUsbCable() {
        this.insert();
        this.copyData();
        this.drag();
    }
}
