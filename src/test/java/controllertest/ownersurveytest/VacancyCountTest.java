package controllertest.ownersurveytest;

import commandline.CommandLineInputProperties;
import controller.ownersurvey.VacancyCount;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class VacancyCountTest {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    VacancyCount vacancyCountInput;

    @BeforeClass
    public static void init() {
        CommandLineInputProperties.loadCommandLineInputPropertiesFile();
    }

    @Test
    public void validateValidVacancyInputTest() {
        vacancyCountInput = new VacancyCount(ownerSurveyModel, 5);
        vacancyCountInput.validateValue();
        Assert.assertEquals(5, ownerSurveyModel.getNumberOfVacancies());
    }

    @Test
    public void validateNegativeVacancyInputTest() {
        vacancyCountInput = new VacancyCount(ownerSurveyModel, -1);
        vacancyCountInput.validateValue();
        Assert.assertEquals(0, ownerSurveyModel.getNumberOfVacancies());
    }

    @Test
    public void validateNegativeVacancyInputReturnValueTest() {
        vacancyCountInput = new VacancyCount(ownerSurveyModel, -1);
        Assert.assertFalse(vacancyCountInput.validateValue());
    }

    @Test
    public void validateInValidVacancyInput() {
        vacancyCountInput = new VacancyCount(ownerSurveyModel, 15);
        Assert.assertFalse(vacancyCountInput.validateValue());
    }

}
