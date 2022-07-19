import java.util.ArrayList;
import java.util.Arrays;

import my_lib.input.IntInput;


public class Menu<E> {
    public static int int_getChoice(ArrayList<String> options) {
        int n = options.size();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d - %s\n", i + 1, options.get(i));
        }

        return IntInput.inputInt(
            String.format("\nPlease choose an option 1..%d", n), 
            n
        );
    }

    public E ref_getChoice(ArrayList<E> options) {
        int n = options.size();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d - %s\n", i + 1, options.get(i));
        }

        int choice = IntInput.inputInt(
            String.format("\nPlease choose an option 1..%d", n), 
            n
        );

        return options.get(choice - 1);
    }

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

        System.out.println( int_getChoice(options));
    }
}
