import java.util.Scanner;

public class manageStudents
{
    static public void execute(Scanner scanner)
    {
        System.out.println("\nSTUDENTS");
        System.out.println("1. List all students");
        System.out.println("2. Add student");
        System.out.println("3. Update student Details");
        System.out.println("4. Delete student");
        System.out.println("5. List all courses for a student");
        System.out.println("6. Enroll in course");
        System.out.println("7. Drop course");
        
        Integer studentchoice = scanner.nextInt();

        if (studentchoice == 1) // 1. List all students
        {
            Student.listAllStudents();
        }

        else if (studentchoice == 2) // "2. Add student"
        {
            System.out.print("enter student ID u want to add: ");
            String ID = scanner.next();

            if (Student.checkExist(ID))
            {
                System.out.println("student with this ID already exists");
                return;
            }

            System.out.print("please enter student name: ");
            String name = scanner.next();
            System.out.print("please enter student Faculty: ");
            Faculty faculty = new Faculty(scanner.next());
            System.out.print("please enter student department: ");
            Department department = new Department(scanner.next());
            System.out.print("please enter student GPA: ");
            Double GPA = scanner.nextDouble();
            new Student(name, ID, department, faculty, GPA);
            System.out.println("Student added Successfuly :)");
        }

        else if (studentchoice == 3) // "3. Update Student Details"
        {
            updateStudent.execute(scanner);
        }

        else if (studentchoice == 4) // "4. Delete student"
        {
            System.out.println("Enter student ID: ");
            String ID = scanner.next();

            if (Student.checkExist(ID))
            {
                Student.deleteStudent(Student.getStudent(ID));
                return;
            }

            System.out.println("student does not exist");
        }

        else if (studentchoice == 5) // "5. List all courses for a student"
        {
            System.out.println("Enter student ID: ");
            String ID = scanner.next();
            Student.listcourses(ID);
        }

        else if (studentchoice == 6) // "6. Enroll in course"
        {
            System.out.println("Enter student ID: ");
            String ID = scanner.next();

            if (!Student.checkExist(ID))
            {
                System.out.println("Student doesn't exist");
                return;
            }

            Student stu = Student.getStudent(ID);
            System.out.println("Enter the course you want to enrol in");
            String coursename = scanner.next();
            Course course = new Course(coursename);
            stu.addCourse(course);
        }

        else if (studentchoice == 7) // "7. Drop course"
        {
            System.out.println("Enter student ID: ");
            String ID = scanner.next();

            if (!Student.checkExist(ID))
            {
                System.out.println("Student doesn't exist");
                return;
            }

            Student stu = Student.getStudent(ID);
            System.out.print("Enter the course you want to drop in: ");
            String coursename = scanner.next();
            Course course = new Course(coursename);
            stu.dropCourse(course);
        }
    }
}
