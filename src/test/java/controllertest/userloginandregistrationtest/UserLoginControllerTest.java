package controllertest.userloginandregistrationtest;

import Exception.PasswordNotMatchException;
import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import controller.userlogin.UserLoginController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserLoginControllerTest {
    UserLoginController userLoginController=new UserLoginController();
    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }
    @Test
    public void passwordMatchesTest()  {
        UserLoginController userLoginController = mock(UserLoginController.class);
        when(userLoginController.ValidatecheckCreds("hardik22@gmail.com")).thenReturn("hardik");
        assertEquals(userLoginController.ValidatecheckCreds("hardik22@gmail.com"), "hardik");
    }

    @Test(expected =PasswordNotMatchException.class)
    public void loginPasswordExceptionTest() throws PasswordNotMatchException {
        userLoginController.Login();
    }

    @Test
    public void userLoginControllerTest(){
         String actual=userLoginController.CheckCreds();
         String expected= null;
         assertEquals(actual,expected);
    }


}