package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class DalhousieDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int propertyDistanceFromDalhousie;

    public DalhousieDistance(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public DalhousieDistance(OwnerSurveyModel ownerSurveyModel, int propertyDistanceFromDalhousie) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyDistanceFromDalhousie = propertyDistanceFromDalhousie;
    }

    @Override
    public void getValue() {
        GroceryStoreDistance groceryStoreDistance = new GroceryStoreDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.dalhousie.university.distance.message"));
            propertyDistanceFromDalhousie = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    groceryStoreDistance.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.dalhousie.university.distance.message"));
                    propertyDistanceFromDalhousie = roomsicleCLI.getNumberResponse();
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
        boolean distanceFromDalhousie = false;
        try {
            if (propertyDistanceFromDalhousie >= ONE) {
                distanceFromDalhousie = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
        }
        return distanceFromDalhousie;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setDalhousieDistance(propertyDistanceFromDalhousie);
    }
}
