import commandline.CommandLineInputProperties;
import controller.ClassInitializer;
import controller.ControllerProperties;
import controller.userhomepage.IWelcomePageController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoommateFinder {

    static final Logger logger = LogManager.getLogger(RoommateFinder.class);

    public static void main(String[] args) {
        try {
            ConfigProperties.loadConfigPropertiesFile();
            CommandLineInputProperties.loadCommandLineInputPropertiesFile();
            DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
            ControllerProperties.loadControllerPropertiesFile();
            logger.info("Started Roomsicle Application");
            IWelcomePageController iWelcomePageController= ClassInitializer.initializer().getIWelcomePageController();
            iWelcomePageController.showWelcomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
