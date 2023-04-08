import java.io.File;
import java.util.HashMap;
import javafx.util.Pair;

public class Course {
    static private HashMap<String, Pair<String, Integer>> courses = new HashMap<>();
    static private HashMap<String, Integer> studentsEnrolled = new HashMap<>();
    private String courseName;
    private String courseCode;
    private Integer noCredits;

    public Course(String name) {
        if (!courses.containsKey(name)) {
            System.out.println("course does not exist");
            return;
        }

        courseName = name;
        courseCode = courses.get(name).getKey();
        noCredits = courses.get(name).getValue();
    }
    public Course(String name,String code,Integer credits) {
        courseName = name;
        courseCode = code;
        noCredits = credits;
    }

    static public void enrollCourse(String x) {
        if (!courses.containsKey(x)) {
            System.out.println("course does not exist");
        }

        studentsEnrolled.put(x, studentsEnrolled.get(x) + 1);
    }

    static public void dropCourse(String x) {
        if (!courses.containsKey(x)) {
            System.out.println("course does not exist");
            return;
        }

        if (studentsEnrolled.get(x) == 1) {
            studentsEnrolled.remove(x); // 0 means removed
            return;
        }

        studentsEnrolled.put(x, studentsEnrolled.get(x) - 1);
    }

    public static Integer getNumberOfStudents(String coursename) {
        if (!studentsEnrolled.containsKey(coursename)) {
            System.out.println("course does not exist");
            return 0;
        }

        return studentsEnrolled.get(coursename);
    }

    public String getName() {
        if (courses.containsKey(courseName)) {
            return courseName;
        }

        return "(deleted)";
    }

    public String getCourseCode() {
        if (courses.containsKey(courseName)) {
            return courseCode;
        }

        return "(deleted)";
    }

    public Integer getNoCredits() {
        if (courses.containsKey(courseName)) {
            return noCredits;
        }

        return 0;
    }

    static public void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses listed yet");
            return;
        }

        System.out.println("\nCourses are:\n(Name - course code - credit hours - students enrolled)");

        for (HashMap.Entry<String, Pair<String, Integer>> i : courses.entrySet()) {
            System.out.print(i.getKey() + " - ");
            System.out.print(i.getValue().getKey() + " - ");
            System.out.print(i.getValue().getValue() + " hrs - ");
            System.out.println((Integer) studentsEnrolled.get(i.getKey()) + " students");
        }
    }

    static public void addCourse(String coursename, String code, Integer credits) {
        Pair<String, Integer> temp = new Pair<String, Integer>(code, credits);
        courses.put(coursename, temp);
        studentsEnrolled.put(coursename, 0);
    }

    static public void readCourses(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            HashMap<String, Pair<String, Integer>> coursesFromFile = FileReadere.coursesFromFile(filename);
            HashMap<String, Integer> studentsEnrolledfromfile = FileReadere.studentsEnrolledfromfile(filename);
            courses = coursesFromFile;
            studentsEnrolled = studentsEnrolledfromfile;
        } else {
            System.out.println("File " + filename + " doesn't exist.");
            return;
        }
    }

    static public boolean checkExist(String name) {
        return courses.containsKey(name);
    }

    public static Pair<String, Integer> getcourseInfo(String name) {
        String courseCode = courses.get(name).getKey();
        Integer noCredits = courses.get(name).getValue();
        return new Pair<String, Integer>(courseCode, noCredits);

    } // checks if exist before getting course info inside the main

    // Applying Polymorphism

    static public void updateCourse(String name, String code) {
        Integer credits = courses.get(name).getValue();
        addCourse(name, code, credits);
        studentsEnrolled.put(name, studentsEnrolled.get(name));

    } // updates only code

    static public void updateCourse(String name, Integer credits) {
        String code = courses.get(name).getKey();
        addCourse(name, code, credits);
        studentsEnrolled.put(name, studentsEnrolled.get(name));

    } // updates only number of credits

    static public void updateCourse(String name, String Newname, String code, Integer credits) {
        addCourse(Newname, code, credits);

        studentsEnrolled.put(Newname, studentsEnrolled.get(name));
        deleteCourse(name);

    } // updates all three or just name

    static public void deleteCourse(String x) {
        if (!courses.containsKey(x)) {
            System.out.println("Course does not exist");
            return;
        }

        courses.remove(x);
        studentsEnrolled.remove(x);
    }
}