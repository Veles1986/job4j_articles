package ru.job4j.solid.lsp.parking;

public class TruckParking extends AbstractParking {
    private final int maxNumberOfVehicles;

    public TruckParking(int maxNumberOfTrucks) {
        this.maxNumberOfVehicles = maxNumberOfTrucks;
    }

    @Override
    public boolean addVehicle(int size) {
        increaseFactNumberOfVehicles(size);
        if (!check()) {
            reduceFactNumberOfVehicles(size);
            System.out.println("No more special places for trucks");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteVehicle(int size) {
        if (getFactNumberOfVehicles() < size) {
            System.out.println("There are no trucks in the parking lot...¯\\_(ツ)_/¯");
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
        return "truck";
    }

    @Override
    public int getMaxNumberOfVehicles() {
        return maxNumberOfVehicles;
    }
}
