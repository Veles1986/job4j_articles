package ru.job4j.solid.lsp.foodstore;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private float price;
    private float discount;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Food() {
    }

    public Food(String name, String expiryDate, String createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = LocalDate.parse(expiryDate, format);
        this.createDate = LocalDate.parse(createDate, format);
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = LocalDate.parse(expiryDate, format);
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = LocalDate.parse(createDate, format);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
        setPrice(getPrice() * (1 - discount / 100));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Food food = (Food) object;
        return Float.compare(price, food.price) == 0
               && Float.compare(discount, food.discount) == 0
               && Objects.equals(name, food.name)
               && Objects.equals(expiryDate, food.expiryDate)
               && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{"
               + "name='" + name + '\''
               + ", expiryDate=" + expiryDate.format(format)
               + ", createDate=" + createDate.format(format)
               + ", price=" + price
               + ", discount=" + discount
               + '}';
    }
}
