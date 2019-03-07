package rpn.stack;

import java.util.Stack;

public class RpnCacheStack {
    private static RpnCacheStack rpnCacheStack = null;
    private Stack<String> stack;
    private boolean isLastOperator;
    private String test;

    private RpnCacheStack() {}

    public static RpnCacheStack getInstance() {
        if (rpnCacheStack == null) {
            rpnCacheStack = new RpnCacheStack();
            rpnCacheStack.setStack();
        }
        return rpnCacheStack;
    }

    public void push(String string) {
        stack.push(string);
        if (stack.size() > 2) {
            stack.remove(0);
        }
    }

    public String pop() {
        return stack.pop();
    }

    private void setStack() {
        this.stack = new Stack<>();
    }

    public Stack<String> getStack() {
        return stack;
    }

    public boolean isLastOperator() {
        return isLastOperator;
    }

    public void setLastOperator(boolean lastOperator) {
        isLastOperator = lastOperator;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
