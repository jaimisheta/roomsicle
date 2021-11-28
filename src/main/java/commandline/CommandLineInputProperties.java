package commandline;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommandLineInputProperties {

    private static Properties properties;

    public static void loadCommandLineInputPropertiesFile() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/CommandLineInput.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCommandLineInputPropertyValue(String propertyKey) {
        String propertyValue = null;
        try {
            if(properties==null) {
        	    loadCommandLineInputPropertiesFile();
            if(properties==null) {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue.trim();
    }
}
