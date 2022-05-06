package ru.mirea.task7.adapter.simple;

public class CardReaderVersion1 implements USB {

    private MemoryCard memoryCard=new MemoryCard();

    public CardReaderVersion1() {

    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
        this.memoryCard.drag();
    }
}
