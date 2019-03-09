package rpn;

import java.util.Scanner;

import rpn.stack.*;
import rpn.exception.*;
import rpn.properties.*;
import rpn.operator.Operator;
import rpn.util.StringUtil;

public class Main {
    public static void main(String[] args) {
        try {
            init();
        } catch (CommonException e) {
            System.out.println(e.getMessage());
            return;
        }

        RpnStack rpnStack = RpnStack.getInstance();
        RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String itemString = scanner.nextLine();
            String[] items = itemString.split(CommonConfiguration.getInputSeparator());

            for (String item : items) {
                if (!StringUtil.verifyInputItem(item)) {
                    System.out.println("Has illegal input, try again.");
                    continue;
                }

                String operatorClassName = OperatorClassNameConfiguration.getProperties(item);
                if (operatorClassName != null) {
                    String classPath = Operator.class.getPackage().getName() + operatorClassName;
                    try {
                        Class<?> classObject = Class.forName(classPath);
                        Operator operator = (Operator) classObject.newInstance();
                        operator.handle();
                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    rpnStack.stackPush(item);
                    rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
                }
            }

            System.out.println("\nstack: " + rpnStack.getStackShowString() + "\n");
        }
    }

    private static void init() throws CommonException {
        CommonConfiguration.init();
    }
}
