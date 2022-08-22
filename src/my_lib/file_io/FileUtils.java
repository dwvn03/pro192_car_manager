package my_lib.file_io;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileUtils {
    static final boolean OVERWRITE = false;
    static final boolean APPEND = true;

    public static String[] readFileAsLinesArray(String path) {
        try {
            File f = new File(path);

            if (!f.exists()) {
                System.err.println(path + " does not exist.");
                return null;
            }

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();
            fr.close();

            return lines.toArray(new String[0]);
        } catch (IOException e) {
            System.err.println("Cannot read from " + path + "!");
            System.err.println("Error reason: " + e.getMessage());
            return null;
        }
    }

    public static boolean writeArrayToFile(String path, Object[] list) {
        try {
            File f = new File(path);
            boolean writeMode = OVERWRITE;
            FileWriter fw = new FileWriter(f, writeMode);
            PrintWriter pw = new PrintWriter(fw);

            for (Object object : list) {
                pw.println(object);
            }

            pw.close();
            fw.close();
            System.out.println("Saved to " + path + " successful");
            return true;
        } catch (IOException e) {
            System.err.println("Cannot write to " + path + "!");
            System.err.println("Error reason: " + e.getMessage());
            return false;
        }
    }
}
