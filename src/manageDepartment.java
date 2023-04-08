import java.util.Scanner;

class manageDepartment {
    public static void execute(Scanner scanner) {
        Department.addDepartment("src\\departments.txt");
        System.out.println("\nDEPARTMENTS");
        System.out.println("1. Add department");
        System.out.println("2. Delete department");
        System.out.println("3. List departments");

        int departmentChoice = scanner.nextInt();
        scanner.nextLine();

        if (departmentChoice == 1) {
            System.out.print("Enter department name: ");
            String departmentName = scanner.nextLine();
            Department.addDepartment(departmentName);
        }

        else if (departmentChoice == 2) {
            System.out.print("Enter department name: ");
            String departmentName = scanner.nextLine();
            Department.deleteDepartment(departmentName);
        }

        else if (departmentChoice == 3) {
            Department.listAllDepartments();
        }
    }
}