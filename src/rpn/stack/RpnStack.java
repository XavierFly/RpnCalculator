package rpn.stack;

import java.util.Stack;

public class RpnStack {
    private static RpnStack rpnStack = null;
    private Stack<String> stack = new Stack<>();

    private RpnStack() {}

    public static RpnStack getInstance() {
        if (rpnStack == null) {
            rpnStack = new RpnStack();
        }
        return rpnStack;
    }

    public void push(String string) {
        stack.push(string);
    }

    public void pop() {
        stack.pop();
    }

    public Stack<String> getStack() {
        return stack;
    }
}
