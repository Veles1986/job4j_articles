package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.currency.Currency;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportAccountants implements Report {

    private final DateTimeParser<Calendar> dateTimeParser;
    private final Store store;
    private final Currency source;
    private final Currency target;

    public ReportAccountants(DateTimeParser<Calendar> dateTimeParser, Store store, Currency source, Currency target) {
        this.dateTimeParser = dateTimeParser;
        this.store = store;
        this.source = source;
        this.target = target;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; Salary(")
                .append(target.toString())
                .append(");")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            result.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(source, employee.getSalary(), target))
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
