package rpn.operator;

public class Clear implements Operator {
    @Override
    public void handle() {
        rpnStack.getStack().removeAllElements();
    }
}
