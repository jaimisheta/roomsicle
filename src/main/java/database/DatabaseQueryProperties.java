package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseQueryProperties {

    private static Properties properties;

    public static void loadDatabaseQueryPropertiesFile() {
        String path = System.getProperty("user.dir");
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/classes/DatabaseQuery.properties");
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
