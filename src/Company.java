import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;
    private List<Department> departments;
    private List<Resource> resources;

    // Constructor
    public Company() {
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        resources = new ArrayList<>();
    }

    // Add employee to the company
    public void addEmployee(Employee employee) {
        employees.add(employee);
        Department department = findOrCreateDepartment(employee.getDepartment());
        department.addEmployee(employee);
    }

    // Remove employee by ID
    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getEmployeeId() == employeeId);
        for (Department department : departments) {
            department.removeEmployee(employeeId);
        }
    }

    // Find or create department
    private Department findOrCreateDepartment(String departmentName) {
        for (Department department : departments) {
            if (department.getEmployees().stream().anyMatch(e -> e.getDepartment().equals(departmentName))) {
                return department;
            }
        }
        Department newDepartment = new Department(departmentName);
        departments.add(newDepartment);
        return newDepartment;
    }

    // Assign resource to an employee
    public void assignResourceToEmployee(int employeeId, String resourceName) {
        Resource resource = new Resource(resourceName, "Laptop"); // Example resource type (e.g., Laptop)
        resources.add(resource);
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employee.setAssignedResource(resource);
                break;
            }
        }
    }

    // Update employee salary
    public void updateSalary(int employeeId, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employee.setSalary(newSalary);
                break;
            }
        }
    }

    // Generate employee report
    public void generateEmployeeReport() {
        for (Employee employee : employees) {
            System.out.println(employee);
            if (employee.getAssignedResource() != null) {
                System.out.println("Assigned Resource: " + employee.getAssignedResource());
            }
            System.out.println("---------------");
        }
    }

    // Print all employees in a department
    public void printDepartmentEmployees(String departmentName) {
        for (Department department : departments) {
            if (department.toString().contains(departmentName)) {
                department.getEmployees().forEach(employee -> System.out.println(employee));
            }
        }
    }
}
