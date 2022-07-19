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

public boolean loadFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.err.println("File " + filename + " does not exist.");
                return false;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                String carID = stk.nextElement().toString();
                String brandID = stk.nextElement().toString();
                int pos = brandList.searchID(brandID);
                Brand b = brandList.get(pos);
                String colour = stk.nextElement().toString();
                String frameID = stk.nextElement().toString();
                String engineID = stk.nextElement().toString();
                Car car = new Car(carID, b, colour, frameID, engineID);
                this.add(car);
            }
            return true;
        } catch (Exception e) {
            System.err.println("Cannot read from file " + filename + "!");
            System.err.println("Error reason: " + e.getMessage());
            return false;
        }
    }

    public void listCars() {

//        Collections.sort(this.);
        for (Car car : this) {
            System.out.println(car);
        }
        System.out.println("\n\n");
    }

    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (carID.equals(this.get(i).carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (fID.equals(this.get(i).frameID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (eID.equals(this.get(i).engineID)) {
                return i;
            }
        }
        return -1;
    }

    public void addCar() {
        CarList carlist = new CarList(brandList);
        carlist.loadFromFile("cars.txt");
        Scanner sc = new Scanner(System.in);
        String carID = null;
        String brandID = null;
        String colour = null;
        String frameID = null;
        String engineID = null;
        while (true) {
            System.out.print("Enter car ID: ");
            carID = sc.nextLine();
            if (searchID(carID) == -1) {
                break;
            }
            System.out.println("Car ID already exist, please enter again !!!");
        }
// đoạn này chỉ cần lắp menu.e ref_getChoice là xong
//
//
//
//
//
//
//
//
//
//
//
        while (true) {
            System.out.print("Enter colour: ");
            colour = sc.nextLine();
            String c = colour.trim();
            if (!c.isEmpty()) {
                break;
            } else {
                System.out.println("Colour brand can't be blank, please enter again!!!");
            }
        }
        while (true) {
            System.out.print("Enter frame ID: ");
            frameID = sc.nextLine();
            char c1 = frameID.charAt(0);
            int count = 0;
            for (int i = 0; i < frameID.length(); i++) {
                char c2 = frameID.charAt(i);
                if ((c2 < 48) || (c2 > 57)) {
                    count++;
                }
            }
            if ((c1 == 'F') && (count == 0) && (frameID.length() == 5)) {
                if (searchFrame(frameID) == -1) {
                    break;
                } else {
                    System.out.println("Frame ID already exist, please enter again !!!");
                }
            }
        }

        while (true) {
            System.out.print("Enter engine ID: ");
            engineID = sc.nextLine();
            char c1 = engineID.charAt(0);
            int count = 0;
            for (int i = 0; i < engineID.length(); i++) {
                char c2 = engineID.charAt(i);
                if ((c2 < 48) || (c2 > 57)) {
                    count++;
                }
            }
            if ((c1 == 'E') && (count == 0) && (engineID.length() == 5)) {
                if (searchEngine(engineID) == -1) {
                    break;
                } else {
                    System.out.println("Engine ID already exist, please enter again !!!");
                }
            }
        }
//        Brand t = new Brand(ID, brandName, soundBrand, price);
//        this.add(t);
//        for (Brand brand : this) {
//            System.out.println(brand);
//        }
    }
}
