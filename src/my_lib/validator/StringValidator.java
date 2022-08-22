package my_lib.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static boolean patternMatcher(String s, String regexPattern, boolean isCaseInsensitive) {
        Pattern p = isCaseInsensitive 
                    ? Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE)
                    : Pattern.compile(regexPattern);
        Matcher m = p.matcher(s);
        return m.find();
    }

    public static boolean patternMatcher(String s, String regexPattern) {
        return patternMatcher(s, regexPattern, false);
    }

    public static boolean hasLetter(String s) {
        return patternMatcher(s, "[a-z]", true);
    }

    public static boolean hasDigit(String s) {
        return patternMatcher(s, "[0-9]", true);
    }

    public static boolean hasSpecialChar(String s) {
        return patternMatcher(s, "[^a-z0-9 ]", true);
    }
}
