package my_lib.validator;

public class IntValidator {
    public static int numDigits(int n) {
        if (n == 0) 
            return 1;

        if (n < 0)
            return numDigits(-1 * n);
        
        return String.valueOf(n).length();
    }

    public static boolean isPositive(int n) {
        return n >= 0;
    }
}
