
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

    static int int_getChoice(ArrayList<String> options) {
        int index = 0;
        int n = options.size();

        for (String option : options) {
            System.out.printf("%2d - %s\n", index + 1, option);
            index++;
        }
        return 1;
    }
}
