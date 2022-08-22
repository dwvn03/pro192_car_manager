package main;

import java.util.ArrayList;

import my_lib.input.IntInput;

public class Menu<E> {
    public int int_getChoice(ArrayList<E> options) {
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
        int choice = int_getChoice(options);

        return options.get(choice - 1);
    }
}
