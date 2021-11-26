package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.UserSurveyDAO;
import models.UserSurveyModel;

import java.util.InputMismatchException;
import java.util.Scanner;

import static controller.UserSurveyConstants.ZERO;
import static controller.UserSurveyConstants.ONE;
import static controller.UserSurveyConstants.TWO;
import static controller.UserSurveyConstants.THREE;
import static controller.UserSurveyConstants.FOUR;
import static controller.UserSurveyConstants.MALE;
import static controller.UserSurveyConstants.FEMALE;
import static controller.UserSurveyConstants.OTHER;
import static controller.UserSurveyConstants.VEG;
import static controller.UserSurveyConstants.NON_VEG;
import static controller.UserSurveyConstants.VEGAN;
import static controller.UserSurveyConstants.YES;
import static controller.UserSurveyConstants.NO;
import static controller.UserSurveyConstants.DOES_NOT_MATTER;

public class UserSurveyController {

    UserSurveyModel userSurveyModel = new UserSurveyModel();
    UserSurveyDAO userSurveyDAO = new UserSurveyDAO();
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    Scanner input = new Scanner(System.in);

    public void takeSurvey(String emailId) {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.take.survey.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.personal.details.message"));
            userSurveyModel.setUserId(emailId);
            setUserGender();
            setUserFoodHabits();
            setUserSmokingHabits();
            setUserAlcoholHabits();
            setUserBudget();
            setUsersProximityToDalhousieUniversity();
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.roommate.division.preferences.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.preference.details.message"));
            setRoommateGenderPreference();
            setRoommateFoodHabitsPreference();
            setRoommateSmokingHabitsPreference();
            setRoommateAlcoholHabitsPreference();
            userSurveyDAO.insertUserPersonalDetails(userSurveyModel);
            userSurveyDAO.insertRoommatePreferenceDetails(userSurveyModel);
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.profile.creation.message"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserGender() {
        String userGender;
        int userGenderInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.gender.message"));
            userGenderInput = input.nextInt();
            while (userGenderInput <= ZERO || userGenderInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.gender.message"));
                userGenderInput = input.nextInt();
            }
            if (userGenderInput == ONE) {
                userGender = MALE;
            } else if (userGenderInput == TWO) {
                userGender = FEMALE;
            } else {
                userGender = OTHER;
            }
            userSurveyModel.setUserGender(userGender);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUserGender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserFoodHabits() {
        String userFoodHabits;
        int userFoodHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.food.habits.message"));
            userFoodHabitsInput = input.nextInt();
            while (userFoodHabitsInput <= ZERO || userFoodHabitsInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.food.habits.message"));
                userFoodHabitsInput = input.nextInt();
            }
            if (userFoodHabitsInput == ONE) {
                userFoodHabits = VEG;
            } else if (userFoodHabitsInput == TWO) {
                userFoodHabits = NON_VEG;
            } else {
                userFoodHabits = VEGAN;
            }
            userSurveyModel.setUserFoodHabits(userFoodHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUserFoodHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserSmokingHabits() {
        String smokingHabits;
        int smokingHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.smoking.habits.message"));
            smokingHabitsInput = input.nextInt();
            while (smokingHabitsInput <= ZERO || smokingHabitsInput >= THREE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.smoking.habits.message"));
                smokingHabitsInput = input.nextInt();
            }
            if (smokingHabitsInput == ONE) {
                smokingHabits = YES;
            } else {
                smokingHabits = NO;
            }
            userSurveyModel.setUserSmokingHabits(smokingHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUserSmokingHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserAlcoholHabits() {
        String alcoholHabits;
        int alcoholHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.alcohol.habits.message"));
            alcoholHabitsInput = input.nextInt();
            while (alcoholHabitsInput <= ZERO || alcoholHabitsInput >= THREE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.alcohol.habits.message"));
                alcoholHabitsInput = input.nextInt();
            }
            if (alcoholHabitsInput == ONE) {
                alcoholHabits = YES;
            } else {
                alcoholHabits = NO;
            }
            userSurveyModel.setUserAlcoholHabits(alcoholHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUserAlcoholHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserBudget() {
        int userBudget;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.budget.message"));
            userBudget = input.nextInt();
            while (userBudget <= ZERO) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.budget.message"));
                userBudget = input.nextInt();
            }
            userSurveyModel.setUserBudget(userBudget);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUserBudget();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUsersProximityToDalhousieUniversity() {
        int dalProximity;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.proximity.dalhousie.university.message"));
            dalProximity = input.nextInt();
            while (dalProximity <= ZERO) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.user.proximity.dalhousie.university.message"));
                dalProximity = input.nextInt();
            }
            userSurveyModel.setUserDalDistance(dalProximity);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setUsersProximityToDalhousieUniversity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRoommateGenderPreference() {
        String roommateGender;
        int roommateGenderInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.gender.preferences.message"));
            roommateGenderInput = input.nextInt();
            while (roommateGenderInput <= ZERO || roommateGenderInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.gender.preferences.message"));
                roommateGenderInput = input.nextInt();
            }
            if (roommateGenderInput == ONE) {
                roommateGender = MALE;
            } else if (roommateGenderInput == TWO) {
                roommateGender = FEMALE;
            } else {
                roommateGender = DOES_NOT_MATTER;
            }
            userSurveyModel.setRoommateGender(roommateGender);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setRoommateGenderPreference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRoommateFoodHabitsPreference() {
        String roommateFoodHabits;
        int roommateFoodHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.food.habits.message"));
            roommateFoodHabitsInput = input.nextInt();
            while (roommateFoodHabitsInput <= ZERO || roommateFoodHabitsInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.food.habits.message"));
                roommateFoodHabitsInput = input.nextInt();
            }
            if (roommateFoodHabitsInput == ONE) {
                roommateFoodHabits = VEG;
            } else if (roommateFoodHabitsInput == TWO) {
                roommateFoodHabits = NON_VEG;
            } else {
                roommateFoodHabits = VEGAN;
            }
            userSurveyModel.setRoommateFoodHabits(roommateFoodHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setRoommateFoodHabitsPreference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRoommateSmokingHabitsPreference() {
        String roommateSmokingHabits;
        int roommateSmokingHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.smoking.habits.message"));
            roommateSmokingHabitsInput = input.nextInt();
            while (roommateSmokingHabitsInput <= ZERO || roommateSmokingHabitsInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.smoking.habits.message"));
                roommateSmokingHabitsInput = input.nextInt();
            }
            if (roommateSmokingHabitsInput == ONE) {
                roommateSmokingHabits = YES;
            } else if (roommateSmokingHabitsInput == TWO) {
                roommateSmokingHabits = NO;
            } else {
                roommateSmokingHabits = DOES_NOT_MATTER;
            }
            userSurveyModel.setRoommateSmokingHabits(roommateSmokingHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setRoommateSmokingHabitsPreference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRoommateAlcoholHabitsPreference() {
        String roommateAlcoholHabits;
        int roommateAlcoholHabitsInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.alcohol.habits.message"));
            roommateAlcoholHabitsInput = input.nextInt();
            while (roommateAlcoholHabitsInput <= ZERO || roommateAlcoholHabitsInput >= FOUR) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.roommate.alcohol.habits.message"));
                roommateAlcoholHabitsInput = input.nextInt();
            }
            if (roommateAlcoholHabitsInput == ONE) {
                roommateAlcoholHabits = YES;
            } else if (roommateAlcoholHabitsInput == TWO) {
                roommateAlcoholHabits = NO;
            } else {
                roommateAlcoholHabits = DOES_NOT_MATTER;
            }
            userSurveyModel.setRoommateAlcoholHabits(roommateAlcoholHabits);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.survey.invalid.input.message"));
            input.nextLine();
            setRoommateAlcoholHabitsPreference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}