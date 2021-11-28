package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class DowntownDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int propertyDistanceFromDowntown;

    public DowntownDistance(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public DowntownDistance(OwnerSurveyModel ownerSurveyModel, int propertyDistanceFromDowntown) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyDistanceFromDowntown = propertyDistanceFromDowntown;
    }

    @Override
    public void getValue() {
        TheaterDistance theaterDistance = new TheaterDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.downtown.distance.message"));
            propertyDistanceFromDowntown = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    theaterDistance.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.downtown.distance.message"));
                    propertyDistanceFromDowntown = roomsicleCLI.getNumberResponse();
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
        boolean distanceFromDowntown = false;
        try {
            if (propertyDistanceFromDowntown >= ONE) {
                distanceFromDowntown = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
        }
        return distanceFromDowntown;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setDowntownDistance(propertyDistanceFromDowntown);
    }
}
