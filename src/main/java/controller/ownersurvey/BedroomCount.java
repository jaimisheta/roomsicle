package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;
import static controller.ownersurvey.OwnerSurveyConstants.SIX;

public class BedroomCount implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int numberOfBedrooms;

    public BedroomCount(OwnerSurveyModel ownerSurveyModel, int numberOfBedrooms) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public BedroomCount(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    //get bedroom count input from owner
    @Override
    public void getValue() {
        VacancyCount vacancyCount = new VacancyCount(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.bedrooms.message"));
            numberOfBedrooms = roomsicleCLI.getNumberResponse();
            logger.info("bedroom count input from user: " + numberOfBedrooms);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    vacancyCount.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.bedrooms.message"));
                    numberOfBedrooms = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate bedroom count input from owner
    @Override
    public boolean validateValue() {
        boolean validateBedroomCount = false;
        try {
            logger.info("validating bedroom count input from user");
            if (numberOfBedrooms >= ONE && numberOfBedrooms <= SIX) {
                validateBedroomCount = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.bedroom.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.bedroom.message"));
        }
        return validateBedroomCount;
    }

    //set bedroom count
    @Override
    public void setValue() {
        ownerSurveyModel.setNumberOfBedrooms(numberOfBedrooms);
        logger.info("bedroom count is set to: " + numberOfBedrooms);
    }
}
