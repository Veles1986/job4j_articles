package ru.job4j.solid.lsp.parking;

public class Parking {
    private final int maxNumberOfCars;
    private int factNumberOfCars;
    private final int maxNumberOfTrucks;
    private int factNumberOfTrucks;

    public Parking(int maxNumberOfCars, int maxNumberOfTrucks) {
        if (maxNumberOfCars <= 0 || maxNumberOfTrucks <= 0) {
            throw new IllegalArgumentException("Illegal number of vehicles. It must be greater than zero.");
        }
        this.maxNumberOfCars = maxNumberOfCars;
        this.maxNumberOfTrucks = maxNumberOfTrucks;
    }

    public int getMaxNumberOfCars() {
        return maxNumberOfCars;
    }

    public int getMaxNumberOfTrucks() {
        return maxNumberOfTrucks;
    }

    public int getFactNumberOfCars() {
        return factNumberOfCars;
    }

    public boolean addCar() {
        factNumberOfCars++;
        if (!checkCar()) {
            factNumberOfCars--;
            System.out.println("No more places for cars");
            return false;
        }
        return true;
    }

    public boolean deleteCar() {
        if (factNumberOfCars < 0) {
            System.out.println("There are no cars in the parking lot...¯\\_(ツ)_/¯");
            return false;
        } else {
            factNumberOfCars--;
            System.out.println("Successfully!!!");
            return true;
        }
    }

    public int getFactNumberOfTrucks() {
        return factNumberOfTrucks;
    }

    public void addTruck(int size) {
        factNumberOfTrucks += size;
        if (!checkTruck() || !checkTruckInPlaceOfCar()) {
            factNumberOfTrucks -= size;
            System.out.println("No more places for trucks");
        }
    }

    public void deleteTruck(int size) {
        if (factNumberOfTrucks < size) {
            System.out.println("There are no trucks in the parking lot...¯\\_(ツ)_/¯");
        } else {
            factNumberOfTrucks -= size;
            System.out.println("Successfully!!!");
        }
    }

    public boolean checkCar() {
        return false;
    }

    public boolean checkTruck() {
        return false;
    }

    public boolean checkTruckInPlaceOfCar() {
        return false;
    }
}
