package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class DowntownDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

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

    //get downtown distance input from owner
    @Override
    public void getValue() {
        TheaterDistance theaterDistance = new TheaterDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.downtown.distance.message"));
            propertyDistanceFromDowntown = roomsicleCLI.getNumberResponse();
            logger.info("downtown distance input from owner: " + propertyDistanceFromDowntown);
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

    //validate downtown distance input from owner
    @Override
    public boolean validateValue() {
        boolean distanceFromDowntown = false;
        try {
            logger.info("validate downtown distance input from owner: " + propertyDistanceFromDowntown);
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

    //set downtown distance
    @Override
    public void setValue() {
        ownerSurveyModel.setDowntownDistance(propertyDistanceFromDowntown);
        logger.info("downtown distance is set to: " + propertyDistanceFromDowntown);
    }
}
