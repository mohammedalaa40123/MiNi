import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileReadere {
    static public HashSet<String> readFaculties(String filename) {
        HashSet<String> faculties = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                faculties.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faculties;
    }
}