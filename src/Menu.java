
import java.util.ArrayList;
import java.util.List;

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

    static BrandList brandlist;

    static int int_getChoice(ArrayList<String> options) {
        int index = 0;

        for (String option : options) {
            System.out.printf("%2d - %s\n", index + 1, option);
            index++;
        }
        int choice = MyLibs.getInt("Enter your choice: ", "Invalid choice.", 1, 11, null);
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
        return 1;
    }
}
