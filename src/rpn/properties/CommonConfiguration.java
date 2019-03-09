package rpn.properties;

import java.io.IOException;
import java.util.Properties;

import rpn.exception.CommonException;

public class CommonConfiguration {
    private static CommonConfiguration commonConfiguration = null;
    private static String inputSeparator;
    private static int undoMaxTimes;
    private static int calculatorAccuracy;
    private static int showAccuracy;

    private CommonConfiguration() throws CommonException {
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResourceAsStream("Common.properties"));
            inputSeparator = properties.getProperty("inputSeparator");
            undoMaxTimes = Integer.valueOf(properties.getProperty("undoMaxTimes"));
            calculatorAccuracy = Integer.valueOf(properties.getProperty("calculatorAccuracy"));
            showAccuracy = Integer.valueOf(properties.getProperty("showAccuracy"));
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
}
