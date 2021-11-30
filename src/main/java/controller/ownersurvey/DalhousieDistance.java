package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class DalhousieDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

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

    //get dalhousie distance input from owner
    @Override
    public void getValue() {
        GroceryStoreDistance groceryStoreDistance = new GroceryStoreDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.dalhousie.university.distance.message"));
            propertyDistanceFromDalhousie = roomsicleCLI.getNumberResponse();
            logger.info("dalhousie distance input from owner: " + propertyDistanceFromDalhousie);
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

    //validate dalhousie distance input from owner
    @Override
    public boolean validateValue() {
        boolean distanceFromDalhousie = false;
        try {
            logger.info("validating dalhousie distance input from owner: " + propertyDistanceFromDalhousie);
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

    //set dalhousie distance
    @Override
    public void setValue() {
        ownerSurveyModel.setDalhousieDistance(propertyDistanceFromDalhousie);
        logger.info("dalhousie distance is set to:" + propertyDistanceFromDalhousie);
    }
}
