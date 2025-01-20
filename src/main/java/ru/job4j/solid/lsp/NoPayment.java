package ru.job4j.solid.lsp;

import java.util.List;

public class NoPayment extends Payment {
    @Override
    public void processPayments(List<Double> payments) {
        System.out.println("No payments processed");
    }
}
