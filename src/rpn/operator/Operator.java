package rpn.operator;

import rpn.stack.RpnCacheStack;
import rpn.stack.RpnStack;

public interface Operator {
    RpnStack rpnStack = RpnStack.getInstance();
    RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();

    void handle();
}
