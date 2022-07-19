package input;

public class DoubleValidator {
    public static int decimalDigits(double n) {
        if (n == (long) n)
            return 0;

        String[] splitter = Double.valueOf(n).toString().split("[.]");
        return splitter[1].length();
    }
}
