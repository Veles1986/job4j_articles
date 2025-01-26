package ru.job4j.solid.lsp.parking;

public class Car extends AbstractVehicle {
    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String getVehicleType() {
        return "car";
    }
}
