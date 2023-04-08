import java.util.Scanner;

public class manageFaculty
{
    static public void execute(Scanner scanner)
    {
        System.out.println("\nFACULTIES");
        System.out.println("1. Add faculty");
        System.out.println("2. List faculties");
        
        int facultyChoice = scanner.nextInt();
        scanner.nextLine();

        if (facultyChoice == 1)
        {
            System.out.print("Enter faculty name: ");
            String facultyName = scanner.nextLine();
            Faculty.addFaculty(facultyName);
        }

        else if (facultyChoice == 2)
        {
            Faculty.listAllFaculties();
        }
    }
}
