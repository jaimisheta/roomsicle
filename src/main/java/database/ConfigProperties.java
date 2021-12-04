package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static Properties properties;

    public static void loadConfigPropertiesFile() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/Config.properties");
//            FileInputStream fileInputStream = new FileInputStream(ConfigConstant.CONFIG_PROPERTIES_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfigPropertyValue(String propertyKey) {
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue.trim();
    }
}
