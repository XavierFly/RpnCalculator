package rpn.stack;

import java.util.Stack;

public class RpnStack {
    private static RpnStack rpnStack = null;
    private Stack<String> stack;

    private RpnStack() {}

    public static RpnStack getInstance() {
        if (rpnStack == null) {
            rpnStack = new RpnStack();
            rpnStack.setStack();
        }
        return rpnStack;
    }

    public void push(String string) {
        stack.push(string);
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {return stack.peek();}

    private void setStack() {
        this.stack = new Stack<>();
    }

    public Stack<String> getStack() {
        return stack;
    }
}
