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

public class UserRoommateFoodHabitsPreference implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserRoommateFoodHabitsPreference.class);

    UserSurveyModel userSurveyModel;
    int userRoommateFoodHabitsInput;
    boolean hasValidValue = false;
    String userRoommateFoodHabits;

    public UserRoommateFoodHabitsPreference(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserRoommateFoodHabitsPreference(UserSurveyModel userSurveyModel, int userRoommateFoodHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userRoommateFoodHabitsInput = userRoommateFoodHabitsInput;
    }

    //get roommate food habit preference input
    @Override
    public void getValue() {
        UserRoommateSmokingHabitsPreference userRoommateSmokingHabitsPreference = new UserRoommateSmokingHabitsPreference(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.food.habits.message"));
            userRoommateFoodHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("roommate food habit preference input: "+userRoommateFoodHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userRoommateSmokingHabitsPreference.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.food.habits.message"));
                    userRoommateFoodHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate roommate food habit preference input
    @Override
    public boolean validateValue() {
        boolean validateFoodHabitsResponse = false;
        try {
            logger.info("Validating roommate food habit preference input");
            if (userRoommateFoodHabitsInput == ONE) {
                validateFoodHabitsResponse = true;
                userRoommateFoodHabits = VEG;
                setValue();
            } else if (userRoommateFoodHabitsInput == TWO) {
                validateFoodHabitsResponse = true;
                userRoommateFoodHabits = NON_VEG;
                setValue();
            } else if (userRoommateFoodHabitsInput == THREE) {
                validateFoodHabitsResponse = true;
                userRoommateFoodHabits = VEGAN;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.food.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.food.habits.message"));
        }
        return validateFoodHabitsResponse;
    }

    //set roommate food habit preference
    @Override
    public void setValue() {
        userSurveyModel.setRoommateFoodHabits(userRoommateFoodHabits);
        logger.info("roommate food habit preference is set to: "+userRoommateFoodHabits);
    }

}
