import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.WelcomePageController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoommateFinder {

    static final Logger logger = LogManager.getLogger(RoommateFinder.class);

    public static void main(String[] args) {
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
