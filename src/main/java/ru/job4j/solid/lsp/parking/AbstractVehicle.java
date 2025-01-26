package ru.job4j.solid.lsp.parking;

public abstract class AbstractVehicle implements Vehicle {
    public AbstractVehicle() {
    }

    @Override
    public String toString() {
        return "AbstractVehicle{"
                + "size=" + getSize()
                + '}';
    }
}
