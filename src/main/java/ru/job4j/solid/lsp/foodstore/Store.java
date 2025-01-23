package ru.job4j.solid.lsp.foodstore;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void add(Food food);
    List<Food> delete(String name);
    void deleteAll(List<Food> foods);
    List<Food> getStock();
    List<Food> findByName(String name);
    List<Food> findByExpiryDate(Predicate<Food> filter);
    float getShelfLifePercent(Food food);
    boolean accept(Food food);
    List<Food> unnecessaryGoods();
    void setDiscount();
}
