package ru.job4j.solid.isp;

public class Printer implements Device {
    @Override
    public void turnOn() {
        System.out.println("Printer is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Printer is now OFF.");
    }

    @Override
    public void printDocument(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scanDocument() {
        throw new UnsupportedOperationException("Printers cannot scan documents.");
    }
}