package controllertest.ownersurveytest;

import commandline.CommandLineInputProperties;
import controller.ownersurvey.PropertyAddress;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PropertyAddressTest {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    PropertyAddress propertyAddressInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateValidPropertyAddressInputTest() {
        propertyAddressInput = new PropertyAddress(ownerSurveyModel, "address");
        propertyAddressInput.validateValue();
        Assert.assertEquals("address", ownerSurveyModel.getAddress());
    }

    @Test
    public void validateNullPropertyAddressInputTest() {
        propertyAddressInput = new PropertyAddress(ownerSurveyModel, "");
        Assert.assertEquals(false, propertyAddressInput.validateValue());
    }

    @Test
    public void validateEmptyPropertyAddressReturnValueTest() {
        propertyAddressInput = new PropertyAddress(ownerSurveyModel, " ");
        Assertions.assertEquals(false, propertyAddressInput.validateValue());
    }

    @Test
    public void validateNullPropertyAddressReturnValueTest() {
        propertyAddressInput = new PropertyAddress(ownerSurveyModel, null);
        Assertions.assertEquals(false, propertyAddressInput.validateValue());
    }
}
