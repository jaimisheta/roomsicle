package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class GroceryStoreDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int propertyDistanceFromGroceryStore;

    public GroceryStoreDistance(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public GroceryStoreDistance(OwnerSurveyModel ownerSurveyModel, int propertyDistanceFromGroceryStore) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyDistanceFromGroceryStore = propertyDistanceFromGroceryStore;
    }

    @Override
    public void getValue() {
        DowntownDistance downtownDistance = new DowntownDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.grocery.store.distance.message"));
            propertyDistanceFromGroceryStore = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    downtownDistance.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.grocery.store.distance.message"));
                    propertyDistanceFromGroceryStore = roomsicleCLI.getNumberResponse();
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
        boolean distanceFromGroceryStore = false;
        try {
            if (propertyDistanceFromGroceryStore >= ONE) {
                distanceFromGroceryStore = true;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
        }
        return distanceFromGroceryStore;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setGroceryStoreDistance(propertyDistanceFromGroceryStore);
    }
}
