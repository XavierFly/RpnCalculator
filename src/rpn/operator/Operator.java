package rpn.operator;

import rpn.stack.RpnCacheStack;
import rpn.stack.RpnStack;

public abstract class Operator {
    RpnStack rpnStack = RpnStack.getInstance();
    RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();

    double firstNumber;
    double secondNumber;

    void getTwoNumber() {
        firstNumber = Double.valueOf(rpnStack.stackPop());
        secondNumber = Double.valueOf(rpnStack.stackPop());
    }

    void getOneNumber() {
        firstNumber = Double.valueOf(rpnStack.stackPop());
    }

    public abstract void handle();
}
