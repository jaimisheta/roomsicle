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
            userSurveyModel.setUserGender(getUserGenderFromUser());
            userSurveyModel.setUserFoodHabits(getUserFoodHabitsFromUser());
            userSurveyModel.setUserSmokingHabits(getUserSmokingHabitsFromUser());
            userSurveyModel.setUserAlcoholHabits(getUserAlcoholHabitsFromUser());
            userSurveyModel.setUserBudget(getUserBudgetFromUser());
            userSurveyModel.setUserDalDistance(getUsersProximityToDalhousieUniversityFromUser());
            userSurveyCLI.printRoommatePreferenceDetailsInputMessage();
            userSurveyModel.setRoommateGender(getRoommateGenderPreferenceFromUser());
            userSurveyModel.setRoommateFoodHabits(getRoommateFoodHabitsPreferenceFromUser());
            userSurveyModel.setRoommateSmokingHabits(getRoommateSmokingHabitsPreferenceFromUser());
            userSurveyModel.setRoommateAlcoholHabits(getRoommateAlcoholHabitsPreferenceFromUser());
            userSurveyDAO.insertUserPersonalDetails(userSurveyModel);
            userSurveyDAO.insertRoommatePreferenceDetails(userSurveyModel);
            userSurveyCLI.printUserSurveyCompletionMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserGenderFromUser() {
        String userGender = null;
        int userGenderInput;
        try {
            userSurveyCLI.printUserGenderInputMessage();
            userGenderInput = input.nextInt();
            while (userGenderInput != ONE && userGenderInput != TWO && userGenderInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                userGenderInput = input.nextInt();
            }
            if (userGenderInput == ONE) {
                userGender = MALE;
            } else if (userGenderInput == TWO) {
                userGender = FEMALE;
            } else {
                userGender = OTHER;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUserGenderFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userGender;
    }

    public String getUserFoodHabitsFromUser() {
        String userFoodHabits = null;
        int userFoodHabitsInput;
        try {
            userSurveyCLI.printUserFoodHabitsInputMessage();
            userFoodHabitsInput = input.nextInt();
            while (userFoodHabitsInput != ONE && userFoodHabitsInput != TWO && userFoodHabitsInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                userFoodHabitsInput = input.nextInt();
            }
            if (userFoodHabitsInput == ONE) {
                userFoodHabits = VEG;
            } else if (userFoodHabitsInput == TWO) {
                userFoodHabits = NON_VEG;
            } else {
                userFoodHabits = VEGAN;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUserFoodHabitsFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userFoodHabits;
    }

    public int getUserSmokingHabitsFromUser() {
        int smokingHabits = 0;
        int smokingHabitsInput;
        try {
            userSurveyCLI.printUserSmokingHabitsInputMessage();
            smokingHabitsInput = input.nextInt();
            while (smokingHabitsInput != ONE && smokingHabitsInput != TWO) {
                userSurveyCLI.printInvalidInputMessage();
                smokingHabitsInput = input.nextInt();
            }
            if (smokingHabitsInput == ONE) {
                smokingHabits = ONE;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUserSmokingHabitsFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smokingHabits;
    }

    public int getUserAlcoholHabitsFromUser() {
        int alcoholHabits = 0;
        int alcoholHabitsInput;
        try {
            userSurveyCLI.printUserAlcoholHabitsInputMessage();
            alcoholHabitsInput = input.nextInt();
            while (alcoholHabitsInput != ONE && alcoholHabitsInput != TWO) {
                userSurveyCLI.printInvalidInputMessage();
                alcoholHabitsInput = input.nextInt();
            }
            if (alcoholHabitsInput == ONE) {
                alcoholHabits = ONE;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUserAlcoholHabitsFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alcoholHabits;
    }

    public int getUserBudgetFromUser() {
        int userBudget = 0;
        try {
            userSurveyCLI.printUserBudgetInputMessage();
            userBudget = input.nextInt();
            while (userBudget <= ZERO) {
                userSurveyCLI.printInvalidInputMessage();
                userBudget = input.nextInt();
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUserBudgetFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBudget;
    }

    public int getUsersProximityToDalhousieUniversityFromUser() {
        int dalProximity = 0;
        try {
            userSurveyCLI.printUsersProximityFromDalhousieUniversityInputMessage();
            dalProximity = input.nextInt();
            while (dalProximity <= ZERO) {
                userSurveyCLI.printInvalidInputMessage();
                dalProximity = input.nextInt();
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getUsersProximityToDalhousieUniversityFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dalProximity;
    }


    public String getRoommateGenderPreferenceFromUser() {
        String roommateGender = null;
        int roommateGenderInput;
        try {
            userSurveyCLI.printRoommateGenderPreferenceInputMessage();
            roommateGenderInput = input.nextInt();
            while (roommateGenderInput != ONE && roommateGenderInput != TWO && roommateGenderInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                roommateGenderInput = input.nextInt();
            }
            if (roommateGenderInput == ONE) {
                roommateGender = MALE;
            } else if (roommateGenderInput == TWO) {
                roommateGender = FEMALE;
            } else {
                roommateGender = DOES_NOT_MATTER;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getRoommateGenderPreferenceFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roommateGender;
    }

    public String getRoommateFoodHabitsPreferenceFromUser() {
        String roommateFoodHabits = null;
        int roommateFoodHabitsInput;
        try {
            userSurveyCLI.printRoommateFoodHabitsPreferenceInputMessage();
            roommateFoodHabitsInput = input.nextInt();
            while (roommateFoodHabitsInput != ONE && roommateFoodHabitsInput != TWO && roommateFoodHabitsInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                roommateFoodHabitsInput = input.nextInt();
            }
            if (roommateFoodHabitsInput == ONE) {
                roommateFoodHabits = VEG;
            } else if (roommateFoodHabitsInput == TWO) {
                roommateFoodHabits = NON_VEG;
            } else {
                roommateFoodHabits = VEGAN;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getRoommateFoodHabitsPreferenceFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roommateFoodHabits;
    }

    public String getRoommateSmokingHabitsPreferenceFromUser() {
        String roommateSmokingHabits = null;
        int roommateSmokingHabitsInput;
        try {
            userSurveyCLI.printRoommateSmokingHabitsPreferenceInputMessage();
            roommateSmokingHabitsInput = input.nextInt();
            while (roommateSmokingHabitsInput != ONE && roommateSmokingHabitsInput != TWO && roommateSmokingHabitsInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                roommateSmokingHabitsInput = input.nextInt();
            }
            if (roommateSmokingHabitsInput == ONE) {
                roommateSmokingHabits = YES;
            } else if (roommateSmokingHabitsInput == TWO) {
                roommateSmokingHabits = NO;
            } else {
                roommateSmokingHabits = DOES_NOT_MATTER;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getRoommateSmokingHabitsPreferenceFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roommateSmokingHabits;
    }

    public String getRoommateAlcoholHabitsPreferenceFromUser() {
        String roommateAlcoholHabits = null;
        int roommateAlcoholHabitsInput;
        try {
            userSurveyCLI.printRoommateAlcoholHabitsPreferenceInputMessage();
            roommateAlcoholHabitsInput = input.nextInt();
            while (roommateAlcoholHabitsInput != ONE && roommateAlcoholHabitsInput != TWO && roommateAlcoholHabitsInput != THREE) {
                userSurveyCLI.printInvalidInputMessage();
                roommateAlcoholHabitsInput = input.nextInt();
            }
            if (roommateAlcoholHabitsInput == ONE) {
                roommateAlcoholHabits = YES;
            } else if (roommateAlcoholHabitsInput == TWO) {
                roommateAlcoholHabits = NO;
            } else {
                roommateAlcoholHabits = DOES_NOT_MATTER;
            }
        } catch (InputMismatchException e) {
            userSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            getRoommateAlcoholHabitsPreferenceFromUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roommateAlcoholHabits;
    }
}
