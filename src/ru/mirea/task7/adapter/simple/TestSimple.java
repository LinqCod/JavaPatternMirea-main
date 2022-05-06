package ru.mirea.task7.adapter.simple;

public class TestSimple {
    public static void main(String[] args) {
        USB cardreader = new CardReaderVersion1();
        cardreader.connectWithUsbCable();

        System.out.println();

        USB cardreader2 = new CardReaderVersion2();
        cardreader2.connectWithUsbCable();
    }
}
