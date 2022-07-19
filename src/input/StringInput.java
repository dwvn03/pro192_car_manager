package input;

import java.lang.StringBuilder;

public class StringInput extends Input {
    public static String inputStr(String msg) {
        while (true) {
            System.out.format("Input %s : ", msg);
            String input = sc.nextLine().trim();

            return input;
        }
    }

    public static String inputStr(int strLen) {
        while (true) {
            System.out.format("Input a string with %d character(s) : ", strLen);
            String input = sc.nextLine().trim();
            int inputLen = input.length();

            if (inputLen != strLen) {
                String errorMsg = String.format(
                    "\nExpected a string with %d character(s)\nGot a string with %d character(s)\n",
                    strLen, inputLen
                );

                printErrMsg("string", errorMsg);
            } else {
                return input;
            }
        }
    }

    public static String inputStr(int strLen, boolean hasLetter, boolean hasDigit, boolean hasSpecialChar) {
        while (true) {
            String input = inputStr(strLen);
            StringBuilder errorMsg = new StringBuilder("");

            if (hasLetter != StringValidator.hasLetter(input)) 
                errorMsg.append("Violate letter rule\n");
            
            if (hasDigit != StringValidator.hasDigit(input)) 
                errorMsg.append("Violate digit rule\n");
            
            if (hasSpecialChar != StringValidator.hasSpecialChar(input)) 
                errorMsg.append("Violate special character rule\n");
            
            if (errorMsg.toString().isEmpty()) {
                return input;
            } else {
                printErrMsg("string", errorMsg.toString());
            }
        }
    }
}