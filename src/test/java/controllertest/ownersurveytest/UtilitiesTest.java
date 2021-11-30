package controllertest.ownersurveytest;

import commandline.CommandLineInputProperties;
import controller.ownersurvey.Utilities;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UtilitiesTest {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    Utilities utilitiesInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateUtilitiesProvidedInputTest() {
        utilitiesInput = new Utilities(ownerSurveyModel, 1);
        utilitiesInput.validateValue();
        Assert.assertEquals(true, ownerSurveyModel.isUtilitiesProvided());
    }

    @Test
    public void validateUtilitiesNotProvidedInputTest() {
        utilitiesInput = new Utilities(ownerSurveyModel, 2);
        utilitiesInput.validateValue();
        Assert.assertEquals(false, ownerSurveyModel.isUtilitiesProvided());
    }

    @Test
    public void validateNegativeUtilitiesInputReturnValueTest() {
        utilitiesInput = new Utilities(ownerSurveyModel, -1);
        Assertions.assertEquals(false, utilitiesInput.validateValue());
    }

    @Test
    public void validateInValidUtilitiesInputTest() {
        utilitiesInput = new Utilities(ownerSurveyModel, 10);
        Assertions.assertEquals(false, utilitiesInput.validateValue());
    }

}
