package com.wangxiang.rpn.operator;

/**
 * 撤销
 */
public class Undo extends Operator {
    public void operate() {
        // 清空结果栈
        rpnStack.stackRemoveAll();

        // 从存储栈中恢复
        if (rpnCacheStack.cacheStackSize() != 0) {
            rpnCacheStack.cacheStackPop();
            if (rpnCacheStack.cacheStackSize() != 0) {
                String cacheString = rpnCacheStack.cacheStackPeek();
                String[] cacheItems = cacheString.split(inputSeparator);
                for (String item : cacheItems) {
                    rpnStack.stackPush(item);
                }
            }
        }
    }
}
