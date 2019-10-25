package company.roaster;

import java.util.*;

public class Main {

    public static final String highestAverageString = "Highest Average Salary: %s%n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");

            Employee employee = null;
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            int age = 0;
            String email = null;

            if (data.length == 4) {
                employee = new Employee(name, salary, position, department);


            } else if (data.length == 5) {
                if (tryParseInt(data[4])) {
                    age = Integer.parseInt(data[4]);
                    employee = new Employee(name, salary, position, department, age);

                } else {
                    email = data[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                email = data[4];
                age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            departments = addEmployee(departments, department, employee);
        }

        String highestAverageDepartment = findHighestAverageDepartment(departments);
        double highestAverageSalary = Double.MIN_VALUE;

        System.out.printf(highestAverageString,highestAverageDepartment);
        departments.get(highestAverageDepartment).getEmployees().stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }

    private static String findHighestAverageDepartment(Map<String, Department> departments) {
        String highestAverageDepartment = "";
        double highestAverageSalary = Double.MIN_VALUE;

        for (Map.Entry<String,Department> entry : departments.entrySet()){
            double sum = 0;
            double avg = 0;
            List<Employee> employees = entry.getValue().getEmployees();

            for (Employee employee : employees){
                sum += employee.getSalary();
            }

            avg = sum / employees.size();

            if (avg > highestAverageSalary){
                highestAverageSalary = avg;
                highestAverageDepartment = entry.getKey();
            }
        }
        return highestAverageDepartment;
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Map<String, Department> addEmployee(Map<String, Department> departments, String department, Employee employee) {
        if (!departments.containsKey(department)) {
            departments.put(department, new Department());
            departments.get(department).getEmployees().add(employee);
            return departments;
        } else {
            departments.get(department).getEmployees().add(employee);
            return departments;
        }
    }


}
