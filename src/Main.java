import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();

        while (true) {
            System.out.println("Welcome to the Employee Record System");
            System.out.println("Choose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Assign Resource to Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Generate Employee Report");
            System.out.println("6. Print Employees in Department");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            if (choice == 1) {
                // Add Employee
                System.out.println("Enter Employee Details:");
                System.out.print("Employee ID: ");
                int empId = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                System.out.print("Employee Name: ");
                String empName = scanner.nextLine();

                System.out.print("Department: ");
                String department = scanner.nextLine();

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();  // Consume newline

                Employee employee = new Employee(empId, empName, department, salary);
                company.addEmployee(employee);
                System.out.println("Employee added successfully!\n");
            } 
            else if (choice == 2) {
                // Remove Employee
                System.out.print("Enter Employee ID to remove: ");
                int removeId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                company.removeEmployee(removeId);
                System.out.println("Employee removed successfully!\n");
            } 
            else if (choice == 3) {
                // Assign Resource to Employee
                System.out.print("Enter Employee ID to assign resource: ");
                int assignId = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                System.out.print("Enter Resource Name (e.g., Laptop A): ");
                String resourceName = scanner.nextLine();

                company.assignResourceToEmployee(assignId, resourceName);
                System.out.println("Resource assigned successfully!\n");
            } 
            else if (choice == 4) {
                // Update Salary
                System.out.print("Enter Employee ID to update salary: ");
                int salaryId = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                System.out.print("Enter New Salary: ");
                double newSalary = scanner.nextDouble();
                scanner.nextLine();  // Consume newline

                company.updateSalary(salaryId, newSalary);
                System.out.println("Salary updated successfully!\n");
            } 
            else if (choice == 5) {
                // Generate Employee Report
                company.generateEmployeeReport();
            } 
            else if (choice == 6) {
                // Print Employees in Department
                System.out.print("Enter Department Name to view employees: ");
                String departmentName = scanner.nextLine();
                company.printDepartmentEmployees(departmentName);
            } 
            else if (choice == 7) {
                // Quit
                System.out.println("Goodbye!");
                scanner.close();
                return;  // Exit the program
            } 
            else {
                System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
