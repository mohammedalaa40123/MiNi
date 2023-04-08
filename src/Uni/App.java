package Uni;

import java.util.Scanner;

public class App {
   public static void main(String[] args) {
      String Eui = " _       _       _                                   _             ___   _   _ _     _ \n" +
            "( )  _  ( )     (_ )                                ( )_          (  _`\\( ) ( (_)   ( )\n" +
            "| | ( ) | |  __  | |   ___   _    ___ ___    __     | ,_)  _      | (_(_| | | | |   | |\n" +
            "| | | | | |/'__`\\| | /'___)/'_`\\/' _ ` _ `\\/'__`\\   | |  /'_`\\    |  _)_| | | | |   | |\n" +
            "| (_/ \\_) (  ___/| |( (___( (_) | ( ) ( ) (  ___/   | |_( (_) )   | (_( | (_) | |   | |\n" +
            "`\\___x___/`\\____(___`\\____`\\___/(_) (_) (_`\\____)   `\\__`\\___/'   (____/(_____(_)   (_)\n" +
            "                                                                                    (_)\n";
      System.out.println(Eui);
      Scanner scanner = new Scanner(System.in);

      while (true) {

         System.out.println("Enter your choice:");
         System.out.println("1. Manage faculties");
         System.out.println("2. Manage departments");
         System.out.println("3. Manage courses");
         System.out.println("4. Manage students");
         System.out.println("5. Exit");

         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {

            case 1: // "1. Manage faculties"
               System.out.println("\nFACULTIES");
               System.out.println("1. Add faculty");
               System.out.println("2. List faculties");
               int facultyChoice = scanner.nextInt();
               scanner.nextLine();

               switch (facultyChoice) {
                  case 1:
                     System.out.print("Enter faculty name: ");
                     String facultyName = scanner.nextLine();
                     Faculty.addFaculty(facultyName);
                     break;
                  case 2:
                     Faculty.listAllFaculties();
                     break;
                  default:
                     System.out.println("Invalid choice!");
               }
               break;

            case 2: // "2. Manage departments"
               System.out.println("\nDEPARTMENTS");
               System.out.println("1. Add department");
               System.out.println("2. Delete department");
               System.out.println("3. List departments");

               int departmentChoice = scanner.nextInt();
               scanner.nextLine();

               switch (departmentChoice) {

                  case 1:
                     System.out.print("Enter department name: ");
                     String departmentName = scanner.nextLine();
                     Department.addDepartment(departmentName);
                     break;
                  case 2:
                     System.out.print("Enter department name: ");
                     departmentName = scanner.nextLine();
                     Department.deleteDepartment(departmentName);
                     break;
                  case 3:
                     Department.listAllDepartments();
                     break;
                  default:
                     System.out.println("Invalid choice!");
               }
               break;

               
            case 3: // "3. Manage courses"
               System.out.println("\nCOURSES");
               System.out.println("1. Add course");
               System.out.println("2. Update course");
               System.out.println("3. Delete course");
               System.out.println("4. List courses");
               System.out.println("5. Get total enrollment");
               
               int courseChoice = scanner.nextInt();
               scanner.nextLine(); // consume the \n character

               switch (courseChoice) {
                  
                  case 1: // "1. Add course"
                     
                     System.out.print("Enter course name: ");
                     String courseName = scanner.nextLine();
                     System.out.print("Enter Course Code: ");
                     String coursecode = scanner.nextLine();
                     System.out.print("Enter Course number of credits:: ");
                     int nofcredits = scanner.nextInt();
                     Course.addCourse(courseName,coursecode, nofcredits);
                     break;

                  case 2: //  "2. Update course"
                     // masa7t el code
                     break;
                     
                  case 3: //  "3. Delete course"
                     System.out.print("Enter course name: ");
                     courseName = scanner.nextLine();
                     Course.deleteCourse(courseName);
                     break;
                  case 4: //  "4. List courses"
                     Course.listAllCourses();
                     break;
                  case 5: //  "5. Get total enrollment"
                     System.out.print("Enter course name: ");
                     courseName = scanner.nextLine();
                     // int totalEnrollment = getTotalEnrollment(departmentName, courseName);
                     // System.out.println("Total enrollment: " + totalEnrollment);
                     break;

                  default:
                     System.out.println("Invalid choice!");
               }
               
               break;
         }
         scanner.close();
      }

   }
}

// You have to provide an interface for the user to:
// o Add and list faculties.
// o Add, delete, and list departments.
// o Add, update, list, and delete courses.
// o Add, update, list (including the total number of students enrolled in each
// course), delete students