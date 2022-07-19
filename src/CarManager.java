
import java.util.ArrayList;
import java.util.Arrays;

import brand.BrandList;
import car.CarList;
import my_lib.input.IntInput;

public class CarManager {

    public static void main(String[] args) {
        boolean exitProgram = false;

        BrandList brandlist = new BrandList();
        CarList carlist = new CarList(brandlist);
        brandlist.loadFromFile("brands.txt");
        carlist.loadFromFile("cars.txt");

        ArrayList<String> options = new ArrayList<>(Arrays.asList(
                "List all brands",
                "Add a new brand",
                "Search a brand based on its ID",
                "Update a brand",
                "Save brands to the file, named brands.txt",
                "List all cars in ascending order of brand names",
                "List cars based on a part of an input brand name",
                "Add a car",
                "Remove a car based on its ID",
                "Update a car based on its ID",
                "Save cars to file, named cars.txt",
                "Exit"
        ));

        while (!exitProgram) {
            System.out.println("==========================Menu==========================");
            System.out.println("");
            Menu.int_getChoice(options);
            int choice = MyLibs.getInt("Enter your choice: ", "Invalid choice.", 1, 11, null);
            System.out.println("=======================Minh Trang BMW=======================\n");
            switch (choice) {
                case 1:
                    brandlist.listBrand();
                    break;
                case 2:
                    brandlist.addBrand();
                    break;
                case 3:
                    brandlist.searchBrand();
                    break;
                case 4:
                    brandlist.updateBrand();
                    break;
                case 5:
                    brandlist.saveToFile("brands.txt");
                    break;
                case 6:
                    carlist.listCars();
                    break;
                case 7:
                    carlist.printBasedBrandName();
                    break;
                case 8:
                    carlist.addCar();
                    break;
                case 9:
                    carlist.removeCar();
                    break;
                case 10:
                    carlist.updateCar();
                    break;
                case 11:
                    carlist.saveToFile("cars.txt");
                    break;
                case 12:
                    exitProgram = true;
                    break;
            }
        }
    }
}
