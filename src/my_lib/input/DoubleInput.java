package my_lib.input;

import java.util.InputMismatchException;

public class DoubleInput extends Input {
    public static double inputDouble(int decimalDigit) {
        while (true) {
            try {
                System.out.format("Input a real number with %d digit(s) after decimal point : ", decimalDigit);
                double input = sc.nextDouble();
                int inputDecimalDigit = DoubleValidator.decimalDigits(input);

                if (inputDecimalDigit != decimalDigit) {
                    String errorMsg = String.format(
                        "\nExpected a real number with %d digit(s) after decimal point\nGot a real number with %d digit(s) after decimal point\n",
                        decimalDigit, inputDecimalDigit
                    );

                    throw new InputMismatchException(errorMsg);
                } else {
                    clearScannerBuffer();

                    return input;
                }
            } catch (Exception e) {
                String errorMsg = e.getMessage() == null 
                    ? "Invalid format or data type"
                    : e.getMessage();

                printErrMsg("real number", errorMsg);
                clearScannerBuffer();
            }
        }
    }
}