package commandline;

public class UserSurveyCLI {

    public void printTakeSurveyMessage() {
        System.out.println("Please take the below survey to complete your profile:");
    }

    public void printInvalidInputMessage() {
        System.out.println("Invalid Input. Please enter a valid input.");
    }

    public void printUserPersonalDetailsInputMessage() {
        System.out.println("Personal Details:");
    }

    public void printUserGenderInputMessage() {
        System.out.println("Gender: 1. Male 2. Female 3. Other");
    }

    public void printUserFoodHabitsInputMessage() {
        System.out.println("Food habits: 1. Veg 2. Non-Veg 3. Vegan");
    }

    public void printUserSmokingHabitsInputMessage() {
        System.out.println("Smoking? 1. Yes 2. No");
    }

    public void printUserAlcoholHabitsInputMessage() {
        System.out.println("Alcohol? 1. Yes 2. No");
    }

    public void printUserBudgetInputMessage() {
        System.out.println("Please enter your budget in CAD:");
    }

    public void printUsersProximityFromDalhousieUniversityInputMessage() {
        System.out.println("How close(in KM) would you like to stay to Dalhousie University");
    }

    public void printRoommatePreferenceDetailsInputMessage() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Roommate Preferences:");
    }

    public void printRoommateGenderPreferenceInputMessage() {
        System.out.println("Gender: 1. Male 2. Female 3. Does not matter");
    }

    public void printRoommateFoodHabitsPreferenceInputMessage() {
        System.out.println("Food habits: 1. Veg 2. Non-Veg 3. Vegan");
    }

    public void printRoommateSmokingHabitsPreferenceInputMessage() {
        System.out.println("Smoking? 1. Yes 2. No 3. Does not matter");
    }

    public void printRoommateAlcoholHabitsPreferenceInputMessage() {
        System.out.println("Alcohol? 1. Yes 2. No 3. Does not matter");
    }

    public void printUserSurveyCompletionMessage() {
        System.out.println("Thanks for taking the survey. Your profile has been completed successfully");
    }
}
