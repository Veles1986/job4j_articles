package ru.job4j.solid.lsp.foodstore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractStore implements Store {
    private final List<Food> stock;

    public AbstractStore(List<Food> stock) {
        this.stock = stock;
    }

    public void add(Food food) {
        stock.add(food);
    }
    public List<Food> delete(String name) {
        List<Food> deleted = findByName(name);
        stock.removeAll(deleted);
        return deleted;
    }

    public void deleteAll(List<Food> foods) {
        stock.removeAll(foods);
    }

    public List<Food> getStock() {
        return stock;
    }
    public List<Food> findByName(String name) {
        return stock.stream()
                .filter(food -> food.getName().contains(name))
                .collect(Collectors.toList());
    }
    public List<Food> findByExpiryDate(Predicate<Food> filter) {
        return stock.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public float getShelfLifePercent(Food food) {
        return (float) ChronoUnit.DAYS.between(food.getExpiryDate(), LocalDate.now())
               / ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
    }

    public abstract boolean accept(Food food);
    public abstract List<Food> unnecessaryGoods();
    public abstract void setDiscount();
}
