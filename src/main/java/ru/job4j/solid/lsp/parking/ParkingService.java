package ru.job4j.solid.lsp.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingService {
    private final HashMap<String, Parking> parkings = new HashMap<>();
    private final List<Vehicle> vehicles;
    private final List<Vehicle> queueOfVehicles = new ArrayList<>();

    public ParkingService(List<Parking> parkings) {
        for (Parking parking : parkings) {
            this.parkings.put(parking.getParkingType(), parking);
        }
        vehicles = new LinkedList<>();
    }

    public boolean park(List<Vehicle> list) {
        boolean result = true;
        for (Vehicle vehicle : list) {
            if (parkings.get(vehicle.getVehicleType()).addVehicle(vehicle.getSize())) {
                this.vehicles.add(vehicle);
                System.out.println(vehicle + "\nAdded to the parking!");
            } else {
                queueOfVehicles.add(vehicle);
                System.out.println(vehicle + "\nNot added to the parking!");
                result = false;
            }
        }
        return result;
    }

    public boolean delete(List<Vehicle> list) {
        for (Vehicle vehicle : list) {
            if (parkings.get(vehicle.getVehicleType()).deleteVehicle(vehicle.getSize())) {
                this.vehicles.remove(vehicle);
                System.out.println(vehicle + "\nRemoved from the parking!");
            } else {
                System.out.println("This parking is empty");
                return false;
            }
        }
        return true;
    }

    public List<Integer> allEmptyPlaces() {
        return parkings.values().stream()
                .map(a -> a.getMaxNumberOfVehicles() - a.getFactNumberOfVehicles())
                .collect(Collectors.toList());
    }

    public int emptyPlaces(String parkingType) {
        return parkings.values().stream()
                .filter(parking -> parkingType.equals(parking.getParkingType()))
                .map(a -> a.getMaxNumberOfVehicles() - a.getFactNumberOfVehicles())
                .toList()
                .get(0);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
