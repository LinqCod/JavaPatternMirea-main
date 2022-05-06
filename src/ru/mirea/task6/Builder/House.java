package ru.mirea.task6.Builder;

public class House {
    private Boolean hasFrame;
    private  Boolean hasGarage;
    private int rooms;

    public void buildFrame(Boolean hasFrame) {
        this.hasFrame = hasFrame;
    }

    public void buildGarage(Boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public void buildRooms(int rooms) {
        this.rooms = rooms;
    }

    public Boolean getHasFrame() {
        return hasFrame;
    }

    public Boolean getHasGarage() {
        return hasGarage;
    }

    public int getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "hasFrame=" + hasFrame +
                ", hasGarage=" + hasGarage+
                ", rooms=" + rooms +
                '}';
    }
}
