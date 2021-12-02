package commandline;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommandLineInputProperties {

    private static Properties properties;

    public static void loadCommandLineInputPropertiesFile() {
        String path = System.getProperty("user.dir");
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/classes/CommandLineInput.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCommandLineInputPropertyValue(String propertyKey) {
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue.trim();
    }
}
