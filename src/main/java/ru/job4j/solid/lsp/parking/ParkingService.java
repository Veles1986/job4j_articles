package ru.job4j.solid.lsp.parking;

import java.util.LinkedList;
import java.util.List;

public class ParkingService {
    private final Parking parking;
    private final List<Vehicle> vehicles;

    public ParkingService(Parking parking) {
        this.parking = parking;
        vehicles = new LinkedList<>();
    }

    public boolean park(List<Vehicle> list) {
        for (Vehicle vehicle : list) {
            if (parking.addCar()) {
                this.vehicles.add(vehicle);
                System.out.println(vehicle.toString() + "\nAdded to the parking!");
            } else {
                System.out.println("There is no more place for all vehicles starting for this one:\n" + vehicle.toString());
                return false;
            }
        }
        return true;
    }

    public boolean delete(List<Vehicle> list) {
        for (Vehicle vehicle : list) {
            if (parking.deleteCar()) {
                this.vehicles.remove(vehicle);
                System.out.println(vehicle.toString() + "\nRemoved from the parking!");
            } else {
                System.out.println("This parking is empty");
                return false;
            }
        }
        return true;
    }

    public int emptyCarPlaces() {
        return parking.getMaxNumberOfCars() - parking.getFactNumberOfCars();
    }

    public int emptyTruckPlaces() {
        return parking.getMaxNumberOfTrucks() - parking.getFactNumberOfTrucks();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
