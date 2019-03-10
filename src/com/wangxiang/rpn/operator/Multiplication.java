package com.wangxiang.rpn.operator;

import com.wangxiang.rpn.exception.CommonException;

/**
 * 乘法
 */
public class Multiplication extends Operator {
    @Override
    public void operate() throws CommonException {
        getTwoNumber();
        rpnStack.stackPush(String.valueOf(secondNumber * firstNumber));
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
