package controllertest.ownerprofiletest;

import commandline.CommandLineInputProperties;
import controller.ControllerProperties;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import models.OwnerDetailsModel;
import models.OwnerPropertyDetailsModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OwnerProfileTest {
    OwnerDetailsModel ownerDetailsModel=new OwnerDetailsModel();
    OwnerPropertyDetailsModel ownerPropertyDetailsModel=new OwnerPropertyDetailsModel();
    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
        ConfigProperties.loadConfigPropertiesFile();
        DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
    }

    @Test
    public void displayOwnerFirstNameTest(){
        ownerDetailsModel.setFirstName("harsh");
        Assert.assertSame("harsh",ownerDetailsModel.getFirstName());
    }

    @Test
    public void displayOwnerLastNameTest(){
        ownerDetailsModel.setLastName("kadia");
        Assert.assertSame("kadia",ownerDetailsModel.getLastName());
    }

    @Test
    public void displayOwnerContactNumberTest(){
        ownerDetailsModel.setContactNumber("9898989898");
        Assert.assertSame("9898989898",ownerDetailsModel.getContactNumber());
    }

    @Test
    public void displayOwnerEmailIdTest(){
        ownerDetailsModel.setEmailId("hkhk@gmail.com");
        Assert.assertSame("hkhk@gmail.com",ownerDetailsModel.getEmailId());
    }

    @Test
    public void displayOwnerPropertyAddressTest(){
        ownerPropertyDetailsModel.setAddress("halifax");
        Assert.assertSame("halifax",ownerPropertyDetailsModel.getAddress());
    }

}