package ru.job4j.solid.lsp.parking;

import java.util.List;

public class ParkingService {
    private final Parking parking;
    private final List<Vehicle> vehicles;

    public ParkingService(Parking parking, List<Vehicle> vehicles) {
        this.parking = parking;
        this.vehicles = vehicles;
    }
}
