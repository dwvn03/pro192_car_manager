package my_lib.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static boolean patternMatcher(String s, String regexPattern) {
        Pattern p = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        return m.find();
    }

    public static boolean hasLetter(String s) {
        return patternMatcher(s, "[a-z]");
    }

    public static boolean hasDigit(String s) {
        return patternMatcher(s, "[0-9]");
    }

    public static boolean hasSpecialChar(String s) {
        return patternMatcher(s, "[^a-z0-9 ]");
    }
}
