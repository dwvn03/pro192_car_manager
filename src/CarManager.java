
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
        Menu.int_getChoice(options);
    }
}
