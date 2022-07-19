package my_lib.input;

import java.util.Scanner;

public class Input {
    static final Scanner sc = new Scanner(System.in);

    public static void clearScannerBuffer() {
        sc.nextLine();
    }

    public static void waitForEnter() {
        sc.nextLine();
    }

    public static void printErrMsg(String object, String msg) {
        System.out.format("\nInvalid %s :\n", object);
        System.out.println(msg);
        System.out.println("=====================================\n");
    }
}
