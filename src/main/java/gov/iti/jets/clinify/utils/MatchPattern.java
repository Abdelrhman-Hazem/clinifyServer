package gov.iti.jets.clinify.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPattern {
    public static boolean isEmail(String input) {
        // Regular expression pattern for email validation
        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static boolean isPhoneNumber(String input) {
        // Regular expression pattern for phone number validation
        String phonePattern = "\\d{11}";

        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
