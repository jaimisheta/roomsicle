package controllertest.bestfitroommatetest;

import commandline.CommandLineInputProperties;
import controller.ClassInitializer;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import controller.ControllerProperties;
import controller.bestfitroommates.IBestFitRoommateController;
import controller.getloggedinuser.IGetLoggedInUserController;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

public class BestFitRoommateControllerTest {

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void testListOfOperation() {

        HashMap<String, Integer> map;
        IBestFitRoommateController bestFitRoommateController;

        IGetLoggedInUserController getLoggedInUserObject = ClassInitializer.initializer().getLoggedInUserController();
        bestFitRoommateController = ClassInitializer.initializer().getBestFitRoommateController();
        HashMap<String, Integer> testMap = bestFitRoommateController.findBestFit(getLoggedInUserObject);
        map = new HashMap<String, Integer>() {{
            put(ControllerProperties.getControllerPropertyValue("bestFitData1.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData1.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData2.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData2.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData3.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData3.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData4.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData4.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData5.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData5.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData6.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData6.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData8.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData8.value")));
            put(ControllerProperties.getControllerPropertyValue("bestFitData9.key"), Integer.parseInt(ControllerProperties.getControllerPropertyValue("bestFitData9.value")));
        }};
        assertEquals(bestFitRoommateController.findBestFit(getLoggedInUserObject), testMap);
    }

}

