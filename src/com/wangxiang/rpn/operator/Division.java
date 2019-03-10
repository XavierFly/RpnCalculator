package com.wangxiang.rpn.operator;

import java.math.BigDecimal;

import com.wangxiang.rpn.exception.CommonException;

/**
 * 除法
 */
public class Division extends Operator {
    @Override
    public void operate() throws CommonException {
        getTwoNumber();
        BigDecimal bigDecimal = new BigDecimal(secondNumber / firstNumber);
        String result = bigDecimal.setScale(calculatorAccuracy, BigDecimal.ROUND_HALF_UP).toString();
        rpnStack.stackPush(result);
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
