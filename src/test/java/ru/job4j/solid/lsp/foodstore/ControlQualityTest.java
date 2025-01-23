package ru.job4j.solid.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenRedistributeToWarehouse() throws ParseException {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));

        Food food = new Food("Milk", "20.12.2025", "20.12.2024", 100.0f, 0);
        control.redistribute(food);

        assertThat(warehouse.getStock()).contains(food);
        assertThat(shop.getStock()).isEmpty();
        assertThat(trash.getStock()).isEmpty();
    }

    @Test
    void whenRedistributeToShopWithDiscount() throws ParseException {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));

        Food food = new Food("Bread", "25.01.2025", "01.01.2023", 100.0f, 0);
        control.redistribute(food);

        assertThat(shop.getStock()).contains(food);
        assertThat(food.getPrice()).isEqualTo(80.0f); // Цена с учетом скидки.
    }

    @Test
    void whenRedistributeToTrash() throws ParseException {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));

        Food food = new Food("Yogurt", "20.01.2023", "20.12.2022", 50.0f, 0);
        control.redistribute(food);

        assertThat(trash.getStock()).contains(food);
    }

    @Test
    void whenResort() throws ParseException {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));

        Food food1 = new Food("Milk", "20.12.2025", "20.12.2024", 100.0f, 0);
        Food food2 = new Food("Bread", "25.01.2025", "01.01.2023", 100.0f, 0);
        Food food3 = new Food("Yogurt", "20.01.2023", "20.12.2022", 50.0f, 0);

        control.redistributeAll(List.of(food1, food2, food3));
        control.resort();

        assertThat(warehouse.getStock()).contains(food1);
        assertThat(shop.getStock()).contains(food2);
        assertThat(trash.getStock()).contains(food3);
    }
}
