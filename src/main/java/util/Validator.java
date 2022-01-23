package util;

import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Matcher matcher = null;
    private static Pattern pattern = null;

    public static boolean isDate(Time Date){
        Pattern pattern = Pattern.compile(Constant.DATE_PATTERN);
        Matcher matcher = pattern.matcher((CharSequence) Date);
        return matcher.matches();
    }
}
