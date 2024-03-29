package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import models.ownersurveymodel.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class TheaterDistance implements IOwnerSurvey {

    static final Logger logger = LogManager.getLogger(TheaterDistance.class);

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    int propertyDistanceFromTheater;

    public TheaterDistance() {
    }

    public TheaterDistance(OwnerSurveyModel ownerSurveyModel, int propertyDistanceFromTheater) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyDistanceFromTheater = propertyDistanceFromTheater;
    }

    //get theater distance input from owner
    @Override
    public void getValue(OwnerSurveyModel ownerSurveyModel) {
        IRoomsicleCLI roomsicleCLI = new RoomsicleCLI();
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
            propertyDistanceFromTheater = roomsicleCLI.getNumberResponse();
            logger.info("theater distance input from owner: " + propertyDistanceFromTheater);
            while (hasValidValue == false) {
                if (validateValue(ownerSurveyModel)) {
                    hasValidValue = true;
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
                    propertyDistanceFromTheater = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            logger.error("Input Mismatch exception occurred");
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue(ownerSurveyModel);
        }
    }

    //validate theater distance input from owner
    @Override
    public boolean validateValue(OwnerSurveyModel ownerSurveyModel) {
        IRoomsicleCLI roomsicleCLI = new RoomsicleCLI();
        boolean distanceFromTheater = false;
        try {
            logger.info("validating distance input from owner: " + propertyDistanceFromTheater);
            if (propertyDistanceFromTheater >= ONE) {
                distanceFromTheater = true;
                setValue(ownerSurveyModel);
            } else {
                logger.error("validation failed, invalid value entered");
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
            }
        } catch (Exception e) {
            logger.error("Exception occurred while validating input");
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.invalid.distance.message"));
        }
        return distanceFromTheater;
    }

    //set theater distance
    @Override
    public void setValue(OwnerSurveyModel ownerSurveyModel) {
        ownerSurveyModel.setTheaterDistance(propertyDistanceFromTheater);
        logger.info("theater distance is set to: " + propertyDistanceFromTheater);
    }

}
