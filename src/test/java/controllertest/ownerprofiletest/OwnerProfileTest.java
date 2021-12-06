package controllertest.ownerprofiletest;

import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import models.UserDetailsModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OwnerProfileTest {
    UserDetailsModel userDetailsModel=new UserDetailsModel();
    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void displayOwnerFirstNameTest(){
        userDetailsModel.setFirstName("harsh");
        Assert.assertSame("harsh",userDetailsModel.getFirstName());
    }

    @Test
    public void displayOwnerLastNameTest(){
        userDetailsModel.setLastName("kadia");
        Assert.assertSame("kadia",userDetailsModel.getLastName());
    }

    @Test
    public void displayOwnerContactNumberTest(){
        userDetailsModel.setContactNumber("9898989898");
        Assert.assertSame("9898989898",userDetailsModel.getContactNumber());
    }

    @Test
    public void displayOwnerEmailIdTest(){
        userDetailsModel.setEmailId("hkhk@gmail.com");
        Assert.assertSame("hkhk@gmail.com",userDetailsModel.getEmailId());
    }

}