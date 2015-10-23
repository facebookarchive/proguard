package proguard.util;

/**
 * Created by florianl on 8/4/15.
 */
public class StringMatcherUtil {

    private static char[] buffer = new char[1024];

    // This is not threadsafe, but proguard is currently single threaded so this is ok.
    public static synchronized boolean matchesString(StringMatcher matcher, String string) {
        if (buffer.length < string.length()) {
            // Grow the buffer
            buffer = new char[string.length()];
        }
        string.getChars(0, string.length(), buffer, 0);

        return matcher.matches(buffer, 0, string.length()-1);
    }
}
