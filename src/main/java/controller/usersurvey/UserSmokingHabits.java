package controller.usersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.UserSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.usersurvey.UserSurveyConstants.ONE;
import static controller.usersurvey.UserSurveyConstants.TWO;
import static controller.usersurvey.UserSurveyConstants.YES;
import static controller.usersurvey.UserSurveyConstants.NO;

public class UserSmokingHabits implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserRoommateGenderPreference.class);

    UserSurveyModel userSurveyModel;
    int userSmokingHabitsInput;
    boolean hasValidValue = false;
    String userSmokingHabits;

    public UserSmokingHabits(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserSmokingHabits(UserSurveyModel userSurveyModel, int userSmokingHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userSmokingHabitsInput = userSmokingHabitsInput;
    }

    //get user smoking habit preference input
    @Override
    public void getValue() {
        UserAlcoholHabits userAlcoholHabits = new UserAlcoholHabits(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.smoking.habits.message"));
            userSmokingHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("user smoking habit preference input: " + userSmokingHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userAlcoholHabits.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.smoking.habits.message"));
                    userSmokingHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate user smoking habit preference input
    @Override
    public boolean validateValue() {
        boolean validateSmokingHabitsResponse = false;
        try {
            logger.info("validating user smoking habit preference input: " + userSmokingHabitsInput);
            if (userSmokingHabitsInput == ONE) {
                validateSmokingHabitsResponse = true;
                userSmokingHabits = YES;
                setValue();
            } else if (userSmokingHabitsInput == TWO) {
                validateSmokingHabitsResponse = true;
                userSmokingHabits = NO;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.smoking.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.smoking.habits.message"));
        }
        return validateSmokingHabitsResponse;
    }

    //get user smoking habit preference input
    @Override
    public void setValue() {
        userSurveyModel.setUserSmokingHabits(userSmokingHabits);
        logger.info("user smoking habit preference is set to: " + userSmokingHabits);
    }
}
