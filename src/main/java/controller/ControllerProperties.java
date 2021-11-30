package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ControllerProperties {

    private static Properties properties;

    public static void loadControllerPropertiesFile() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/Controller.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getControllerPropertyValue(String propertyKey) {
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue.trim();
    }
}
