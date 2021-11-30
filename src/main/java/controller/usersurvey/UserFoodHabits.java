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
import static controller.usersurvey.UserSurveyConstants.VEG;
import static controller.usersurvey.UserSurveyConstants.NON_VEG;
import static controller.usersurvey.UserSurveyConstants.VEGAN;

public class UserFoodHabits implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserFoodHabits.class);

    UserSurveyModel userSurveyModel;
    int userFoodHabitsInput;
    boolean hasValidValue = false;
    String userFoodHabits;

    public UserFoodHabits(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserFoodHabits(UserSurveyModel userSurveyModel, int userFoodHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userFoodHabitsInput = userFoodHabitsInput;
    }

    //get user food habits input
    @Override
    public void getValue() {
        UserSmokingHabits userSmokingHabits = new UserSmokingHabits(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.food.habits.message"));
            userFoodHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("User food habit input: "+userFoodHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userSmokingHabits.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.food.habits.message"));
                    userFoodHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate user food habits input
    @Override
    public boolean validateValue() {
        boolean validateFoodHabitsResponse = false;
        try {
            logger.info("validating user food habits input");
            if (userFoodHabitsInput == ONE) {
                validateFoodHabitsResponse = true;
                userFoodHabits = VEG;
                setValue();
            } else if (userFoodHabitsInput == TWO) {
                validateFoodHabitsResponse = true;
                userFoodHabits = NON_VEG;
                setValue();
            } else if (userFoodHabitsInput == THREE) {
                validateFoodHabitsResponse = true;
                userFoodHabits = VEGAN;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.food.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.food.habits.message"));
        }
        return validateFoodHabitsResponse;
    }

    //set user food habit
    @Override
    public void setValue() {
        userSurveyModel.setUserFoodHabits(userFoodHabits);
        logger.info("set user food habits input to: "+userFoodHabits);

    }
}
