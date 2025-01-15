package ru.job4j.solid.srp.calculator;

public class Subtraction implements Calculator {
    @Override
    public double function(double first, double second) {
        return first - second;
    }

    @Override
    public void print(double result) {
        System.out.println(result);
    }
}
