package ru.job4j.solid.lsp;

import java.util.List;

public class Payment {
    public void processPayments(List<Double> payments) {
        for (Double payment : payments) {
            System.out.println("Processing payment: " + payment);
        }
    }
}
