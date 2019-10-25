package company.roaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
