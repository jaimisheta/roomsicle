package controller.usersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.UserSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.usersurvey.UserSurveyConstants.ONE;
import static controller.usersurvey.UserSurveyConstants.TWO;
import static controller.usersurvey.UserSurveyConstants.THREE;
import static controller.usersurvey.UserSurveyConstants.FOUR;
import static controller.usersurvey.UserSurveyConstants.ZERO;
import static controller.usersurvey.UserSurveyConstants.FIVE;
import static controller.usersurvey.UserSurveyConstants.FIFTY;

public class UserUniversityDistancePreference implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserRoommateGenderPreference.class);

    UserSurveyModel userSurveyModel;
    boolean hasValidValue = false;
    int userUniversityDistanceInput;
    int userUniversityDistanceMin;
    int userUniversityDistanceMax;

    public UserUniversityDistancePreference(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserUniversityDistancePreference(UserSurveyModel userSurveyModel, int userUniversityDistanceInput) {
        this.userSurveyModel = userSurveyModel;
        this.userUniversityDistanceInput = userUniversityDistanceInput;
    }

    //get user university distance preference input
    @Override
    public void getValue() {
        UserRoommateGenderPreference userRoommateGenderPreference = new UserRoommateGenderPreference(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.proximity.dalhousie.university.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.university.distance.options.message"));
            userUniversityDistanceInput = roomsicleCLI.getNumberResponse();
            logger.info("user university distance preference input: " + userUniversityDistanceInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userRoommateGenderPreference.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.proximity.dalhousie.university.message"));
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.university.distance.options.message"));
                    userUniversityDistanceInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate user university distance preference input
    @Override
    public boolean validateValue() {
        boolean validateUniversityDistanceInput = false;
        try {
            logger.info("validating user university distance preference input: " + userUniversityDistanceInput);
            if (userUniversityDistanceInput == ONE) {
                validateUniversityDistanceInput = true;
                userUniversityDistanceMin = ZERO;
                userUniversityDistanceMax = ONE;
                setValue();
            } else if (userUniversityDistanceInput == TWO) {
                validateUniversityDistanceInput = true;
                userUniversityDistanceMin = ONE;
                userUniversityDistanceMax = TWO;
                setValue();
            } else if (userUniversityDistanceInput == THREE) {
                validateUniversityDistanceInput = true;
                userUniversityDistanceMin = TWO;
                userUniversityDistanceMax = FIVE;
                setValue();
            } else if (userUniversityDistanceInput == FOUR) {
                validateUniversityDistanceInput = true;
                userUniversityDistanceMin = FIVE;
                userUniversityDistanceMax = FIFTY;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.university.distance.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.university.distance.message"));
        }
        return validateUniversityDistanceInput;
    }

    //set user university distance preference
    @Override
    public void setValue() {
        userSurveyModel.setUserDalDistanceMin(userUniversityDistanceMin);
        userSurveyModel.setUserDalDistanceMax(userUniversityDistanceMax);
        logger.info("Minimum university distance preference is set to: " + userUniversityDistanceMin);
        logger.info("Maximum university distance preference is set to: " + userUniversityDistanceMax);
    }


}
