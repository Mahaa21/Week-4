import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Marketing", 70000),
                new Employee(3, "Charlie", "Engineering", 95000),
                new Employee(4, "David", "Sales", 60000),
                new Employee(5, "Eva", "Engineering", 85000),
                new Employee(6, "Frank", "Engineering", 80000)
        );


        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()) && e.getSalary() > 80000)
                .collect(Collectors.toList());
        List<Employee> sortedEmployees = filteredEmployees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        Map<String, List<Employee>> groupedByDepartment = sortedEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averageSalaryByDepartment = groupedByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0)
                ));
        System.out.println("Filtered and Sorted Employees: " + sortedEmployees);
        System.out.println("Grouped by Department: " + groupedByDepartment);
        System.out.println("Average Salary by Department: " + averageSalaryByDepartment);
    }
}
