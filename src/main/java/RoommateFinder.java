import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.WelcomePageController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoommateFinder {
    
    public static void main(String[] args) {
        System.setProperty("logFilename", "logs/application.logs");
        final Logger logger = LogManager.getLogger(RoommateFinder.class);
        WelcomePageController wp = new WelcomePageController();
        try {
            ConfigProperties.loadConfigPropertiesFile();
            CommandLineInputProperties.loadCommandLineInputPropertiesFile();
            DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
            ControllerProperties.loadControllerPropertiesFile();
            logger.info("Started Roomsicle Application");
            wp.showWelcomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
