import java.util.Scanner;

public class updateStudent
{
    static public void execute(Scanner scanner)
    {
        System.out.println("Enter student ID: ");
        String ID = scanner.next();

        if (Student.checkExist(ID))
        {
            Student stu = Student.getStudent(ID);
            String newName = stu.getName();
            Double newGPA = stu.getGPA();
            Department newDepartment = stu.getDepartment();
            Faculty newfaculty = stu.getFaculty();

            System.out.println("Would u like to edit Student name? (y/n): ");
            String ans = scanner.next();
            newName = ans.equals(("y")) ? scanner.next() : newName;

            System.out.println("Would u like to edit Student GPA? (y/n): ");
            ans = scanner.next();
            newGPA = ans.equals(("y")) ? scanner.nextDouble() : newGPA;

            System.out.println("Would u like to edit Student Faculty? (y/n): ");
            ans = scanner.next();
            newDepartment = ans.equals(("y")) ? new Department(scanner.next()) : newDepartment;

            System.out.println("Would u like to edit Student Department? (y/n): ");
            ans = scanner.next();
            newfaculty = ans.equals(("y")) ? new Faculty(scanner.nextLine()) : newfaculty;

            stu.updateDetails(newName, newGPA, newDepartment, newfaculty);
        }
    }
}
