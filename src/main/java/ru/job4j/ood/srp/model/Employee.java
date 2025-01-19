package ru.job4j.ood.srp.model;

import com.google.gson.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"name", "hired", "fired", "salary"})
public class Employee {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "hired")
    @XmlJavaTypeAdapter(CalendarAdapter.class)

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    @XmlElement(name = "fired")
    @XmlJavaTypeAdapter(CalendarAdapter.class)

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    @XmlElement(name = "salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static class CalendarAdapter extends XmlAdapter<String, Calendar> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

        @Override
        public Calendar unmarshal(String s) throws Exception {
            Calendar calendar = Calendar.getInstance();
            Date date = dateFormat.parse(s);
            calendar.setTime(date);
            return calendar;
        }

        @Override
        public String marshal(Calendar calendar) {
            return dateFormat.format(calendar.getTime());
        }
    }

    public static class EmployeeAdapter implements JsonSerializer<Employee>, JsonDeserializer<Employee> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

        @Override
        public JsonObject serialize(Employee employee, Type type, JsonSerializationContext jsonSerializationContext) throws JsonParseException {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", employee.getName());
            jsonObject.addProperty("hired", dateFormat.format(employee.getHired().getTime()));
            jsonObject.addProperty("fired", dateFormat.format(employee.getFired().getTime()));
            jsonObject.addProperty("salary", employee.getSalary());
            return jsonObject;
        }

        @Override
        public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            try {
                String name = jsonObject.get("name").getAsString();
                Calendar hired = new GregorianCalendar();
                hired.setTime(dateFormat.parse(jsonObject.get("hired").getAsString()));
                Calendar fired = new GregorianCalendar();
                fired.setTime(dateFormat.parse(jsonObject.get("fired").getAsString()));
                double salary = jsonObject.get("salary").getAsDouble();
                return new Employee(name, hired, fired, salary);
            } catch (Exception e) {
                throw new JsonParseException("Error parsing date", e);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}