package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.propertypricepredictor.PropertyPriceCalculator;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class TheaterDistance implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    OwnerSurveyDAO ownerSurveyDAO = new OwnerSurveyDAO();
    PropertyPriceCalculator propertyPriceCalculator = new PropertyPriceCalculator();
    static final Logger logger = LogManager.getLogger(TheaterDistance.class);

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

    //get theater distance input from owner
    @Override
    public void getValue() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
            propertyDistanceFromTheater = roomsicleCLI.getNumberResponse();
            logger.info("theater distance input from owner: " + propertyDistanceFromTheater);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    logger.info("insert owner survey data into database");
                    ownerSurveyDAO.insertOwnerSurveyDetails(ownerSurveyModel);
                    logger.info("calculate price of the property");
                    propertyPriceCalculator.propertyPrice(ownerSurveyModel);
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

    //validate theater distance input from owner
    @Override
    public boolean validateValue() {
        boolean distanceFromTheater = false;
        try {
            logger.info("validating distance input from owner: " + propertyDistanceFromTheater);
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

    //set theater distance
    @Override
    public void setValue() {
        ownerSurveyModel.setTheaterDistance(propertyDistanceFromTheater);
        logger.info("theater distance is set to: " + propertyDistanceFromTheater);
    }

}
