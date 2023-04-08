package Uni;

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

        studentsEnrolled.put(name, studentsEnrolled.get(name) + 1);
    }

    public String getName() {
        if (courses.containsKey(courseName)) {
            return courseName;
        }

        else {
            return "(deleted)";
        }
    }

    public String getCourseCode() {
        if (courses.containsKey(courseName)) {
            return courseCode;
        }

        else {
            return "(deleted)";
        }
    }

    public Integer getNoCredits() {
        if (courses.containsKey(courseName)) {
            return noCredits;
        }

        else {
            return 0;
        }
    }

    static public void listAllCourses() {
        if(courses.isEmpty()){System.out.println("No courses listed yet");return;}
        for (HashMap.Entry<String, Pair<String, Integer>> i : courses.entrySet()) {
            System.out.println("\nCourses are: (Name - course code - credit hours - students enrolled)");
            System.out.print(i.getKey() + " - ");
            System.out.print(i.getValue().getKey() + " - ");
            System.out.print(i.getValue().getValue() + " hrs - ");
            System.out.println(studentsEnrolled.get(i.getKey()) + " students");
        }
    }

    static public void addCourse(String name, String code, Integer credits) {
        Pair<String, Integer> temp = new Pair<String, Integer>(code, credits);
        courses.put(name, temp);
        studentsEnrolled.put(name, 0);
    }

    static public boolean checkExist(String name) {
        return courses.containsKey(name);
    }

    public static Pair<String, Integer> getcourseInfo(String name) {
        String courseCode = courses.get(name).getKey();
        Integer noCredits = courses.get(name).getValue();
        return new Pair<String, Integer>(courseCode, noCredits);
        // checks if exist before getting course info inside the main
    }

    // Applying Polymorphism

    static public void updateCourse(String name, String code) {
        Integer credits = courses.get(name).getValue();
        addCourse(name, code, credits);
    } // updates only code

    static public void updateCourse(String name, Integer credits) {
        String code = courses.get(name).getKey();
        addCourse(name, code, credits);
    } // updates only number of credits

    static public void updateCourse(String name, String Newname, String code, Integer credits) {
        deleteCourse(name);
        addCourse(Newname, code, credits);

        studentsEnrolled.put(Newname, studentsEnrolled.get(name));
        studentsEnrolled.remove(name);

    } // updates all three or just name

    static public void deleteCourse(String x) {
        if (!courses.containsKey(x)) {
            System.out.println("Course does not exist");
            return;
        }

        else {
            courses.remove(x);
            studentsEnrolled.remove(x);
        }
    }
}