package commandline;

public class OwnerSurveyCLI {
    public void printTakeSurveyMessage() {
        System.out.println("Please take the below survey to complete your profile:");
    }

    public void printPropertyAddressInputMessage() {
        System.out.println("Property Address:");
    }

    public void printInvalidInputMessage() {
        System.out.println("Invalid Input. Please enter a valid input.");
    }

    public void printNumberOfBedroomsInputMessage() {
        System.out.println("Number of Bedrooms:");
    }

    public void printUtilitiesInputMessage() {
        System.out.println("Are Utilities Included(Water, Heat and Electricity)? 1. Yes 2. No");
    }

    public void printNumberOfVacanciesInputMessage() {
        System.out.println("Number of Vacancies:");
    }

    public void printDalhousieUniversityDistanceInputMessage() {
        System.out.println("Distance of the rented property(in KM) from Dalhousie University:");
        System.out.println("1. <1KM 2. 1-2KM 3. 2-5KM 4. >5KM");
    }

    public void printGroceryStoreDistanceInputMessage() {
        System.out.println("Distance of the rented property(in KM) from Grocery Store:");
        System.out.println("1. <1KM 2. 1-2KM 3. 2-5KM 4. >5KM");
    }

    public void printTheaterDistanceInputMessage() {
        System.out.println("Distance of the rented property(in KM) from Theater:");
        System.out.println("1. <1KM 2. 1-2KM 3. 2-5KM 4. >5KM");
    }

    public void printDowntownDistanceInputMessage() {
        System.out.println("Distance of the rented property(in KM) from Downtown:");
        System.out.println("1. <1KM 2. 1-2KM 3. 2-5KM 4. >5KM");
    }

    public void printOwnerSurveyCompletionMessage() {
        System.out.println("Thanks for taking the survey. Your profile has been completed successfully");
    }

}
