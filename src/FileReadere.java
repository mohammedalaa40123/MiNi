import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javafx.util.Pair;

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


    static public HashMap<String, Integer> fileToHashMap1(String filePath) {
        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String key = data[0];
                Integer value = Integer.parseInt(data[3]);

                map.put(key, value);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return map;
    }    static public HashMap<String, Pair<String, Integer>> fileToHashMap2(String filePath) {
        HashMap<String, Pair<String, Integer>> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String key = data[0];
                String code = data[1];
                Integer credits = Integer.parseInt(data[2]);
                Pair<String, Integer> temp = new Pair<String, Integer>(code, credits);

                map.put(key, temp);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return map;
    }
}