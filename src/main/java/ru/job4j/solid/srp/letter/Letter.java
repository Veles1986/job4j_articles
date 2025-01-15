package ru.job4j.solid.srp.letter;

public interface Letter {
    void letter(String word);
    boolean validate(String word);
}
