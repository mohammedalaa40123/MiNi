import java.io.File;
import java.util.HashSet;

public class Department
{
    static private HashSet<String> departments = new HashSet<>();
    private String department;

    public Department(String d)
    {
        department = d;
        addDepartment(d);
    }

    public String getDepartment()
    {
        if (departments.contains(department))
        {
            return department;
        }

        else
        {
            return "(deleted)";
        }
    }

    static public void addDepartment(String x)
    {
       
            departments.add(x);
        
    }
    static public void readDepartments(String filename)
    {
        File file = new File(filename);
        if (file.exists()) {
            HashSet<String> facultiesFromFile = FileReadere.readFaculties(filename);
            departments.addAll(facultiesFromFile);
        } else {
            System.out.println("File " + filename + " doesn't exist.");
        }
    }
    static public void deleteDepartment(String d)
    {
        if (!departments.remove(d))
        {
            System.out.println("department does not exist");
        }
    }

    static public void listAllDepartments()
    {
        if (departments.isEmpty())
        {
            System.out.println("No departments listed yet");
            return;
        }
        
        System.out.println("Departments are: ");

        for (String i : departments)
        {
            System.out.println("- " + i);
        }
    }
}