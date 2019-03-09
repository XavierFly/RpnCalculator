package rpn.util;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Pattern;

import rpn.properties.CommonConfiguration;
import rpn.properties.OperatorClassNameConfiguration;

public class StringUtil {
    public static boolean verifyInputItem(String item) {
        return Pattern.matches("^((-?[1-9]\\d*)|(0)|([1-9]\\d*))(\\.\\d*[1-9])?$", item) ||
                OperatorClassNameConfiguration.getProperties(item) != null;
    }

    public static String handleStackString(String stackString) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackString.replace(",", ""));
        return stringBuilder.substring(1, stringBuilder.length() - 1);
    }

    public static String handleStackShowString(Stack<String> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            String item = stack.get(i);
            if (item.contains(".")) {
                BigDecimal bigDecimal = new BigDecimal(item);
                stringBuilder.append(bigDecimal.setScale(CommonConfiguration.getShowAccuracy(), BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
            } else {
                stringBuilder.append(item);
            }

            if (i != size - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
