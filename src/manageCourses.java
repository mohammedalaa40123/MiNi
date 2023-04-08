import java.util.Scanner;

public class manageCourses
{
    static public void execute(Scanner scanner)
    {
        System.out.println("\nCOURSES");
        System.out.println("1. Add course");
        System.out.println("2. Update course");
        System.out.println("3. Delete course");
        System.out.println("4. List courses");
        System.out.println("5. Get total enrollment");

        int courseChoice = scanner.nextInt();
        scanner.nextLine(); // consume the \n character

        if (courseChoice == 1) // "1. Add course"
        {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter Course Code: ");
            String coursecode = scanner.nextLine();
            System.out.print("Enter Course number of credits: ");
            int nofcredits = scanner.nextInt();
            Course.addCourse(courseName, coursecode, nofcredits);
        }

        else if (courseChoice == 2) // "2. Update course"
        {
            System.out.print("Enter course name: ");
            String coursename = scanner.nextLine();

            if (!Course.checkExist(coursename))
            {
                return;
            }

            updateCourse.execute(coursename, scanner);
        }

        else if (courseChoice == 3) // "3. Delete course"
        {
            System.out.print("Enter course name: ");
            String coursename = scanner.nextLine();
            Course.deleteCourse(coursename);
        }

        else if (courseChoice == 4) // "4. List courses"
        {
            Course.listAllCourses();
        }

        else if (courseChoice == 5) // "5. Get total enrollment"
        {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            Integer nofstudents = Course.getNumberOfStudents(courseName);
            System.out.println("Number of Students enrolled in the course " + courseName + " is: " + nofstudents);
        }
    }
}
