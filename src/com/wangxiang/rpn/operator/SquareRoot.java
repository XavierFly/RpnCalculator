package com.wangxiang.rpn.operator;

import java.math.BigDecimal;

import com.wangxiang.rpn.exception.CommonException;

/**
 * 平方根
 */
public class SquareRoot extends Operator {
    @Override
    public void operate() throws CommonException {
        getOneNumber();
        BigDecimal bigDecimal = new BigDecimal(Math.sqrt(firstNumber));
        String result = bigDecimal.setScale(calculatorAccuracy, BigDecimal.ROUND_HALF_UP).toString();
        rpnStack.stackPush(result);
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
