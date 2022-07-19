import java.util.ArrayList;
import java.util.Arrays;

import brand.BrandList;
// import car.CarList;

public class CarManager  {
    public static void main(String[] args) {
        BrandList brandlist = new BrandList();
        // CarList carList = new CarList();

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
            "Save cars to file, named cars.txt"
        ));



        while (true) {
            System.out.println("========= Minh Trang BMW =========");

            int choice = Menu.int_getChoice(options);
            switch (choice) {
                case 1:
                    brandlist.loadFromFile("brands.txt");
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

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
            }
        }
    }
}
