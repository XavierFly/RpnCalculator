package com.wangxiang.rpn.properties;

import java.io.IOException;
import java.util.Properties;

import com.wangxiang.rpn.exception.CommonException;

/**
 * 公共配置
 */
public class CommonConfiguration {
    private static CommonConfiguration commonConfiguration = null;
    private static String inputSeparator;    // 输入分隔符
    private static int undoMaxTimes;    // 最大撤销数
    private static int calculatorAccuracy;    // 计算精度
    private static int showAccuracy;    // 展示精度
    private static String exitSign;    // 推出标志
    private static final String lineSeparator = System.getProperty("line.separator");    // 系统分隔符

    /**
     * 获取公共配置实例
     * @throws CommonException 公共异常
     */
    private CommonConfiguration() throws CommonException {
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResourceAsStream("Common.properties"));
            inputSeparator = properties.getProperty("inputSeparator");
            undoMaxTimes = Integer.valueOf(properties.getProperty("undoMaxTimes"));
            calculatorAccuracy = Integer.valueOf(properties.getProperty("calculatorAccuracy"));
            showAccuracy = Integer.valueOf(properties.getProperty("showAccuracy"));
            exitSign = properties.getProperty("exitSign");
        } catch (IOException e) {
            throw new CommonException("E001");
        }
    }

    public static void init() throws CommonException {
        if (commonConfiguration == null) {
            commonConfiguration = new CommonConfiguration();
        }
    }

    public static String getInputSeparator() {
        return inputSeparator;
    }

    public static int getUndoMaxTimes() {
        return undoMaxTimes;
    }

    public static int getCalculatorAccuracy() {
        return calculatorAccuracy;
    }

    public static int getShowAccuracy() {
        return showAccuracy;
    }

    public static String getExitSign() {
        return exitSign;
    }

    public static String getLineSeparator() {
        return lineSeparator;
    }
}
