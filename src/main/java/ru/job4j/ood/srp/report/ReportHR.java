package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {

    private final Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        result.append("Name; Salary(Desc)")
                .append(System.lineSeparator());
        Comparator<Employee> comparator = (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
        for (Employee employee : store.findBy(filter).stream().sorted(comparator).collect(Collectors.toList())) {
            result.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
