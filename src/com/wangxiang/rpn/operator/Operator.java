package com.wangxiang.rpn.operator;

import com.wangxiang.rpn.stack.RpnStack;
import com.wangxiang.rpn.stack.RpnCacheStack;
import com.wangxiang.rpn.exception.CommonException;
import com.wangxiang.rpn.properties.CommonConfiguration;

/**
 * 操作符
 */
public abstract class Operator {
    RpnStack rpnStack = RpnStack.getInstance();    // 结果栈
    RpnCacheStack rpnCacheStack = RpnCacheStack.getInstance();    // 存储栈

    static final int calculatorAccuracy = CommonConfiguration.getCalculatorAccuracy();    // 运算精度
    static final String inputSeparator = CommonConfiguration.getInputSeparator();    // 输入分隔符

    double firstNumber;    // 栈抛出的第一个数字
    double secondNumber;    // 栈抛出的第二个数字

    /**
     * 获取栈中两个数字
     * @throws CommonException 公共异常
     */
    void getTwoNumber() throws CommonException {
        firstNumber = Double.valueOf(rpnStack.stackPop());
        secondNumber = Double.valueOf(rpnStack.stackPopWithUndo(firstNumber));
    }

    /**
     * 获取栈中一个数字
     * @throws CommonException 公共异常
     */
    void getOneNumber() throws CommonException {
        firstNumber = Double.valueOf(rpnStack.stackPop());
    }

    /**
     * 运算
     * @throws CommonException 公共异常
     */
    public abstract void operate() throws CommonException;
}
