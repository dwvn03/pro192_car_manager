package brand;

import java.util.Scanner;
import java.util.ArrayList; 
import java.util.StringTokenizer;

import my_lib.file_io.FileUtils;
import main.Menu;

public class BrandList extends ArrayList<Brand> {
    static Scanner sc = new Scanner(System.in);
    static Menu<Brand> menu = new Menu<>();

    public boolean loadFromFile(String path) {
        String[] lines = FileUtils.readFileAsLinesArray(path);

        if (lines == null) {
            return false;
        }

        for (String line : lines) {
            StringTokenizer stk = new StringTokenizer(line, ",:");

            String ID = stk.nextElement().toString().trim();
            String brandName = stk.nextElement().toString().trim();
            String soundBrand = stk.nextElement().toString().trim();
            double price = Double.parseDouble(stk.nextElement().toString());

            Brand brand = new Brand(ID, brandName, soundBrand, price);
            this.add(brand);
        }

        return true;
    }

    public boolean saveToFile(String path) {
        return FileUtils.writeArrayToFile(path, this.toArray());
    }

    public void listBrand() {
        if (this.size() == 0) {
            System.out.println("The list is empty");
        } else {
            for (Brand brand : this) {
                System.out.println(brand);
            }
        }
    }

    public Brand getUserChoice() {
        return menu.ref_getChoice(this);
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
        String ID = null;
        String brandName = null;
        String soundBrand = null;
        double price = 0;
        while (true) {
            System.out.print("Enter ID: ");
            ID = sc.nextLine();
            if (searchID(ID) == -1) {
                break;
            }
            System.out.println("ID already exist, please enter again !!!");
        }
        while (true) {
            System.out.print("Enter brand name: ");
            brandName = sc.nextLine();
            String name = brandName.trim();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Brand name can't be blank, please enter again!!!");
            }
        }
        while (true) {
            System.out.print("Enter sound brand: ");
            soundBrand = sc.nextLine();
            String sound = soundBrand.trim();
            if (!sound.isEmpty()) {
                break;
            } else {
                System.out.println("Sound brand can't be blank, please enter again!!!");
            }
        }
        while (true) {
            System.out.print("Enter price: ");
            price = sc.nextDouble();
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
        String newID = null;
        String newBrandName = null;
        String newSoundBrand = null;
        double newPrice = 0;
        String ID = null;
        System.out.print("Enter ID: ");
        ID = sc.nextLine();
        if (searchID(ID) == -1) {
            System.out.println("Not found!");
        } else {
            Brand BrandsUpdate = this.get(searchID(ID));
            while (true) {
                System.out.print("Enter new ID: ");
                newID = sc.nextLine();
                if (searchID(newID) == -1) {
                    break;
                }
                System.out.println("ID already exist, please enter again !!!");
            }
            while (true) {
                System.out.print("Enter new brand name: ");
                newBrandName = sc.nextLine();
                String name = newBrandName.trim();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Brand name can't be blank, please enter again!!!");
                }
            }
            while (true) {
                System.out.print("Enter new sound brand: ");
                newSoundBrand = sc.nextLine();
                String sound = newSoundBrand.trim();
                if (!sound.isEmpty()) {
                    break;
                } else {
                    System.out.println("Sound brand can't be blank, please enter again!!!");
                }
            }
            while (true) {
                System.out.print("Enter new price: ");
                newPrice = sc.nextDouble();
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
        System.out.print("Enter ID: ");
        String ID = sc.nextLine();
        if (searchID(ID) == -1) {
            System.out.println("Not found!");
        } else {
            System.out.print("Result: ");
            System.out.println(this.get(searchID(ID)));
        }
    }
}
