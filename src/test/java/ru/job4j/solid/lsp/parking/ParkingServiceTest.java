package ru.job4j.solid.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParkingServiceTest {
    @Test
    void whenAddAndDeleteCarAndTruckThenTrue() {
        Parking parking = new Parking(10, 12);
        ParkingService service = new ParkingService(parking);
        Vehicle car_1 = new Car();
        Vehicle car_2 = new Car();
        Vehicle truck_1 = new Truck(3);
        Vehicle truck_2 = new Truck(4);
        Vehicle truck_3 = new Truck(2);
        assertThat(service.park(List.of(car_1, car_2, truck_1, truck_2, truck_3))).isTrue();
        assertThat(service.emptyCarPlaces()).isEqualTo(8);
        assertThat(service.emptyTruckPlaces()).isEqualTo(3);
        assertThat(service.delete(List.of(car_1, truck_2, truck_3))).isTrue();
        assertThat(service.getAllVehicles()).contains((Vehicle) List.of(car_2, truck_1));
    }

    @Test
    void whenAddAndDeleteCarAndTruckThenFalse() {
        Parking parking = new Parking(10, 12);
        ParkingService service = new ParkingService(parking);
        Vehicle car_1 = new Car();
        Vehicle car_2 = new Car();
        Vehicle car_3 = new Car();
        Vehicle car_4 = new Car();
        Vehicle car_5 = new Car();
        Vehicle car_6 = new Car();
        Vehicle car_7 = new Car();
        Vehicle car_8 = new Car();
        Vehicle car_9 = new Car();
        Vehicle car_10 = new Car();
        Vehicle car_11 = new Car();
        Vehicle truck_1 = new Truck(3);
        Vehicle truck_2 = new Truck(4);
        Vehicle truck_3 = new Truck(2);
        Vehicle truck_4 = new Truck(5);
        assertThat(service.park(List.of(car_1, car_2, car_3, car_4, car_5,
                car_6, car_7, car_8, car_9, car_10,
                car_11,
                truck_1, truck_2, truck_3,
                truck_4))).isFalse();
        assertThat(service.getAllVehicles()).doesNotContain((Vehicle) List.of(car_11, truck_4));
        assertThat(service.emptyCarPlaces()).isEqualTo(0);
        assertThat(service.emptyTruckPlaces()).isEqualTo(3);
    }
}