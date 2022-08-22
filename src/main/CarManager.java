package main;

import java.util.ArrayList;
import java.util.Arrays;

import brand.BrandList;
import car.CarList;
import my_lib.input.Input;

public class CarManager {
    public static void main(String[] args) {
        Menu<String> menu = new Menu<>();

        BrandList brandlist = new BrandList();
        brandlist.loadFromFile("brands.txt");

        CarList carlist = new CarList(brandlist);
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

        while (true) {
            System.out.println("=======================Minh Trang BMW=======================\n");
            System.out.println("============================Menu============================\n");

            int choice = menu.int_getChoice(options);
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
                    System.out.println("Goodbye");
                    System.exit(0);
            }

            System.out.print("\nPress enter to continue ");
            Input.waitForEnter();
        }
    }
}
