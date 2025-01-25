package ru.job4j.solid.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParkingServiceTest {
    @Test
    void whenAddAndDeleteCarAndTruckThenTrue() {
        Parking parking = new Parking(10, 12);
        ParkingService service = new ParkingService(parking);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(4);
        Vehicle truck3 = new Truck(2);
        assertThat(service.park(List.of(car1, car2, truck1, truck2, truck3))).isTrue();
        assertThat(service.emptyCarPlaces()).isEqualTo(8);
        assertThat(service.emptyTruckPlaces()).isEqualTo(3);
        assertThat(service.delete(List.of(car1, truck2, truck3))).isTrue();
        assertThat(service.getAllVehicles()).contains((Vehicle) List.of(car2, truck1));
    }

    @Test
    void whenAddAndDeleteCarAndTruckThenFalse() {
        Parking parking = new Parking(10, 12);
        ParkingService service = new ParkingService(parking);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        Vehicle car4 = new Car();
        Vehicle car5 = new Car();
        Vehicle car6 = new Car();
        Vehicle car7 = new Car();
        Vehicle car8 = new Car();
        Vehicle car9 = new Car();
        Vehicle car10 = new Car();
        Vehicle car11 = new Car();
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(4);
        Vehicle truck3 = new Truck(2);
        Vehicle truck4 = new Truck(5);
        assertThat(service.park(List.of(car1, car2, car3, car4, car5,
                car6, car7, car8, car9, car10,
                car11,
                truck1, truck2, truck3,
                truck4))).isFalse();
        assertThat(service.getAllVehicles()).doesNotContain((Vehicle) List.of(car11, truck4));
        assertThat(service.emptyCarPlaces()).isEqualTo(0);
        assertThat(service.emptyTruckPlaces()).isEqualTo(3);
    }
}