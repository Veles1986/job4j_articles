package ru.job4j.solid.lsp.parking;

public class CarParking extends AbstractParking {
    private final int maxNumberOfVehicles;

    public CarParking(int maxNumberOfCars) {
        this.maxNumberOfVehicles = maxNumberOfCars;
    }

    @Override
    public boolean addVehicle(int size) {
        increaseFactNumberOfVehicles(size);
        if (!check()) {
            reduceFactNumberOfVehicles(size);
            System.out.println("No more places for cars");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteVehicle(int size) {
        if (getMaxNumberOfVehicles() < 0) {
            System.out.println("There are no cars in the parking lot...¯\\_(ツ)_/¯");
            return false;
        } else {
            reduceFactNumberOfVehicles(size);
            System.out.println("Successfully!!!");
            return true;
        }
    }

    @Override
    public boolean check() {
        return getFactNumberOfVehicles() <= getMaxNumberOfVehicles();
    }

    @Override
    public String getParkingType() {
        return "car";
    }

    @Override
    public int getMaxNumberOfVehicles() {
        return maxNumberOfVehicles;
    }
}
