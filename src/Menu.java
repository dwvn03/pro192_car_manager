import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import brand.Brand;
import brand.BrandList;
import car.CarList;

import input.IntInput;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Menu {
    // static Scanner sc = new Scanner(System.in);

    static int int_getChoice(ArrayList<String> options) {
        int index = 0;
        int n = options.size();

        for (String option : options) {
            System.out.printf("%2d - %s\n", index + 1, option);
            index++;
        }

        return IntInput.inputInt(
            String.format("\nPlease choose an option 1..%d", n),
            n
        );
    }

    


    // Brand brand_getChoice(ArrayList<Brand> options) {
    //     int index = 0;

    //     for (String option : options) {
    //         System.out.printf("%2d - %s", index, option);
    //         index++;
    //     }

    //     return IntInput.inputInt(
    //         String.format("\nPlease choose an option 1..%d : " + options.size())
    //     );
    // }

    // public void menu() {
    //     BrandList brandlist = new BrandList();
    //     // CarList carList = new CarList();

    //     while (true) {
    //         System.out.println("========= Minh Trang BMW =========");
    //         System.out.println(""
    //                 + "1- List all brands\n"
    //                 + "2- Add a new brand\n"
    //                 + "3- Search a brand based on its ID\n"
    //                 + "4- Update a brand\n"
    //                 + "5- Save brands to the file, named brands.txt\n"
    //                 + "6- List all cars in ascending order of brand names\n"
    //                 + "7- List cars based on a part of an input brand name\n"
    //                 + "8- Add a car\n"
    //                 + "9- Remove a car based on its ID\n"
    //                 + "10- Update a car based on its ID\n"
    //                 + "11- Save cars to file, named cars.txt\n\n");
    //         int choice = MyLibs.getInt("Enter your choice: ", "Invalid choice.", 1, 11, null);
    //         switch (choice) {
    //             case 1:
    //                 brandlist.loadFromFile("brands.txt");
    //                 brandlist.listBrand();
    //                 break;
    //             case 2:
    //                 brandlist.addBrand();
    //                 break;
    //             case 3:
    //                 brandlist.searchBrand();
    //                 break;
    //             case 4:
    //                 brandlist.updateBrand();
    //                 break;
    //             case 5:
    //                 brandlist.saveToFile("brands.txt");
    //                 break;
    //             case 6:

    //                 break;
    //             case 7:

    //                 break;
    //             case 8:

    //                 break;
    //             case 9:

    //                 break;
    //             case 10:

    //                 break;
    //             case 11:

    //                 break;
    //         }
    //     }
    // }
}
