package rpn.operator;

public class SquareRoot implements Operator {
    @Override
    public void handle() {
        double a = Double.valueOf(rpnStack.pop());
        rpnStack.push(String.valueOf(Math.sqrt(a)));
    }
}
