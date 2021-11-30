package controller.usersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.UserSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;

public class UserBudget implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserBudget.class);

    UserSurveyModel userSurveyModel;
    boolean hasValidValue = false;
    int userBudget;

    public UserBudget(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserBudget(UserSurveyModel userSurveyModel, int userBudget) {
        this.userSurveyModel = userSurveyModel;
        this.userBudget = userBudget;
    }

    //get budget value from user
    @Override
    public void getValue() {
        UserUniversityDistancePreference userUniversityDistancePreference = new UserUniversityDistancePreference(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.budget.message"));
            userBudget = roomsicleCLI.getNumberResponse();
            logger.info("userBudget: "+userBudget);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userUniversityDistancePreference.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.budget.message"));
                    userBudget = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate budget value input from user
    @Override
    public boolean validateValue() {
        boolean validateUserBudget = false;
        try {
            logger.info("validating user input for user Budget: "+userBudget);
            if (userBudget >= ONE) {
                validateUserBudget = true;
                logger.info("valid user budget input");
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.user.budget.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.user.budget.message"));
        }
        return validateUserBudget;
    }

    //set budget value
    @Override
    public void setValue() {
        userSurveyModel.setUserBudget(userBudget);
        logger.info("user budget is set to: "+userBudget);
    }
}
