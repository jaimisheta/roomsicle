package controllertest.userloginandregistrationtest;

import Exception.EmailException;
import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.verifications.EmailFormatVerifierController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmailFormatVerifierControllerTest  {
    EmailFormatVerifierController emailFormatVerifier=new EmailFormatVerifierController();

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void ValidEmailFormatVerifierPositiveTest(){
        Boolean actual;
        Boolean expected;
        actual=emailFormatVerifier.ValidEmailFormatVerifier(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.message"));
        expected=true;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void ValidEmailFormatVerifierNegativeTest(){
        Boolean actual;
        Boolean expected;
        actual=emailFormatVerifier.ValidEmailFormatVerifier(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"));
        expected=false;
        Assert.assertEquals(actual, expected);
    }

    @Test(expected= EmailException.class)
    public void ValidEmailFormatVerifierExceptionTest() throws EmailException {
        emailFormatVerifier.EmailFormatVerifier(CommandLineInputProperties.getCommandLineInputPropertyValue("login.example.test.email.actual.message"));
    }
}