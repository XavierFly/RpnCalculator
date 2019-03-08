package rpn.operator;

import java.io.IOException;
import java.util.Properties;
import java.util.Stack;

public class Undo implements Operator {
    public void handle() {
        Properties properties1 = new Properties();
        Properties properties2 = new Properties();
        try {
            properties1.load(ClassLoader.getSystemResourceAsStream("operand.properties"));
            properties2.load(ClassLoader.getSystemResourceAsStream("operator.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if (rpnStack.getStack().size() == 0 && rpnCacheStack.pop().equals("clear")) {
        //     rpnStack.getStack().removeAllElements();
        //     int tSize = rpnCacheStack.getStack().size();
        //     boolean test = true;
        //     for (int k = 0; k < tSize; k++) {
        //         String tmpString = rpnCacheStack.getStack().get(tSize - (k + 1));
        //         if (tmpString.contains("result")) {
        //             test = false;
        //             rpnStack.push(tmpString.substring(7, tmpString.length()));
        //         } else if (properties2.getProperty(tmpString) == null) {
        //             test = true;
        //             rpnStack.push(tmpString);
        //         } else {
        //             int oo = Integer.valueOf(properties1.getProperty(tmpString + "_operand"));
        //             k = k + oo;
        //         }
        //     }
        if (rpnStack.getStack().size() == 0 && rpnCacheStack.peek().contains("clear")) {
            rpnStack.getStack().removeAllElements();

            String ll = rpnCacheStack.pop();
            System.out.println(ll);
            ll = ll.substring(6, ll.length());
            String[] lls = ll.split("_");

            for (String s : lls) {
                System.out.println(s);
                if (!s.equals("clear")) {
                    rpnStack.push(s);
                }
            }
        } else {
            rpnStack.pop();
            String item = rpnCacheStack.pop();
            if (item.contains("result")) {
                String operator = rpnCacheStack.pop();

                Stack<String> tmpStack = new Stack<>();
                int operand = Integer.valueOf(properties1.getProperty(operator + "_operand"));
                for (int i = 0, j = 0; i < operand; i++, j++) {
                    String t = rpnCacheStack.getStack().get(rpnCacheStack.getStack().size() - (j + 1));
                    String kk = properties2.getProperty(t);
                    if (t.contains("result")) {
                        tmpStack.push(t.substring(7, t.length()));
                    } else if (kk == null) {
                        if (i == operand - 1) {
                            tmpStack.push(t);
                        }
                    } else {
                        int aa = Integer.valueOf(properties1.getProperty(t + "_operand"));
                        j++;
                        operand = operand + aa;
                    }
                }

                int tmpSize = tmpStack.size();
                for (int i = 0; i < tmpSize; i++) {
                    rpnStack.push(tmpStack.pop());
                }
            }
        }
    }
}
