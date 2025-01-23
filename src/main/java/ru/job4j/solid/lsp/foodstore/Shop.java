package ru.job4j.solid.lsp.foodstore;

import java.util.List;
import java.util.stream.Collectors;

public class Shop extends AbstractStore {
    private final float shelfLifePercent = 0.75f;
    private final float shelfLifePercentDiscount = 0.25f;
    private final float shelfLifePercentBottom = 0f;
    private final float discount = 20f;

    public Shop(List<Food> stock) {
        super(stock);
    }

    @Override
    public boolean accept(Food food) {
        float shelfLifePercent = getShelfLifePercent(food);
        return shelfLifePercent < this.shelfLifePercent
                && shelfLifePercent >= shelfLifePercentBottom;
    }

    @Override
    public List<Food> unnecessaryGoods() {
        List<Food> list = getStock().stream().filter(food -> !accept(food)).collect(Collectors.toList());
        deleteAll(list);
        return list;
    }

    @Override
    public void setDiscount() {
        getStock().forEach(food -> {
            if (getShelfLifePercent(food) < shelfLifePercentDiscount) {
                food.setDiscount(discount);
            }
        });
    }
}
