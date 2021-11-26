import commandline.CommandLineInputProperties;
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
            logger.info("Started Roomsicle Application");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
