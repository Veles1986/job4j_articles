package ru.job4j.solid.lsp.foodstore;

import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void redistribute(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                store.setDiscount();
                return;
            }
        }
    }

    public void redistributeAll(List<Food> foods) {
        foods.forEach(this::redistribute);
    }

    public void resort() {
        List<Food> allFoods = stores.stream()
                .flatMap(store -> store.getStock().stream())
                .toList();
        stores.forEach(store -> store.deleteAll(allFoods));
        redistributeAll(allFoods);
    }
}
