package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;
import static controller.ownersurvey.OwnerSurveyConstants.SIX;

public class BedroomCount implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

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

    @Override
    public void getValue() {
        VacancyCount vacancyCount = new VacancyCount(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.bedrooms.message"));
            numberOfBedrooms = roomsicleCLI.getNumberResponse();
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

    @Override
    public boolean validateValue() {
        boolean validateBedroomCount = false;
        try {
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

    @Override
    public void setValue() {
        ownerSurveyModel.setNumberOfBedrooms(numberOfBedrooms);
    }
}
