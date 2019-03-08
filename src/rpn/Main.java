package rpn;

import java.util.Properties;
import java.io.IOException;
import java.util.Scanner;

import rpn.stack.RpnCacheStack;
import rpn.stack.RpnStack;
import rpn.operator.Operator;
import rpn.util.StringUtil;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("operator.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            RpnStack rpnStack = RpnStack.getInstance();
            RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();

            // String[] testSting = {"7", "12", "2", "/", "*", "4", "/", "undo", "undo"};
            // String[] testSting = {"1", "2", "3", "4", "5", "*", "clear", "3", "4", "-", "undo", "undo"};
            // String[] testSting = {"1", "2", "3", "4", "5", "*", "clear", "3", "4", "-", "undo", "undo"};
            // String[] testSting = {"4", "4", "clear", "4", "4", "sqrt", "*", "undo", "undo", "undo", "undo", "undo", "undo"};
            // String[] testSting = {"4", "4", "sqrt", "clear", "2", "2", "+", "undo", "undo", "undo", "undo"};
            // String[] testSting = {"4", "3", "2", "+", "+", "undo"};

            // ******
            // 8 7 6 + + 5 4 3 2 + + 1 + clear
            // ******

            String string = scanner.nextLine();
            String[] testSting = StringUtil.spiltBySpace(string);

            for (String s : testSting) {
                if (!s.equals("undo")) {
                    if (s.equals("clear")) {
                        String test = rpnStack.getStack().toString();
                        test = test.substring(1, test.length() - 1);
                        test = test.replace(",", "_");
                        rpnCacheStack.push("clear_" + test);
                        System.out.println(rpnCacheStack.getStack());
                    } else {
                        rpnCacheStack.push(s);
                    }
                }

                if (properties.getProperty(s) != null) {
                    String classPath = Operator.class.getPackage().getName() + "." + properties.getProperty(s);
                    try {
                        Class<?> classObject = Class.forName(classPath);
                        Operator operator = (Operator) classObject.newInstance();
                        operator.handle();
                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    rpnStack.push(s);
                }

                System.out.println("---------");
                System.out.println(s);
                System.out.println();
                System.out.println(rpnStack.getStack());
                System.out.println();
                System.out.println(rpnCacheStack.getStack());
                System.out.println();
                System.out.println("---------");
            }

            // System.out.println(rpnStack.getStack());
            // System.out.println();
            // System.out.println("-----------------------");
        }
    }
}
