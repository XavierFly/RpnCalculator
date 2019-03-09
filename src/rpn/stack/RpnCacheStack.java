package rpn.stack;

import java.util.Stack;

import rpn.properties.CommonConfiguration;

public class RpnCacheStack {
    private static RpnCacheStack rpnCacheStack = null;
    private static Stack<String> cacheStack = null;

    private RpnCacheStack() {}

    public static RpnCacheStack getInstance() {
        if (rpnCacheStack == null) {
            rpnCacheStack = new RpnCacheStack();
            cacheStack = new Stack<>();
        }
        return rpnCacheStack;
    }

    public String cacheStackPop() {
        return cacheStack.pop();
    }

    public String cacheStackPeek() {
        return cacheStack.peek();
    }

    public int cacheStackSize() {
        return cacheStack.size();
    }

    public Stack<String> getStack() {
        return cacheStack;
    }

    public void cacheStackLimitPush(String item) {
        if (cacheStack.size() >= CommonConfiguration.getUndoMaxTimes()) {
            cacheStack.remove(0);
        }
        cacheStack.push(item);
    }
}
