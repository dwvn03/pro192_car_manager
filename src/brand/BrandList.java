package brand;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.List; 

import my_lib.file_io.FileUtils;

public class BrandList extends ArrayList<Brand> {

    final boolean OVERWRITE = false;
    final boolean APPEND = true;

    public boolean loadFromFile(String path) {
        List<String> lines = FileUtils.readFileAsLinesList(path);

        if (lines == null) {
            return false;
        }

        for (String line : lines) {
            StringTokenizer stk = new StringTokenizer(line, ",:");
            String ID = stk.nextElement().toString();
            String brandName = stk.nextElement().toString();
            String soundBrand = stk.nextElement().toString();
            double price = Double.parseDouble(stk.nextElement().toString());
            Brand brand = new Brand(ID, brandName, soundBrand, price);
            this.add(brand);
        }

        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            File f = new File(filename);
            boolean writeMode = OVERWRITE;
            FileWriter fw = new FileWriter(f, writeMode);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand brand : this) {
                pw.println(brand);
            }
            pw.close();
            fw.close();
            System.out.println("Add brand to " + filename + " success.");
            return true;
        } catch (Exception e) {
            System.err.println("Cannot write to file " + filename + "!");
            System.err.println("Error reason: " + e.getMessage());
            return false;
        }
    }

    public void listBrand() {
        for (Brand brand : this) {
            System.out.println(brand);
        }
        System.out.println("\n\n");

        System.out.println("Press enter to continue");
        
    }

    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (ID.equals(this.get(i).ID)) {
                return i;
            }
        }
        return -1;
    }

    public void addBrand() {
        BrandList brandlist = new BrandList();
        brandlist.loadFromFile("brands.txt");
        Scanner scString = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        String ID = null;
        String brandName = null;
        String soundBrand = null;
        double price = 0;
        while (true) {
            System.out.print("Enter ID: ");
            ID = scString.nextLine();
            if (searchID(ID) == -1) {
                break;
            }
            System.out.println("ID already exist, please enter again !!!");
        }
        while (true) {
            System.out.print("Enter brand name: ");
            brandName = scString.nextLine();
            String name = brandName.trim();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Brand name can't be blank, please enter again!!!");
            }
        }
        while (true) {
            System.out.print("Enter sound brand: ");
            soundBrand = scString.nextLine();
            String sound = soundBrand.trim();
            if (!sound.isEmpty()) {
                break;
            } else {
                System.out.println("Sound brand can't be blank, please enter again!!!");
            }
        }
        while (true) {
            System.out.print("Enter price: ");
            price = scDouble.nextDouble();
            if (price >= 0) {
                break;
            } else {
                System.out.println("The price must be a positive real number");
            }
        }
        Brand t = new Brand(ID, brandName, soundBrand, price);
        this.add(t);
    }

    public void updateBrand() {
        Scanner scString = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        String newID = null;
        String newBrandName = null;
        String newSoundBrand = null;
        double newPrice = 0;
        String ID = null;
        System.out.print("Enter ID: ");
        ID = scString.nextLine();
        if (searchID(ID) == -1) {
            System.out.println("Not found!");
        } else {
            Brand BrandsUpdate = this.get(searchID(ID));
            while (true) {
                System.out.print("Enter new ID: ");
                newID = scString.nextLine();
                if (searchID(newID) == -1) {
                    break;
                }
                System.out.println("ID already exist, please enter again !!!");
            }
            while (true) {
                System.out.print("Enter new brand name: ");
                newBrandName = scString.nextLine();
                String name = newBrandName.trim();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Brand name can't be blank, please enter again!!!");
                }
            }
            while (true) {
                System.out.print("Enter new sound brand: ");
                newSoundBrand = scString.nextLine();
                String sound = newSoundBrand.trim();
                if (!sound.isEmpty()) {
                    break;
                } else {
                    System.out.println("Sound brand can't be blank, please enter again!!!");
                }
            }
            while (true) {
                System.out.print("Enter new price: ");
                newPrice = scDouble.nextDouble();
                if (newPrice >= 0) {
                    break;
                } else {
                    System.out.println("The price must be a positive real number");
                }
            }
            BrandsUpdate.setID(newID);
            BrandsUpdate.setBrandName(newBrandName);
            BrandsUpdate.setSoundBrand(newSoundBrand);
            BrandsUpdate.setPrice(newPrice);
        }
    }

    public void searchBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String ID = sc.nextLine();
        if (searchID(ID) == -1) {
            System.out.println("Not found!");
        } else {
            System.out.print("Result: ");
            System.out.println(this.get(searchID(ID)));
        }
    }
//    public Brand getUserChoice();
}
