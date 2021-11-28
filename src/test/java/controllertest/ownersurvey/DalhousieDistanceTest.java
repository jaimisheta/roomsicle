package controllertest.ownersurvey;

import commandline.CommandLineInputProperties;
import controller.ownersurvey.DalhousieDistance;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DalhousieDistanceTest {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    DalhousieDistance dalhousieDistanceInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateValidDalhousieDistanceInputTest() {
        dalhousieDistanceInput = new DalhousieDistance(ownerSurveyModel, 5);
        dalhousieDistanceInput.validateValue();
        Assert.assertEquals(5, ownerSurveyModel.getDalhousieDistance());
    }

    @Test
    public void validateNegativeDalhousieDistanceInputTest() {
        dalhousieDistanceInput = new DalhousieDistance(ownerSurveyModel, -1);
        dalhousieDistanceInput.validateValue();
        Assert.assertEquals(0, ownerSurveyModel.getDalhousieDistance());
    }

    @Test
    public void validateNegativeDalhousieDistanceReturnValueTest() {
        dalhousieDistanceInput = new DalhousieDistance(ownerSurveyModel, -1);
        Assertions.assertEquals(false, dalhousieDistanceInput.validateValue());
    }

    @Test
    public void validateInvalidDalhousieDistanceInputTest() {
        dalhousieDistanceInput = new DalhousieDistance(ownerSurveyModel, 0);
        Assertions.assertEquals(false, dalhousieDistanceInput.validateValue());
    }
}
