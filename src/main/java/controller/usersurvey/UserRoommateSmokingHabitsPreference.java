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
import static controller.usersurvey.UserSurveyConstants.YES;
import static controller.usersurvey.UserSurveyConstants.NO;
import static controller.usersurvey.UserSurveyConstants.DOES_NOT_MATTER;

public class UserRoommateSmokingHabitsPreference implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserRoommateGenderPreference.class);

    UserSurveyModel userSurveyModel;
    int userRoommateSmokingHabitsInput;
    boolean hasValidValue = false;
    String userRoommateSmokingHabits;

    public UserRoommateSmokingHabitsPreference(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserRoommateSmokingHabitsPreference(UserSurveyModel userSurveyModel, int userRoommateSmokingHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userRoommateSmokingHabitsInput = userRoommateSmokingHabitsInput;
    }

    //get roommate smoking habit preference input
    @Override
    public void getValue() {
        UserRoommateAlcoholHabitsPreference userRoommateAlcoholHabitsPreference = new UserRoommateAlcoholHabitsPreference(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.smoking.habits.message"));
            userRoommateSmokingHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("roommate smoking habit preference input: " + userRoommateSmokingHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userRoommateAlcoholHabitsPreference.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.smoking.habits.message"));
                    userRoommateSmokingHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate roommate smoking habit preference input
    @Override
    public boolean validateValue() {
        boolean validateSmokingHabitsResponse = false;
        try {
            logger.info("validating roommate smoking habit preference input");
            if (userRoommateSmokingHabitsInput == ONE) {
                validateSmokingHabitsResponse = true;
                userRoommateSmokingHabits = YES;
                setValue();
            } else if (userRoommateSmokingHabitsInput == TWO) {
                validateSmokingHabitsResponse = true;
                userRoommateSmokingHabits = NO;
                setValue();
            } else if (userRoommateSmokingHabitsInput == THREE) {
                validateSmokingHabitsResponse = true;
                userRoommateSmokingHabits = DOES_NOT_MATTER;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.roommate.smoking.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.roommate.smoking.habits.message"));
        }
        return validateSmokingHabitsResponse;
    }

    //set roommate smoking habit preference
    @Override
    public void setValue() {
        userSurveyModel.setRoommateSmokingHabits(userRoommateSmokingHabits);
        logger.info("roommate smoking habit preference is set to: " + userRoommateSmokingHabits);
    }
}

