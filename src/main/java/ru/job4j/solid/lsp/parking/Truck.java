package ru.job4j.solid.lsp.parking;

public class Truck extends AbstractVehicle {
    private final int size;

    public Truck(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Trucks size cannot be less than 2.");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getVehicleType() {
        return "truck";
    }
}
