package controller;

import commandline.UserSurveyCLI;
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

    UserSurveyCLI userSurveyCLI = new UserSurveyCLI();
    UserSurveyModel userSurveyModel = new UserSurveyModel();
    UserSurveyDAO userSurveyDAO = new UserSurveyDAO();
    Scanner input = new Scanner(System.in);

    public void takeSurvey(String emailId) {
        try {
            userSurveyCLI.printTakeSurveyMessage();
            userSurveyCLI.printUserPersonalDetailsInputMessage();
            userSurveyModel.setUserId(emailId);
            setUserGender();
            setUserFoodHabits();
            setUserSmokingHabits();
            setUserAlcoholHabits();
            setUserBudget();
            setUsersProximityToDalhousieUniversity();
            userSurveyCLI.printRoommatePreferenceDetailsInputMessage();
            setRoommateGenderPreference();
            setRoommateFoodHabitsPreference();
            setRoommateSmokingHabitsPreference();
            setRoommateAlcoholHabitsPreference();
            userSurveyDAO.insertUserPersonalDetails(userSurveyModel);
            userSurveyDAO.insertRoommatePreferenceDetails(userSurveyModel);
            userSurveyCLI.printUserSurveyCompletionMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserGender() {
        String userGender;
        int userGenderInput;
        try {
            userSurveyCLI.printUserGenderInputMessage();
            userGenderInput = input.nextInt();
            while (userGenderInput <= ZERO || userGenderInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUserGenderInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
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
            userSurveyCLI.printUserFoodHabitsInputMessage();
            userFoodHabitsInput = input.nextInt();
            while (userFoodHabitsInput <= ZERO || userFoodHabitsInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUserFoodHabitsInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setUserFoodHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserSmokingHabits() {
        int smokingHabits = 0;
        int smokingHabitsInput;
        try {
            userSurveyCLI.printUserSmokingHabitsInputMessage();
            smokingHabitsInput = input.nextInt();
            while (smokingHabitsInput <= ZERO || smokingHabitsInput >= THREE) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUserSmokingHabitsInputMessage();
                smokingHabitsInput = input.nextInt();
            }
            if (smokingHabitsInput == ONE) {
                smokingHabits = ONE;
            }
            userSurveyModel.setUserSmokingHabits(smokingHabits);
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setUserSmokingHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserAlcoholHabits() {
        int alcoholHabits = 0;
        int alcoholHabitsInput;
        try {
            userSurveyCLI.printUserAlcoholHabitsInputMessage();
            alcoholHabitsInput = input.nextInt();
            while (alcoholHabitsInput <= ZERO || alcoholHabitsInput >= THREE) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUserAlcoholHabitsInputMessage();
                alcoholHabitsInput = input.nextInt();
            }
            if (alcoholHabitsInput == ONE) {
                alcoholHabits = ONE;
            }
            userSurveyModel.setUserAlcoholHabits(alcoholHabits);
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setUserAlcoholHabits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserBudget() {
        int userBudget;
        try {
            userSurveyCLI.printUserBudgetInputMessage();
            userBudget = input.nextInt();
            while (userBudget <= ZERO) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUserBudgetInputMessage();
                userBudget = input.nextInt();
            }
            userSurveyModel.setUserBudget(userBudget);
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setUserBudget();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUsersProximityToDalhousieUniversity() {
        int dalProximity;
        try {
            userSurveyCLI.printUsersProximityFromDalhousieUniversityInputMessage();
            dalProximity = input.nextInt();
            while (dalProximity <= ZERO) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printUsersProximityFromDalhousieUniversityInputMessage();
                dalProximity = input.nextInt();
            }
            userSurveyModel.setUserDalDistance(dalProximity);
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
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
            userSurveyCLI.printRoommateGenderPreferenceInputMessage();
            roommateGenderInput = input.nextInt();
            while (roommateGenderInput <= ZERO || roommateGenderInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printRoommateGenderPreferenceInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
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
            userSurveyCLI.printRoommateFoodHabitsPreferenceInputMessage();
            roommateFoodHabitsInput = input.nextInt();
            while (roommateFoodHabitsInput <= ZERO || roommateFoodHabitsInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printRoommateFoodHabitsPreferenceInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
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
            userSurveyCLI.printRoommateSmokingHabitsPreferenceInputMessage();
            roommateSmokingHabitsInput = input.nextInt();
            while (roommateSmokingHabitsInput <= ZERO || roommateSmokingHabitsInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printRoommateSmokingHabitsPreferenceInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
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
            userSurveyCLI.printRoommateAlcoholHabitsPreferenceInputMessage();
            roommateAlcoholHabitsInput = input.nextInt();
            while (roommateAlcoholHabitsInput <= ZERO || roommateAlcoholHabitsInput >= FOUR) {
                userSurveyCLI.printInvalidInputMessage();
                userSurveyCLI.printRoommateAlcoholHabitsPreferenceInputMessage();
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
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setRoommateAlcoholHabitsPreference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}