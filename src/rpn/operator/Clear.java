package rpn.operator;

public class Clear extends Operator {
    @Override
    public void handle() {
        rpnStack.stackRemoveAll();
        rpnCacheStack.cacheStackLimitPush("");
    }
}
