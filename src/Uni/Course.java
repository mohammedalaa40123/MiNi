package Uni;
import java.util.HashMap;
import javafx.util.Pair;

public class Course
{
    static private HashMap<String, Pair<String, Integer>> m = new HashMap<>();
    private String courseName;
    private String courseCode;
    private Integer noCredits;

    public Course(String name)
    {
        if (!m.containsKey(name))
        {
            System.out.println("course does not exist");
            return;
        }

        courseName = name;
        courseCode = m.get(name).getKey();
        noCredits = m.get(name).getValue();
    }

    public String getName()
    {
        if (m.containsKey(courseName))
        {
            return courseName;
        }

        else
        {
            return "(deleted)";
        }
    }

    public String getCourseCode()
    {
        if (m.containsKey(courseName))
        {
            return courseCode;
        }

        else
        {
            return "(deleted)";
        }
    }

    public Integer getNoCredits()
    {
        if (m.containsKey(courseName))
        {
            return noCredits;
        }

        else
        {
            return 0;
        }
    }

    static public void listAllCourses()
    {
        for (HashMap.Entry<String, Pair<String, Integer>> i : m.entrySet())
        {
            System.out.println("Courses are: (Name - course code - credit hours)");
            System.out.print(i.getKey() + " - ");
            System.out.print(i.getValue().getKey() + " - ");
            System.out.println(i.getValue().getValue());
        }
    }

    static public void addCourse(String name, String code, Integer credits)
    {
        Pair<String, Integer> temp = new Pair<String, Integer>(code, credits);
        m.put(name, temp);
    }

    static public void updateCourse(String name, String code, Integer credits)
    {
        // check with me first before doing anything in this function
    }

    static public void deleteCourse(String x)
    {
        if (!m.containsKey(x))
        {
            System.out.println("Course does not exist");
            return;
        }

        else
        {
            m.remove(x);
        }
    }
}