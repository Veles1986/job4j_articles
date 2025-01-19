package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {
    final private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @XmlRootElement(name = "employees")
    static class EmployeeList {
        private List<Employee> employee;

        public EmployeeList() {
        }

        public EmployeeList(List<Employee> employee) {
            this.employee = employee;
        }

        @XmlElement
        public List<Employee> getEmployee() {
            return employee;
        }

        public void setEmployee(List<Employee> employees) {
            this.employee = employees;
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<Employee> filteredEmployees = store.findBy(filter);
        EmployeeList employeeList = new EmployeeList(filteredEmployees);
        JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(employeeList, writer);
        return writer.toString();
    }
}
