package ru.job4j.articles.model;

import java.util.Objects;

public class Word {

    private int id;

    private String value;

    public Word(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Word word = (Word) object;
        return id == word.id
                && Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
