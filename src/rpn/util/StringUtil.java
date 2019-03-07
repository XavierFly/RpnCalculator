package rpn.util;

public class StringUtil {
    public static String[] spiltBySpace(String inputString) {
        return inputString.split(" ");
    }

    public static String handleClear(String inputString) {
        int clearIndex = inputString.indexOf(" clear ");
        if (clearIndex == -1) {
            return inputString;
        }
        return inputString.substring(clearIndex + " clear ".length(), inputString.length());
    }

    public static String arrayToString(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
