package controllertest.usersurveytest;

import commandline.CommandLineInputProperties;
import controller.usersurvey.UserBudget;
import models.UserSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserBudgetTest {

    UserSurveyModel userSurveyModel = new UserSurveyModel();
    UserBudget userBudgetInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateValidUserBudgetInputTest() {
        userBudgetInput = new UserBudget(userSurveyModel, 500);
        userBudgetInput.validateValue();
        Assert.assertEquals(5, userSurveyModel.getUserBudget());
    }

    @Test
    public void validateNegativeUserBudgetInputTest() {
        userBudgetInput = new UserBudget(userSurveyModel, -1);
        userBudgetInput.validateValue();
        Assert.assertEquals(0, userSurveyModel.getUserBudget());
    }

    @Test
    public void validateNegativeUserBudgetReturnValueTest() {
        userBudgetInput = new UserBudget(userSurveyModel, -1);
        Assert.assertFalse(userBudgetInput.validateValue());
    }

    @Test
    public void validateInvalidUserBudgetInputTest() {
        userBudgetInput = new UserBudget(userSurveyModel, 0);
        Assert.assertFalse(userBudgetInput.validateValue());
    }
}
