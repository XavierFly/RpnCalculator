package rpn.util;

public class StringUtil {
        public static String[] spiltBySpace(String inputString) {
        return inputString.split(" ");
    }

    public static String arrayToString(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static int go() {
        return 1;
    }
}
