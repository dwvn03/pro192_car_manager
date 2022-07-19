
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class CarManager {

    public static void main(String[] args) {

        BrandList brandlist = new BrandList();
        CarList carlist = new CarList(brandlist);
        brandlist.loadFromFile("brands.txt");
        carlist.loadFromFile("cars.txt");
        while (true) {
            System.out.println("==========================Menu==========================");
            ArrayList<String> ops = new ArrayList<>(Arrays.asList(
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
                    "Save cars to file, named cars.txt"
            ));
            System.out.println("");
            Menu.int_getChoice(ops);
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
            }
        }
    }
}
