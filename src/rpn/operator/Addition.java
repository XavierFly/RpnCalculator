package rpn.operator;

public class Addition implements Operator {
    @Override
    public void handle() {
        double a = Double.valueOf(rpnStack.pop());
        double b = Double.valueOf(rpnStack.pop());
        double result = b + a;
        rpnStack.push(String.valueOf(result));
    }
}
