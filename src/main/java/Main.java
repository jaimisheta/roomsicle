import commandline.CommandLineInputProperties;
import controller.WelcomePageController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import models.UsersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //static final Logger logger = LogManager.getLogger(RoommateFinder.class);

    public static void main(String[] args) {
        WelcomePageController wp=new WelcomePageController();
        UsersModel usersModel=new UsersModel();
        try {
            ConfigProperties.loadConfigPropertiesFile();
            CommandLineInputProperties.loadCommandLineInputPropertiesFile();
            DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
            //logger.info("Started Roomsicle Application");
            wp.showWelcomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
