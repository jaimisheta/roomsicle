package controller;

import commandline.UserSurveyCLI;
import database.UserSurveyDAO;
import models.UserSurveyModel;

import java.util.Scanner;

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
            while (userGenderInput != 1 && userGenderInput != 2 && userGenderInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                userGenderInput = input.nextInt();
            }
            if (userGenderInput == 1) {
                userGender = "Male";
            } else if (userGenderInput == 2) {
                userGender = "Female";
            } else {
                userGender = "Other";
            }
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
            while (userFoodHabitsInput != 1 && userFoodHabitsInput != 2 && userFoodHabitsInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                userFoodHabitsInput = input.nextInt();
            }
            if (userFoodHabitsInput == 1) {
                userFoodHabits = "Veg";
            } else if (userFoodHabitsInput == 2) {
                userFoodHabits = "Non-Veg";
            } else {
                userFoodHabits = "Vegan";
            }
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
            while (smokingHabitsInput != 1 && smokingHabitsInput != 2) {
                userSurveyCLI.printInvalidInputMessage();
                smokingHabitsInput = input.nextInt();
            }
            if (smokingHabitsInput == 1) {
                smokingHabits = 1;
            }
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
            while (alcoholHabitsInput != 1 && alcoholHabitsInput != 2) {
                userSurveyCLI.printInvalidInputMessage();
                alcoholHabitsInput = input.nextInt();
            }
            if (alcoholHabitsInput == 1) {
                alcoholHabits = 1;
            }
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
            while (userBudget <= 0) {
                userSurveyCLI.printInvalidInputMessage();
                userBudget = input.nextInt();
            }
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
            while (dalProximity <= 0) {
                userSurveyCLI.printInvalidInputMessage();
                dalProximity = input.nextInt();
            }
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
            while (roommateGenderInput != 1 && roommateGenderInput != 2 && roommateGenderInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                roommateGenderInput = input.nextInt();
            }
            if (roommateGenderInput == 1) {
                roommateGender = "Male";
            } else if (roommateGenderInput == 2) {
                roommateGender = "Female";
            } else {
                roommateGender = "Does not matter";
            }
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
            while (roommateFoodHabitsInput != 1 && roommateFoodHabitsInput != 2 && roommateFoodHabitsInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                roommateFoodHabitsInput = input.nextInt();
            }
            if (roommateFoodHabitsInput == 1) {
                roommateFoodHabits = "Veg";
            } else if (roommateFoodHabitsInput == 2) {
                roommateFoodHabits = "Non-Veg";
            } else {
                roommateFoodHabits = "Vegan";
            }
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
            while (roommateSmokingHabitsInput != 1 && roommateSmokingHabitsInput != 2 && roommateSmokingHabitsInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                roommateSmokingHabitsInput = input.nextInt();
            }
            if (roommateSmokingHabitsInput == 1) {
                roommateSmokingHabits = "Yes";
            } else if (roommateSmokingHabitsInput == 2) {
                roommateSmokingHabits = "No";
            } else {
                roommateSmokingHabits = "Does not matter";
            }
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
            while (roommateAlcoholHabitsInput != 1 && roommateAlcoholHabitsInput != 2 && roommateAlcoholHabitsInput != 3) {
                userSurveyCLI.printInvalidInputMessage();
                roommateAlcoholHabitsInput = input.nextInt();
            }
            if (roommateAlcoholHabitsInput == 1) {
                roommateAlcoholHabits = "Yes";
            } else if (roommateAlcoholHabitsInput == 2) {
                roommateAlcoholHabits = "No";
            } else {
                roommateAlcoholHabits = "Does not matter";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roommateAlcoholHabits;
    }
}
