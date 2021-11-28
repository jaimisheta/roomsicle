package controllertest.ownersurvey;

import commandline.CommandLineInputProperties;
import controller.ownersurvey.GroceryStoreDistance;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GroceryStoreDistanceTest {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    GroceryStoreDistance groceryStoreDistanceInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateValidGroceryStoreDistanceInputTest() {
        groceryStoreDistanceInput = new GroceryStoreDistance(ownerSurveyModel, 5);
        groceryStoreDistanceInput.validateValue();
        Assert.assertEquals(5, ownerSurveyModel.getGroceryStoreDistance());
    }

    @Test
    public void validateNegativeGroceryStoreDistanceInputTest() {
        groceryStoreDistanceInput = new GroceryStoreDistance(ownerSurveyModel, -1);
        groceryStoreDistanceInput.validateValue();
        Assert.assertEquals(0, ownerSurveyModel.getGroceryStoreDistance());
    }

    @Test
    public void validateNegativeGroceryStoreDistanceReturnValueTest() {
        groceryStoreDistanceInput = new GroceryStoreDistance(ownerSurveyModel, -1);
        Assertions.assertEquals(false, groceryStoreDistanceInput.validateValue());
    }

    @Test
    public void validateInvalidGroceryStoreDistanceInputTest() {
        groceryStoreDistanceInput = new GroceryStoreDistance(ownerSurveyModel, 0);
        Assertions.assertEquals(false, groceryStoreDistanceInput.validateValue());
    }

}
