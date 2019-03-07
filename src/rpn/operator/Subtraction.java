package rpn.operator;

public class Subtraction implements Operator {
    @Override
    public void handle() {
        double a = Double.valueOf(rpnStack.pop());
        double b = Double.valueOf(rpnStack.pop());
        rpnStack.push(String.valueOf(b - a));
    }
}
