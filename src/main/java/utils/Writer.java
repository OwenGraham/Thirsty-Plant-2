package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void write(String file,String record){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
