package com.wangxiang.rpn.calculator;

import java.util.Scanner;

import com.wangxiang.rpn.stack.RpnStack;
import com.wangxiang.rpn.stack.RpnCacheStack;
import com.wangxiang.rpn.operator.Operator;
import com.wangxiang.rpn.util.StringUtil;
import com.wangxiang.rpn.exception.CommonException;
import com.wangxiang.rpn.properties.CommonConfiguration;
import com.wangxiang.rpn.properties.OperatorClassNameConfiguration;

/**
 * 计算器
 */
public class Calculator {
    private static RpnStack rpnStack = RpnStack.getInstance();    // 结果栈
    private static RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();    // 存储栈

    private static Scanner scanner = new Scanner(System.in);

    private static int count;    // 项位置
    private static String faultItem = null;    // 出错的项

    private static final String inputSeparator = CommonConfiguration.getInputSeparator();    // 输入分隔符
    private static int inputSeparatorLength = inputSeparator.replace("\\", "").length() + 1;    // 输入分隔符长度
    private static final String lineSeparator = CommonConfiguration.getLineSeparator();    // 系统换行符

    /**
     * 命令行输入数字及操作符
     */
    public static void inputItem() {
        System.out.println("Let's go." + lineSeparator);

        while (scanner.hasNext()) {
            String itemString = scanner.nextLine();

            count = 1;

            // 输入 exit 关闭程序
            if (itemString.equals(CommonConfiguration.getExitSign())) {
                System.out.println(lineSeparator + "Bye." + lineSeparator);
                System.exit(0);
            } else if (itemString.length() == 0) {
                continue;
            }

            handleItem(itemString);
        }
    }

    /**
     * 处理输入的字符串
     * @param itemString 输入的字符串
     */
    private static void handleItem(String itemString) {
        String[] items = itemString.split(inputSeparator);

        for (String item : items) {
            faultItem = null;

            // 验证项是否合法
            try {
                StringUtil.verifyInputItem(item);
            } catch (CommonException e) {
                System.out.println(e.getMessage());
                break;
            }

            count += inputSeparatorLength;

            // 数字与操作符分开处理
            if (OperatorClassNameConfiguration.getProperties(item) != null) {
                handleOperatorItem(item);
                if (faultItem != null) {
                    break;
                }
            } else {
                handleNumberItem(item);
            }
        }

        // 显示当前栈状态
        if (items.length > 0) {
            displayCurrentStack();
        }
    }

    /**
     * 处理数字项
     * @param item 项
     */
    private static void handleNumberItem(String item) {
        rpnStack.stackPush(item);
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }

    /**
     * 处理操作符项
     * @param item 项
     */
    private static void handleOperatorItem(String item) {
        // 根据配置找到对应的操作符类并操作
        String operatorClassName = OperatorClassNameConfiguration.getProperties(item);
        String classPath = Operator.class.getPackage().getName() + operatorClassName;
        try {
            Class<?> classObject = Class.forName(classPath);
            Operator operator = (Operator) classObject.newInstance();
            operator.operate();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            System.out.println(new CommonException("E002").getMessage());
        } catch (CommonException e) {
            faultItem = item;
            count -= inputSeparatorLength;
        }
    }

    /**
     * 显示当前栈状态
     */
    private static void displayCurrentStack() {
        if (faultItem != null) {
            // 操作符的操作数错误警告
            System.out.printf(new CommonException("E004").getMessage(), faultItem, count, rpnStack.getStackShowString());
        } else {
            // 当前栈状态
            System.out.println(lineSeparator + "stack: " + rpnStack.getStackShowString() + lineSeparator);
        }
    }
}
