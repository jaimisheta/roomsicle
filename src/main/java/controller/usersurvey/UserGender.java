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
import static controller.usersurvey.UserSurveyConstants.OTHER;

public class UserGender implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserGender.class);

    UserSurveyModel userSurveyModel;
    int userGenderInput;
    boolean hasValidValue = false;
    String userGender;

    public UserGender(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserGender(UserSurveyModel userSurveyModel, int userGenderInput) {
        this.userSurveyModel = userSurveyModel;
        this.userGenderInput = userGenderInput;
    }

    //get user gender input
    @Override
    public void getValue() {
        UserFoodHabits userFoodHabits = new UserFoodHabits(userSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.take.survey.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.personal.details.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.gender.message"));
            userGenderInput = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userFoodHabits.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.gender.message"));
                    userGenderInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate user gender input
    @Override
    public boolean validateValue() {
        boolean validateGenderResponse = false;
        try {
            logger.info("Validating user gender input");
            if (userGenderInput == ONE) {
                validateGenderResponse = true;
                userGender = MALE;
                setValue();
            } else if (userGenderInput == TWO) {
                validateGenderResponse = true;
                userGender = FEMALE;
                setValue();
            } else if (userGenderInput == THREE) {
                validateGenderResponse = true;
                userGender = OTHER;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.gender.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.gender.message"));
        }
        return validateGenderResponse;
    }

    //set user gender
    @Override
    public void setValue() {
        userSurveyModel.setUserGender(userGender);
        logger.info("User gender is set to: "+userGender);
    }
}
