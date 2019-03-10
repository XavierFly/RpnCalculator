package com.wangxiang.rpn;

import com.wangxiang.rpn.stack.RpnStack;
import com.wangxiang.rpn.stack.RpnCacheStack;
import com.wangxiang.rpn.calculator.Calculator;
import com.wangxiang.rpn.exception.*;
import com.wangxiang.rpn.properties.*;

public class Main {
    /**
     * 程序入口
     * @param args 命令行入参
     */
    public static void main(String[] args) {
        try {
            init();
            Calculator.inputItem();
        } catch (CommonException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 程序初始化
     * @throws CommonException 公共异常
     */
    private static void init() throws CommonException {
        CommonConfiguration.init();
        RpnStack.getInstance();
        RpnCacheStack.getInstance();
    }
}
