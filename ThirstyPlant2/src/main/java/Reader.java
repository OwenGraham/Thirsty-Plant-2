import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
