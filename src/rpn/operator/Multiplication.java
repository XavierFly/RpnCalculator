package rpn.operator;

public class Multiplication extends Operator {
    @Override
    public void handle() {
        getTwoNumber();
        double result = secondNumber * firstNumber;
        rpnStack.stackPush(String.valueOf(result));
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
