package com.wangxiang.rpn.util;

import java.util.Stack;
import java.util.regex.Pattern;
import java.math.BigDecimal;

import com.wangxiang.rpn.exception.CommonException;
import com.wangxiang.rpn.properties.CommonConfiguration;
import com.wangxiang.rpn.properties.OperatorClassNameConfiguration;

public class StringUtil {
    private static final int showAccuracy = CommonConfiguration.getShowAccuracy();    // 展示精度

    /**
     * 验证项
     * @param item 项
     * @throws CommonException 公共异常
     */
    public static void verifyInputItem(String item) throws CommonException {
        if (!Pattern.matches("^((-?[1-9]\\d*)|(0)|([1-9]\\d*))(\\.\\d*[1-9])?$", item) &&
                OperatorClassNameConfiguration.getProperties(item) == null) {
            throw new CommonException("E003");
        }
    }

    /**
     * 处理栈字符串
     * @param stackString 栈字符串
     * @return 处理过的栈字符串
     */
    public static String handleStackString(String stackString) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackString.replace(",", ""));
        return stringBuilder.substring(1, stringBuilder.length() - 1);
    }

    /**
     * 获取需要展示的栈字符串
     * @param stack 栈
     * @return 展示的栈字符串
     */
    public static String handleStackShowString(Stack<String> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            String item = stack.get(i);
            if (item.contains(".")) {
                BigDecimal bigDecimal = new BigDecimal(item);
                stringBuilder.append(bigDecimal.setScale(showAccuracy, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
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
