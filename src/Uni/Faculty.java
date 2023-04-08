package Uni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty {
    private static Map<String, List<String>> faculties = new HashMap<>();

    static public List<String> getFaculty(String facultyname) {
        return faculties.getOrDefault(facultyname, new ArrayList<>());    }

    static public void addFaculty(String facultyname) {
        faculties.put(facultyname, new ArrayList<>());
        System.out.println("Added faculty: " + facultyname);
    }

    static public List<String> listAllFaculties() {
        List<String> facultyList = new ArrayList<>(faculties.keySet());
        System.out.println("List of faculties: " );
        for (String i : facultyList)
        {
            System.out.println("- " + i);
        }
        return facultyList;
    }
}