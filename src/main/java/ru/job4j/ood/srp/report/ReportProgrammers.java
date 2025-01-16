package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {

    private final Store store;
    private final DateTimeParser dateTimeParser;

    public ReportProgrammers(Store store, DateTimeParser dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        result.append("Name;Hired;Fired;Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            result.append(employee.getName()).append(";")
                    .append(dateTimeParser.parse(employee.getHired())).append(";")
                    .append(dateTimeParser.parse(employee.getFired())).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}