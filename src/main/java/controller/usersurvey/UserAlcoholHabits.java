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

public class UserAlcoholHabits implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

    UserSurveyModel userSurveyModel;
    int userAlcoholHabitsInput;
    boolean hasValidValue = false;
    String userAlcoholHabits;

    public UserAlcoholHabits(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserAlcoholHabits(UserSurveyModel userSurveyModel, int userAlcoholHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userAlcoholHabitsInput = userAlcoholHabitsInput;
    }

    //get alcohol habits input from user
    @Override
    public void getValue() {
        UserBudget userBudget = new UserBudget(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.alcohol.habits.message"));
            userAlcoholHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("userAlcoholHabitsInput:" + userAlcoholHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userBudget.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.alcohol.habits.message"));
                    userAlcoholHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate alcohol habits input from user
    @Override
    public boolean validateValue() {
        boolean validateAlcoholHabitsResponse = false;
        try {
            logger.info("Validating alcohol habits user input: " + userAlcoholHabitsInput);
            if (userAlcoholHabitsInput == ONE) {
                validateAlcoholHabitsResponse = true;
                userAlcoholHabits = YES;
                setValue();
            } else if (userAlcoholHabitsInput == TWO) {
                validateAlcoholHabitsResponse = true;
                userAlcoholHabits = NO;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.alcohol.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.alcohol.habits.message"));
        }
        return validateAlcoholHabitsResponse;
    }

    //set alcohol habit of user
    @Override
    public void setValue() {
        userSurveyModel.setUserAlcoholHabits(userAlcoholHabits);
        logger.info("user alcohol habit is set");
    }


}
