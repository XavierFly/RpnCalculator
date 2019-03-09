package rpn.stack;

import rpn.util.StringUtil;

import java.util.Stack;

public class RpnStack {
    private static RpnStack rpnStack = null;
    private static Stack<String> stack = null;

    private RpnStack() {}

    public static RpnStack getInstance() {
        if (rpnStack == null) {
            rpnStack = new RpnStack();
            stack = new Stack<>();
        }
        return rpnStack;
    }

    public void stackPush(String item) {
        stack.push(item);
    }

    public String stackPop() {
        return stack.pop();
    }

    public void stackRemoveAll() {
        stack.removeAllElements();
    }

    public String getStackString() {
        return StringUtil.handleStackString(stack.toString());
    }

    public String getStackShowString() {
        return StringUtil.handleStackShowString(stack);
    }
}
