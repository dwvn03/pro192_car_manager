package input;

public class BooleanInput extends Input {
    public static boolean inputBool(String msg) {
        while (true) {
            try {
                System.out.format("%s", msg);
                boolean input = sc.nextBoolean();
            
                clearScannerBuffer();

                return input;
            } catch (Exception e) {
                String errorMsg = e.getMessage() == null 
                    ? "Invalid format or data type"
                    : e.getMessage();

                printErrMsg("boolean", errorMsg);
                clearScannerBuffer();
            }
        }
    }

    public static boolean inputBool(String msg, Boolean replaceWholeMsg) {
        if (replaceWholeMsg)
            return inputBool(msg);
        else
            return inputBool("Input " + msg);
    }
}