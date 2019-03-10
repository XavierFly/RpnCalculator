package com.wangxiang.rpn.operator;

/**
 * 清空
 */
public class Clear extends Operator {
    @Override
    public void operate() {
        rpnStack.stackRemoveAll();
        rpnCacheStack.cacheStackLimitPush("");
    }
}
