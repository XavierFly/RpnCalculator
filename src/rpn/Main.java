package rpn;

import java.util.Scanner;
import java.util.Properties;
import java.io.IOException;

import rpn.stack.RpnCacheStack;
import rpn.stack.RpnStack;
import rpn.util.StringUtil;
import rpn.operator.Operator;

public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // String inputString = scanner.nextLine();

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        RpnStack rpnStack = RpnStack.getInstance();
        RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();

        String[] testSting = {"5", "4", "+", "undo", "+", "1", "undo"};

        for (String s : testSting) {
            if (properties.getProperty(s) != null) {
                if (!s.equals("undo")) {
                    rpnCacheStack.setLastOperator(true);
                }

                String classPath = Operator.class.getPackage().getName() + "." + properties.getProperty(s);
                try {
                    Class<?> classObject = Class.forName(classPath);
                    Operator operator = (Operator) classObject.newInstance();
                    operator.handle();
                } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                rpnCacheStack.push(s);
                rpnStack.push(s);
                rpnCacheStack.setLastOperator(false);
            }

            System.out.println("---------");
            System.out.println(rpnStack.getStack());
            System.out.println();
            System.out.println(rpnCacheStack.getStack());
        }

        // System.out.println();
        // System.out.println(rpnStack.getStack());
    }
}
