package ru.job4j.solid.ocp;

public class What {

    private final Animal animal;

    public What(Animal animal) {
        this.animal = animal;
    }

    public static void main(String[] args) {
        What what = new What(new Carrot());
        what.kindOfAnimal();
    }

    public void kindOfAnimal() {
        if (animal.getClass() == Lion.class) {
            System.out.println("Its Lion!");
        } else {
            System.out.println("Its Carrot");
        }
    }
}
