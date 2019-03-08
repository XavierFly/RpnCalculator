package rpn.stack;

import java.util.Stack;

public class RpnCacheStack {
    private static RpnCacheStack rpnCacheStack = null;
    private Stack<String> stack;

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
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    private void setStack() {
        this.stack = new Stack<>();
    }

    public Stack<String> getStack() {
        return stack;
    }
}
