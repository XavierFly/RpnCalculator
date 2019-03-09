package rpn.properties;

import java.io.IOException;
import java.util.Properties;

public class OperatorClassNameConfiguration {
    public static String getProperties(String key) {
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResourceAsStream("OperatorClassName.properties"));
            return properties.getProperty(key);
        } catch (IOException e) {
            return null;
        }
    }
}
