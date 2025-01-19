
import java.util.ArrayList;
import java.util.List;

class Company {
    List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    // Добавление сотрудника в компанию
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Удаление сотрудника по ID
    public void removeEmployee(int id) {
        employees.removeIf(employee -> employee.id == id);
    }

    // Вывод списка всех сотрудников
    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the company.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.getDetails());
            }
        }
    }
}
