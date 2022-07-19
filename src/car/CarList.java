package car;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
import java.util.*;
import java.io.*;

import brand.*;

/**
 *
 * @author admin
 */
public class CarList extends ArrayList<Car> {
    BrandList brandList;


    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }


    // public boolean loadFromFile(String filename) {
    //     try {
    //         File f = new File(filename);
    //         if (!f.exists()) {
    //             System.err.println("File " + filename + " does not exist.");
    //             return false;
    //         }
    //         FileReader fr = new FileReader(f);
    //         BufferedReader br = new BufferedReader(fr);
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             StringTokenizer stk = new StringTokenizer(line, ",:");
    //             String ID = stk.nextElement().toString();
    //             String brandName = stk.nextElement().toString();
    //             String soundBrand = stk.nextElement().toString();
    //             double price = Double.parseDouble(stk.nextElement().toString());
    //             Brand brand = new Brand(ID, brandName, soundBrand, price);
    //             this.add(brand);
    //         }
    //         return true;
    //     } catch (Exception e) {
    //         System.err.println("Cannot read from file " + filename + "!");
    //         System.err.println("Error reason: " + e.getMessage());
    //         return false;
    //     }
    // }
}
