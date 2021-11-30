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
import static controller.usersurvey.UserSurveyConstants.MALE;
import static controller.usersurvey.UserSurveyConstants.FEMALE;
import static controller.usersurvey.UserSurveyConstants.DOES_NOT_MATTER;

public class UserRoommateGenderPreference implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserRoommateGenderPreference.class);

    UserSurveyModel userSurveyModel;
    int userRoommateGenderInput;
    boolean hasValidValue = false;
    String userRoommateGender;

    public UserRoommateGenderPreference(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserRoommateGenderPreference(UserSurveyModel userSurveyModel, int userRoommateGenderInput) {
        this.userSurveyModel = userSurveyModel;
        this.userRoommateGenderInput = userRoommateGenderInput;
    }

    //get roommate gender preference input
    @Override
    public void getValue() {
        UserRoommateFoodHabitsPreference userRoommateFoodHabitsPreference = new UserRoommateFoodHabitsPreference(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.roommate.division.preferences.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.preference.details.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.gender.preferences.message"));
            userRoommateGenderInput = roomsicleCLI.getNumberResponse();
            logger.info("roommate food habits preference input: " + userRoommateGenderInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userRoommateFoodHabitsPreference.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.gender.preferences.message"));
                    userRoommateGenderInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate roommate gender preference input
    @Override
    public boolean validateValue() {
        boolean validateGenderResponse = false;
        try {
            logger.info("Validating roommate gender preference input");
            if (userRoommateGenderInput == ONE) {
                validateGenderResponse = true;
                userRoommateGender = MALE;
                setValue();
            } else if (userRoommateGenderInput == TWO) {
                validateGenderResponse = true;
                userRoommateGender = FEMALE;
                setValue();
            } else if (userRoommateGenderInput == THREE) {
                validateGenderResponse = true;
                userRoommateGender = DOES_NOT_MATTER;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.gender.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.gender.message"));
        }
        return validateGenderResponse;
    }

    //set roommate gender preference input
    @Override
    public void setValue() {
        userSurveyModel.setRoommateGender(userRoommateGender);
        logger.info("roommate gender preference is set to: " + userRoommateGender);
    }

}
