package my_lib.input;

import java.util.InputMismatchException;

import my_lib.validator.IntValidator;

public class IntInput extends Input {
    public static int inputInt(String msg, int max) {
        while (true) {
            try {
                System.out.format("%s : ", msg);
                int input = sc.nextInt();

                if (!(input >= 1 && input <= max)) {
                    throw new Exception("You can only chose between 1 and " + max);
                }

                clearScannerBuffer();

                return input;
            } catch (Exception e) {
                String errorMsg = e.getMessage() == null 
                    ? "Invalid data type"
                    : e.getMessage();

                printErrMsg("choice", errorMsg);
                clearScannerBuffer();
            }
        }
    }
    public static int inputInt(String msg) {
        while (true) {
            try {
                System.out.format("Input %s : ", msg);
                int input = sc.nextInt();

                clearScannerBuffer();

                return input;
            } catch (Exception e) {
                String errorMsg = e.getMessage() == null 
                    ? "Invalid data type"
                    : e.getMessage();

                printErrMsg(msg, errorMsg);
                clearScannerBuffer();
            }
        }
    }

    public static int inputInt(int numDigit) {
        while (true) {
            try {
                System.out.format("Input a %d-digit integer : ", numDigit);
                int input = sc.nextInt();
                int inputLen = IntValidator.numDigits(input);

                if (inputLen != numDigit) {
                    String errorMsg = String.format(
                        "\nExpected a %d-digit integer\nGot a %d-digit integer\n",
                        numDigit, inputLen
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

                printErrMsg("integer", errorMsg);
                clearScannerBuffer();
            }
        }
    }

    public static int inputInt(String msg, boolean isPositive) {
        while (true) {
            int input = inputInt(msg);

            if (input != 0 && isPositive != IntValidator.isPositive(input)) {
                String errorMsg;

                if (isPositive && !IntValidator.isPositive(input))
                    errorMsg = "Expected a positive number";
                else 
                    errorMsg = "Expected a negative number";

                printErrMsg(msg, errorMsg);
            } else {
                return input;
            }
        }
    }

    public static int inputInt(int numDigit, boolean isPositive) {
        while (true) {
            int input = inputInt(numDigit);

            if (input != 0 && isPositive != IntValidator.isPositive(input)) {
                String errorMsg;

                if (isPositive && !IntValidator.isPositive(input))
                    errorMsg = "Expected a positive number";
                else 
                    errorMsg = "Expected a negative number";

                printErrMsg("integer", errorMsg);
            } else {
                return input;
            }
        }
    }
}