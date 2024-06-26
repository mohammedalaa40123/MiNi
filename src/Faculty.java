import java.io.File;
import java.util.HashSet;

public class Faculty {
    static private HashSet<String> faculties = new HashSet<>();
    private String faculty;

    public Faculty(String x) {
        faculty = x;
        addFaculty(x);
    }

    public String getFaculty() {
        return faculty; // always valid since there is no delete function in this class
    }

    static public void addFaculty(String x) {
        faculties.add(x);
    }

    static public void readFaculties(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            HashSet<String> facultiesFromFile = FileReadere.readFaculties(filename);
            faculties.addAll(facultiesFromFile);
        } else {
            System.out.println("File " + filename + " exists.");
        }
    }

    static public void listAllFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties listed yet");
            return;
        }

        System.out.println("Faculties are: ");

        for (String i : faculties) {
            System.out.println("- " + i);
        }
    }
}