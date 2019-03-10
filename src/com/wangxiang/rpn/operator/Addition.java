package com.wangxiang.rpn.operator;

import com.wangxiang.rpn.exception.CommonException;

/**
 * 加法
 */
public class Addition extends Operator {
    @Override
    public void operate() throws CommonException {
        getTwoNumber();
        rpnStack.stackPush(String.valueOf(secondNumber + firstNumber));
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
