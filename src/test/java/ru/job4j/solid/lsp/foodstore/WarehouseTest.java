package ru.job4j.solid.lsp.foodstore;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

    @Test
    void whenAddToWarehouse() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Food food = new Food("Milk", "20.12.2025", "20.12.2024", 100.0f, 0);
        assertThat(warehouse.accept(food)).isTrue();
        warehouse.add(food);
        assertThat(warehouse.getStock()).contains(food);
    }

    @Test
    void whenAddToShopWithDiscount() {
        Shop shop = new Shop(new ArrayList<>());
        Food food = new Food("Bread", "20.01.2024", "20.12.2023", 100.0f, 0);
        shop.add(food);
        shop.setDiscount();
        assertThat(food.getPrice()).isEqualTo(80.0f);
    }

    @Test
    void whenAddToTrash() {
        Trash trash = new Trash(new ArrayList<>());
        Food food = new Food("Yogurt", "20.01.2023", "20.12.2022", 50.0f, 0);
        assertThat(trash.accept(food)).isTrue();
        trash.add(food);
        assertThat(trash.getStock()).contains(food);
    }
}
