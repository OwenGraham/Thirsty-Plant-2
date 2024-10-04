package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void write(String file, String record) {
        try {
            // Create a File object for the specified file path
            File f = new File(file);

            // Create the parent directories if they do not exist
            File parentDir = f.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Creates the directory and any necessary but nonexistent parent directories
            }

            // Create a BufferedWriter in append mode
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, true))) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

