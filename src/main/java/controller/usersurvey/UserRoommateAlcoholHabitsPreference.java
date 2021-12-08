package controller.usersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.OwnerSurveyDAO;
import database.UserSurveyDAO;
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

public class UserRoommateAlcoholHabitsPreference implements IUserSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    UserSurveyDAO userSurveyDAO = new UserSurveyDAO();
    static final Logger logger = LogManager.getLogger(UserRoommateAlcoholHabitsPreference.class);

    UserSurveyModel userSurveyModel;
    int userRoommateAlcoholHabitsInput;
    boolean hasValidValue = false;
    String userRoommateAlcoholHabits;

    public UserRoommateAlcoholHabitsPreference(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    public UserRoommateAlcoholHabitsPreference(UserSurveyModel userSurveyModel, int userRoommateAlcoholHabitsInput) {
        this.userSurveyModel = userSurveyModel;
        this.userRoommateAlcoholHabitsInput = userRoommateAlcoholHabitsInput;
    }

    //get roommate alcohol preference input
    @Override
    public void getValue() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.alcohol.habits.message"));
            userRoommateAlcoholHabitsInput = roomsicleCLI.getNumberResponse();
            logger.info("roommate alcohol preference input: "+userRoommateAlcoholHabitsInput);
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    userSurveyDAO.insertUserPersonalDetails(userSurveyModel);
                    userSurveyDAO.insertRoommatePreferenceDetails(userSurveyModel);
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.profile.creation.message"));
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.alcohol.habits.message"));
                    userRoommateAlcoholHabitsInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validate roommate alcohol preference input
    @Override
    public boolean validateValue() {
        boolean validateAlcoholHabitsResponse = false;
        try {
            logger.info("Validating roommate alcohol preference input");
            if (userRoommateAlcoholHabitsInput == ONE) {
                validateAlcoholHabitsResponse = true;
                userRoommateAlcoholHabits = YES;
                setValue();
            } else if (userRoommateAlcoholHabitsInput == TWO) {
                validateAlcoholHabitsResponse = true;
                userRoommateAlcoholHabits = NO;
                setValue();
            } else if (userRoommateAlcoholHabitsInput == THREE) {
                validateAlcoholHabitsResponse = true;
                userRoommateAlcoholHabits = DOES_NOT_MATTER;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.roommate.alcohol.habits.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.illegal.argument.exception.roommate.alcohol.habits.message"));
        }
        return validateAlcoholHabitsResponse;
    }

    //set roommate alcohol preference
    @Override
    public void setValue() {
        userSurveyModel.setRoommateAlcoholHabits(userRoommateAlcoholHabits);
        logger.info("roommate alcohol preference is set to: "+userRoommateAlcoholHabits);
    }


}

