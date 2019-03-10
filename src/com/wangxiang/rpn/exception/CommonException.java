package com.wangxiang.rpn.exception;

import com.wangxiang.rpn.properties.CommonConfiguration;

/**
 * 公共异常
 */
public class CommonException extends Exception {
    private static String errorMessage;    // 错误信息
    private static final String lineSeparator = CommonConfiguration.getLineSeparator();    // 系统回车符

    public CommonException() {
        super();
    }

    public CommonException(String errorCode) {
        switch (errorCode) {
            case "E001":
                errorMessage = lineSeparator + "The properties is not found.";
                break;
            case "E002":
                errorMessage = lineSeparator + "The operator is not assigned.";
                break;
            case "E003":
                errorMessage = lineSeparator + "The input has illegal item.";
                break;
            case "E004":
                errorMessage = lineSeparator + "operator %s (position %d): insufficient parameters stack: %s" + lineSeparator + lineSeparator;
                break;
            default:
                errorMessage = errorCode;
                break;
        }
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
