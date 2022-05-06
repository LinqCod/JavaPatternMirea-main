package ru.mirea.task6.Builder;

public interface Builder {
    void setFrame(Boolean hasFrame);
    void setGarage(Boolean hasGarage);
    void setRooms(int numberRoom);
    House getResult();
}
