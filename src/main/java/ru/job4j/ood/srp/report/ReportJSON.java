package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Employee.class, new Employee.EmployeeAdapter())
                .setPrettyPrinting()
                .create();
        return gson.toJson(store.findBy(filter));
    }
}
