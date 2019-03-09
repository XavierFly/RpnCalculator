package rpn.operator;

import rpn.properties.CommonConfiguration;

public class Undo extends Operator {
    public void handle() {
        rpnStack.stackRemoveAll();

        if (rpnCacheStack.cacheStackSize() != 0) {
            rpnCacheStack.cacheStackPop();
            if (rpnCacheStack.cacheStackSize() != 0) {
                String cacheString = rpnCacheStack.cacheStackPeek();
                String[] cacheItems = cacheString.split(CommonConfiguration.getInputSeparator());
                for (String item : cacheItems) {
                    rpnStack.stackPush(item);
                }
            }
        }
    }
}
