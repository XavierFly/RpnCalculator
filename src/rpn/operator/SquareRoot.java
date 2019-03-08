package rpn.operator;

public class SquareRoot implements Operator {
    @Override
    public void handle() {
        double a = Double.valueOf(rpnStack.pop());
        double result = Math.sqrt(a);
        rpnCacheStack.push("result_" + result);
        rpnStack.push(String.valueOf(result));
    }
}
