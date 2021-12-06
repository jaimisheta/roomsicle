package controllertest.userloginandregistrationtest;

import Exception.PhoneNumberException;
import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.verifications.PhoneNumberVerifierController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneNumberVerifierControllerTest {
    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test(expected = PhoneNumberException.class)
    public void phoneNumberVerifierControllerExceptionTest() throws PhoneNumberException {
        PhoneNumberVerifierController phoneNumberVerifierController=new PhoneNumberVerifierController();
        phoneNumberVerifierController.PhoneNumberVerifierController(0000);
    }
}