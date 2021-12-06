package controllertest.userprofiletest;

import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import models.UserDetailsModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserProfileTest {
    UserDetailsModel userDetailsModel=new UserDetailsModel();
    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void displayUserFirstNameTest(){
        userDetailsModel.setFirstName("hardik");
        Assert.assertSame("hardik",userDetailsModel.getFirstName());
    }

    @Test
    public void displayUserLastNameTest(){
        userDetailsModel.setLastName("hardik");
        Assert.assertSame("hardik",userDetailsModel.getLastName());
    }

    @Test
    public void displayUserContactNumberTest(){
        userDetailsModel.setContactNumber("9000000000");
        Assert.assertSame("9000000000",userDetailsModel.getContactNumber());
    }

    @Test
    public void displayUserEmailIdTest(){
        userDetailsModel.setEmailId("hardik@gmail.com");
        Assert.assertSame("hardik@gmail.com",userDetailsModel.getEmailId());
    }

}