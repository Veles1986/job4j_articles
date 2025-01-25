package ru.job4j.solid.lsp.parking;

public class Parking {
    private final int maxNumberOfCars;
    private int factNumberOfCars;
    private final int maxNumberOfTrucks;
    private int factNumberOfTrucks;

    public Parking(int maxNumberOfCars, int maxNumberOfTrucks) {
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

    public void addCar() {
        factNumberOfCars++;
        if (!checkCar()) {
            factNumberOfCars--;
            System.out.println("No more places for cars");
        }
    }

    public int getFactNumberOfTrucks() {
        return factNumberOfTrucks;
    }

    public void addTruck() {
        factNumberOfTrucks++;
        if (!checkTruck()) {
            factNumberOfTrucks--;
            System.out.println("No more places for trucks");
        }
    }

    public boolean checkCar() {
        return false;
    }

    public boolean checkTruck() {
        return false;
    }
}
