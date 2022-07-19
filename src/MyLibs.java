
import java.util.Scanner;


public class MyLibs {

    private static Scanner sc = new Scanner(System.in);

    public static Integer getInt(String msg, String err, int min, int max, String ignore) {
        while (true) {
            try {
                System.out.print(msg);
                String s = sc.nextLine();
                if (s != null && s.trim().equalsIgnoreCase(ignore)) {
                    return null;
                }
                int num = Integer.parseInt(s);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Value inrange[" + min + "-" + max + "]");
                }
            } catch (NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }
}
