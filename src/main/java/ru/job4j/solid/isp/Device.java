package ru.job4j.solid.isp;

public interface Device {
    void turnOn();
    void turnOff();
    void printDocument(String document);
    void scanDocument();
}