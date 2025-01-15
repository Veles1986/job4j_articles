package ru.job4j.solid.srp.letter;

public class FirstLetter implements Letter {
    @Override
    public void letter(String word) {
        System.out.println(word.charAt(0));
    }

    @Override
    public boolean validate(String word) {
        return !word.contains(" ");
    }
}
