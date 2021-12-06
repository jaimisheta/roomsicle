package controllertest.userloginandregistrationtest;

import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import junit.framework.TestCase;
import models.UsersModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserRegistrationControllerTest{
    UsersModel usersModel=new UsersModel();

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void setFirstNameTest() {
        usersModel.setFirstName("hardik");
        Assert.assertSame("hardik",usersModel.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        usersModel.setLastName("mesvania");
        Assert.assertSame("mesvania",usersModel.getLastName());
    }

    @Test
    public void setContactTest() {
        usersModel.setContactNumber(1234567890);
        Assert.assertEquals(1234567890,usersModel.getContactNumber());
    }

    @Test
    public void setEmailTest() {
        usersModel.setEmailId("hardik123@gmail.com");
        Assert.assertSame("hardik123@gmail.com",usersModel.getEmailId());
    }

    @Test
    public void setPasswordTest() {
        usersModel.setPassword("hardik");
        Assert.assertSame("hardik",usersModel.getPassword());
    }
}