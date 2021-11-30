package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;
import static controller.ownersurvey.OwnerSurveyConstants.TWELVE;

public class VacancyCount implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int vacancies;

    public VacancyCount(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public VacancyCount(OwnerSurveyModel ownerSurveyModel, int vacancies) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.vacancies = vacancies;
    }

    //get vacancy count input from owner
    @Override
    public void getValue() {
        Utilities utilities = new Utilities(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.vacancies.message"));
            vacancies = roomsicleCLI.getNumberResponse();
            logger.info("vacancy count input from owner: " + vacancies);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    utilities.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.vacancies.message"));
                    vacancies = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate vacancy count input from owner
    @Override
    public boolean validateValue() {
        boolean validateVacancyCount = false;
        try {
            logger.info("validating vacancy count input from owner: " + vacancies);
            if (vacancies >= ONE && vacancies <= TWELVE) {
                validateVacancyCount = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.vacancy.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.vacancy.message"));
        }
        return validateVacancyCount;
    }

    //set vacancy count
    @Override
    public void setValue() {
        ownerSurveyModel.setNumberOfVacancies(vacancies);
        logger.info("vacancy count is set to: " + vacancies);
    }
}
