package Uni;

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

    static public void addDepartment(String d)
    {
        departments.add(d);
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
        System.out.println("Departments are: ");

        for (String i : departments)
        {
            System.out.println("- " + i);
        }
    }
}