package ru.job4j.solid.lsp.foodstore;

import java.util.List;
import java.util.stream.Collectors;

public class Warehouse extends AbstractStore {
    private final float shelfLifePercent = 0.75f;

    public Warehouse(List<Food> stock) {
        super(stock);
    }

    @Override
    public boolean accept(Food food) {
        return getShelfLifePercent(food) >= shelfLifePercent;
    }

    @Override
    public List<Food> unnecessaryGoods() {
        List<Food> list = getStock().stream().filter(food -> !accept(food)).collect(Collectors.toList());
        deleteAll(list);
        return list;
    }

    @Override
    public void setDiscount() {
    }
}
