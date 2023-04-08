import java.util.Scanner;

public class canvas
{
    static public Integer execute(Scanner scanner)
    {
        Scanner stuff = scanner;

        System.out.println("\nPlease Enter your choice :)");
        System.out.println("1. Manage faculties");
        System.out.println("2. Manage departments");
        System.out.println("3. Manage courses");
        System.out.println("4. Manage students");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) // "1. Manage faculties"
        {
            manageFaculty.execute(stuff);
        }

        else if (choice == 2) // "2. Manage departments"
        {
            manageDepartment.execute(stuff);
        }

        else if (choice == 3) // "3. Manage courses"
        {
            manageCourses.execute(stuff);
        }

        else if (choice == 4) // "4. Manage students"
        {
            manageStudents.execute(stuff);
        }

        return choice;
    }
}
