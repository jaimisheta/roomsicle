package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseQueryProperties {

    private static Properties properties;

    public static void loadDatabaseQueryPropertiesFile() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/DatabaseQuery.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDatabaseQueryPropertyValue(String propertyKey) {
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue.trim();
    }
}
