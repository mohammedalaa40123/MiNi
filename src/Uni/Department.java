package Uni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {
    private static Map<String, List<String>> departments = new HashMap<>();

    public List<String> getDepartment(String department) {
        return departments.getOrDefault(department, new ArrayList<>());
    }

    public static void addDepartment(String facultyName, String departmentName) {
        List<String> departmentList = Faculty.getFaculty(facultyName);
        departmentList.add(departmentName);
        departments.put(facultyName, departmentList);
        System.out.println("Added department: " + departmentName + " to faculty: " + facultyName);
    }

    public static void deleteDepartment(String facultyName, String departmentName) {
        List<String> departmentList = departments.get(facultyName);
        if (departmentList != null) {
            departmentList.remove(departmentName);
            System.out.println("Deleted department: " + departmentName + " from faculty: " + facultyName);
        }
    }

    static public List<String> listAllDepartments(String facultyName) {
        List<String> departmentList = departments.getOrDefault(facultyName, new ArrayList<>());
        System.out.println("List of departments in faculty: " + facultyName + " : ");
        for (String i : departmentList)
        {
            System.out.println("- " + i);
        }
        
        return departmentList;
    }
}