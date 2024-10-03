package utils;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> readLines(String file){
        ArrayList<String> lines = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            File newFile = new File(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
