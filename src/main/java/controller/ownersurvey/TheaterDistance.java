package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class TheaterDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    OwnerSurveyDAO ownerSurveyDAO = new OwnerSurveyDAO();

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int propertyDistanceFromTheater;

    public TheaterDistance(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public TheaterDistance(OwnerSurveyModel ownerSurveyModel, int propertyDistanceFromTheater) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyDistanceFromTheater = propertyDistanceFromTheater;
    }

    @Override
    public void getValue() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
            propertyDistanceFromTheater = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    ownerSurveyDAO.insertOwnerSurveyDetails(ownerSurveyModel);
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.profile.creation.message"));
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
                    propertyDistanceFromTheater = roomsicleCLI.getNumberResponse();
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
        boolean distanceFromTheater = false;
        try {
            if (propertyDistanceFromTheater >= ONE) {
                distanceFromTheater = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
        }
        return distanceFromTheater;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setTheaterDistance(propertyDistanceFromTheater);
    }

}
