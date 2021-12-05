package controllertest.userloginandregistrationtest;

import Exception.PasswordNotMatchException;
import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.verifications.PasswordVerifierController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordVerifierControllerTest {

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void testPasswordVerifierValidatorController()  {
        PasswordVerifierController passwordVerifierController=new PasswordVerifierController();
        String actual=passwordVerifierController.PasswordVerifierValidatorController(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"),CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"));
        String expected=CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.expected.message");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testPasswordVerifierValidatorControllerNegative() {
        PasswordVerifierController passwordVerifierController=new PasswordVerifierController();
        String actual=passwordVerifierController.PasswordVerifierValidatorController(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"),CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.negative.test.email.message"));
        String expected=CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.failed.expected.message");
        Assert.assertEquals(actual,expected);
    }

    @Test(expected= PasswordNotMatchException.class)
    public void testPasswordVerifierValidatorControllerPasswordException() throws PasswordNotMatchException {
        PasswordVerifierController passwordVerifierController=new PasswordVerifierController();
        passwordVerifierController.PasswordVerifierController(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"),CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.negative.test.email.message"));
    }
}