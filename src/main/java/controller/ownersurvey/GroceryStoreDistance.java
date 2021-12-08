package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class GroceryStoreDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

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

    //get grocery store distance input from owner
    @Override
    public void getValue() {
        DowntownDistance downtownDistance = new DowntownDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.grocery.store.distance.message"));
            propertyDistanceFromGroceryStore = roomsicleCLI.getNumberResponse();
            logger.info("grocery store distance input from owner: " + propertyDistanceFromGroceryStore);
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

    //validate grocery store distance input from owner
    @Override
    public boolean validateValue() {
        boolean distanceFromGroceryStore = false;
        try {
            logger.info("validate grocery store distance input from owner: " + propertyDistanceFromGroceryStore);
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

    //set grocery store distance
    @Override
    public void setValue() {
        ownerSurveyModel.setGroceryStoreDistance(propertyDistanceFromGroceryStore);
        logger.info("grocery store distance is set to: " + propertyDistanceFromGroceryStore);
    }
}
