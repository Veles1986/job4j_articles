package ru.job4j.solid.lsp.parking;

public abstract class AbstractParking implements Parking {

    private int factNumberOfVehicles;

    public int getFactNumberOfVehicles() {
        return factNumberOfVehicles;
    }

    public void increaseFactNumberOfVehicles(int size) {
        this.factNumberOfVehicles += size;
    }

    public void reduceFactNumberOfVehicles(int size) {
        this.factNumberOfVehicles -= size;
    }
}
