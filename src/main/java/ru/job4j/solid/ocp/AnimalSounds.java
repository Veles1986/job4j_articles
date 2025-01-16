package ru.job4j.solid.ocp;

public class AnimalSounds {

    private final Lion lion;

    public AnimalSounds(Lion lion) {
        this.lion = lion;
    }

    public void getSound() {
        lion.sound();
    }

    public static void main(String[] args) {
        AnimalSounds sounds = new AnimalSounds(new Lion());
        sounds.getSound();
    }
}
