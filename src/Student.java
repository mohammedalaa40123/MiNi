import java.util.HashMap;
import java.util.HashSet;

public class Student
{
    static private HashMap<String, Student> students = new HashMap<>();

    private String name;
    private String ID;
    private Department department;
    private Faculty faculty;
    private Double GPA;
    private HashSet<Course> courses = new HashSet<>();

    public Student(String name, String ID, Department department, Faculty faculty, Double GPA)
    {
        this.name = name;
        this.ID = ID;
        this.department = department;
        this.faculty = faculty;
        this.GPA = GPA;

        students.put(ID, this);
    }

    public String getName()
    {
        return name;
    }

    public Department getDepartment()
    {
        return department;
    }

    public Faculty getFaculty()
    {
        return faculty;
    }

    public Double getGPA()
    {
        return GPA;
    }

    static public Student getStudent(String ID)
    {
        return students.get(ID);
    }

    public void addCourse(Course x)
    {
        Course.enrollCourse(x.getName());
        this.courses.add(x);
        students.put(ID, this); // automatically changes ID that already exists in hashmap
        System.out.println("Course added successfully :)");
    }

    public void dropCourse(Course x)
    {
        for (Course i : courses)
        {
            if (i.getName().equals(x.getName()))
            {
                courses.remove(i);
                break;
            }
        }

        Course.dropCourse(x.getName());
        students.put(ID, this); // to change again (e7teyati)
        System.out.println("Course dropped successfully :)");
    }

    static public boolean checkExist(String ID)
    {
        return students.containsKey(ID);
    }

    static public void listAllStudents()
    {
        if (students.isEmpty())
        {
            System.out.println("No students available");
            return;
        }
        
        System.out.println("Students Details: ");
        System.out.println("-------------------------------");

        for (HashMap.Entry<String, Student> student : students.entrySet())
        {

            String key = student.getKey();
            Student value = student.getValue();

            System.out.print("ID: " + key + " - " + " Name: " + value.name);
            System.out.print(" - " + " Faculty: " + value.faculty.getFaculty());
            System.out.print(" - " + " Department: " + value.department.getDepartment());
            System.out.println(" - " + " GPA: " + value.GPA);

        }
    }

    public void updateDetails(String name, Double GPA, Department department, Faculty faculty)
    {
        this.name = name;
        this.GPA = GPA;
        this.department = department;
        this.faculty = faculty;
        System.out.println("Student Details Updated :)");
    }

    static public void deleteStudent(Student x)
    {
        for (Course i : x.courses)
        {
            Course.dropCourse(i.getName());
        }

        if (checkExist(x.ID))
        {
            students.remove(x.ID);
        }
    }

    static public void listcourses(String ID)
    {
        if (checkExist((ID)))
        {
            Student x = students.get(ID);

            for (Course i : x.courses)
            {
                System.out.println("- " + i.getName());
            }
        }
    }
}

// Add a new student (name, ID, department, courses, marks for each
// course, GPA, grade).
// b. List the required information for all students.
// c. Keep track of the total number of students enrolled in each course.
// d. Update student details.
// e. Delete a student

// Add, update, list (including the total number of students enrolled in each
// course), delete students.