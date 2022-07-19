package my_lib.file_io;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class FileUtils {
    public static List<String> readFileAsLinesList(String path) {
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
            return lines;
        } catch (IOException e) {
            System.err.println("Cannot read from " + path + "!");
            System.err.println("Error reason: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        List<String> bla = readFileAsLinesList("brands.txt");

        for (String line : bla) {
            System.out.println("\'" + line + "\'");

            StringTokenizer stk = new StringTokenizer(line, ",: ");
            String ID = stk.nextElement().toString();
            String brandName = stk.nextElement().toString();
            String soundBrand = stk.nextElement().toString();
            double price = Double.parseDouble(stk.nextElement().toString());

            System.out.println(ID);
            System.out.println(brandName);
            System.out.println(soundBrand);
            System.out.println(price);
            // Brand brand = new Brand(ID, brandName, soundBrand, price);
            // this.add(brand);
        }
    }
}
