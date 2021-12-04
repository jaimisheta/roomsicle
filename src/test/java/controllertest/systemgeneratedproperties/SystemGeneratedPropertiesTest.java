package controllertest.systemgeneratedproperties;

import controller.ControllerProperties;
import controller.systemgeneratedproperties.SystemGeneratedProperties;
import database.ConfigProperties;
import mocks.SystemGeneratedPropertiesDAOMocks;
import models.SystemGeneratedPropertiesModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;

public class SystemGeneratedPropertiesTest {

    @BeforeClass
    public static void init() {
        ConfigProperties.loadConfigPropertiesFile();
        ControllerProperties.loadControllerPropertiesFile();
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    SystemGeneratedPropertiesDAOMocks systemGeneratedPropertiesDAOMocks = new SystemGeneratedPropertiesDAOMocks();
    SystemGeneratedProperties systemGeneratedProperties = new SystemGeneratedProperties();

    @Test
    public void printSystemGeneratedPropertiesPositiveScenarioTest() {
        ArrayList<SystemGeneratedPropertiesModel> systemGeneratedPropertiesModels;
        String expectedOutput;

        systemGeneratedPropertiesModels = systemGeneratedPropertiesDAOMocks.getSystemGeneratedPropertyDetails();
        systemGeneratedProperties.printSystemGeneratedProperties(systemGeneratedPropertiesModels);

        expectedOutput = "1. Owner Name: jaimi sheta\r\n" +
                "Property Address: address1\r\n" +
                "Owner email id: jaimi@gmail.com\r\n" +
                "Owner contact number: 9898989898\r\n" +
                "Property Rent: 1500\r\n" +
                "Distance from Dalhousie: 3 km\r\n" +
                "\r\n" +
                "2. Owner Name: rikin patel\r\n" +
                "Property Address: address2\r\n" +
                "Owner email id: rikin@gmail.com\r\n" +
                "Owner contact number: 6767676767\r\n" +
                "Property Rent: 1300\r\n" +
                "Distance from Dalhousie: 4 km\r\n" +
                "\r\n" +
                "3. Owner Name: hardik kumar\r\n" +
                "Property Address: address3\r\n" +
                "Owner email id: hardik@gmail.com\r\n" +
                "Owner contact number: 5656565656\r\n" +
                "Property Rent: 1700\r\n" +
                "Distance from Dalhousie: 2 km\r\n\r\n";

        Assert.assertEquals(expectedOutput, systemOutRule.getLog());
    }

    @Test
    public void printSystemGeneratedPropertiesNegativeScenarioTest() {
        ArrayList<SystemGeneratedPropertiesModel> systemGeneratedPropertiesModels;
        String expectedOutput;

        systemGeneratedPropertiesModels = systemGeneratedPropertiesDAOMocks.getSystemGeneratedPropertyDetails();
        systemGeneratedProperties.printSystemGeneratedProperties(systemGeneratedPropertiesModels);

        expectedOutput = "1. Owner Name: jaimi sheta\r\n" +
                "Property Address: address1\r\n" +
                "Owner email id: jaimi@gmail.com\r\n" +
                "Owner contact number: 9898989898\r\n" +
                "Property Rent: 2500\r\n" +
                "Distance from Dalhousie: 3 km\r\n" +
                "\r\n" +
                "2. Owner Name: rikin patel\r\n" +
                "Property Address: address2\r\n" +
                "Owner email id: rikin@gmail.com\r\n" +
                "Owner contact number: 6767676767\r\n" +
                "Property Rent: 2200\r\n" +
                "Distance from Dalhousie: 4 km\r\n" +
                "\r\n" +
                "3. Owner Name: hardik kumar\r\n" +
                "Property Address: address3\r\n" +
                "Owner email id: hardik@gmail.com\r\n" +
                "Owner contact number: 5656565656\r\n" +
                "Property Rent: 1700\r\n" +
                "Distance from Dalhousie: 2 km\r\n\r\n";

        Assert.assertNotEquals(expectedOutput, systemOutRule.getLog());
    }

    @Test
    public void printSystemGeneratedPropertiesNegativeScenarioEmptyReturnValueTest() {
        ArrayList<SystemGeneratedPropertiesModel> systemGeneratedPropertiesModels;
        String expectedOutput;

        systemGeneratedPropertiesModels = systemGeneratedPropertiesDAOMocks.getSystemGeneratedPropertyDetails();
        systemGeneratedProperties.printSystemGeneratedProperties(systemGeneratedPropertiesModels);

        expectedOutput = "";

        Assert.assertNotEquals(expectedOutput, systemOutRule.getLog());
    }
}
