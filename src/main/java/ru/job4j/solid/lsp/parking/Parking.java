package ru.job4j.solid.lsp.parking;

public interface Parking {
    boolean addVehicle(int size);
    boolean deleteVehicle(int size);
    boolean check();

    int getMaxNumberOfVehicles();

    int getFactNumberOfVehicles();

    String getParkingType();
}
