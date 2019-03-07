package rpn.operator;

public class Undo implements Operator {
    @Override
    public void handle() {
        rpnStack.pop();
        if (rpnCacheStack.isLastOperator()) {
            for (String s : rpnCacheStack.getStack()) {
                rpnStack.push(s);
            }
        }
    }
}
