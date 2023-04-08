import java.util.Scanner;

public class updateCourse
{
    static public void execute(String coursename, Scanner scanner)
    {
        System.out.println("Would u like to edit course name? (y/n): ");
        String ans = scanner.nextLine();
        String newCode = Course.getcourseInfo(coursename).getKey();
        Integer Newnofcredits = Course.getcourseInfo(coursename).getValue();
        String newName = coursename;

        if (ans.equals("y")) // edit 3
        {
            System.out.println("Enter new course name");
            newName = scanner.nextLine();
            System.out.println("Would u like to edit course code? (y/n): ");
            ans = scanner.nextLine();

            if (ans.equals("y"))
            {
                System.out.println("Enter new course code");
                newCode = scanner.nextLine();
            }

            System.out.println("Would u like to edit course number of credits? (y/n): ");
            ans = scanner.nextLine();

            if (ans.equals("y"))
            {
                System.out.println("Enter new course number of credits");
                Newnofcredits = scanner.nextInt();
            }

            Course.updateCourse(coursename, newName, newCode, Newnofcredits);

            return;
        }

        System.out.println("Would u like to edit course code? (y/n): ");
        ans = scanner.nextLine();

        if (ans.equals("y"))
        {
            System.out.println("Enter new course code:");
            newCode = scanner.nextLine();
            System.out.println("Would u like to edit course number of credits? (y/n): ");
            ans = scanner.nextLine();

            if (ans.equals("y"))
            {
                System.out.println("Enter new course number of credits");
                Newnofcredits = scanner.nextInt();
                Course.updateCourse(coursename, coursename, newCode, Newnofcredits);
            }

            else
            {
                Course.updateCourse(coursename, newCode);
            }

            return;
        }

        System.out.println("Would u like to edit course number of credits? (y/n): ");
        ans = scanner.nextLine();

        if (ans.equals("y"))
        {
            System.out.println("Enter new course number of credits");
            Newnofcredits = scanner.nextInt();
        }

        Course.updateCourse(coursename, Newnofcredits);
    }
}