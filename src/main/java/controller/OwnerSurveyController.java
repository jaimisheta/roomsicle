package controller;

import commandline.OwnerSurveyCLI;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;

import java.util.Scanner;

import static controller.OwnerSurveyConstants.ONE;
import static controller.OwnerSurveyConstants.TWO;
import static controller.OwnerSurveyConstants.THREE;
import static controller.OwnerSurveyConstants.FOUR;
import static controller.OwnerSurveyConstants.SIX;
import static controller.OwnerSurveyConstants.TWELVE;
import static controller.OwnerSurveyConstants.ZERO_KM;
import static controller.OwnerSurveyConstants.ONE_KM;
import static controller.OwnerSurveyConstants.TWO_KM;
import static controller.OwnerSurveyConstants.FIVE_KM;
import static controller.OwnerSurveyConstants.FIFTY_KM;

public class OwnerSurveyController {
    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    OwnerSurveyDAO ownerSurveyDAO = new OwnerSurveyDAO();
    OwnerSurveyCLI ownerSurveyCLI = new OwnerSurveyCLI();
    Scanner input = new Scanner(System.in);
    int[] distanceRange = new int[2];

    public void takeSurvey(String emailId) {
        try {
            ownerSurveyCLI.printTakeSurveyMessage();
            ownerSurveyModel.setOwnerID(emailId);
            ownerSurveyModel.setAddress(getPropertyAddressFromOwner());
            ownerSurveyModel.setNumberOfBedrooms(getNumberOfBedroomsFromOwner());
            ownerSurveyModel.setNumberOfVacancies(getNumberOfVacanciesFromOwner());
            ownerSurveyModel.setUtilitiesProvided(getUtilitiesConfirmationFromOwner());
            distanceRange = getDistanceRange(getDalhousieUniversityDistanceInputFromOwner());
            ownerSurveyModel.setDalDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDalDistanceMax(distanceRange[1]);
            distanceRange = getDistanceRange(getGroceryStoreDistanceInputFromOwner());
            ownerSurveyModel.setGroceryStoreDistanceMin(distanceRange[0]);
            ownerSurveyModel.setGroceryStoreDistanceMax(distanceRange[1]);
            distanceRange = getDistanceRange(getTheaterDistanceInputFromOwner());
            ownerSurveyModel.setTheaterDistanceMin(distanceRange[0]);
            ownerSurveyModel.setTheaterDistanceMax(distanceRange[1]);
            distanceRange = getDistanceRange(getDowntownDistanceInputFromOwner());
            ownerSurveyModel.setDowntownDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDowntownDistanceMax(distanceRange[1]);
            ownerSurveyDAO.insertOwnerSurveyDetails(ownerSurveyModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] getDistanceRange(int input) {
        int[] distanceMinMax = new int[2];
        try {
            if (input == ONE) {
                distanceMinMax[0] = ZERO_KM;
                distanceMinMax[1] = ONE_KM;
            } else if (input == TWO) {
                distanceMinMax[0] = ZERO_KM;
                distanceMinMax[1] = TWO_KM;
            } else if (input == THREE) {
                distanceMinMax[0] = TWO_KM;
                distanceMinMax[1] = FIVE_KM;
            } else if (input == FOUR) {
                distanceMinMax[0] = FIVE_KM;
                distanceMinMax[1] = FIFTY_KM;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceMinMax;
    }

    public String getPropertyAddressFromOwner() {
        String propertyAddress = null;
        try {
            ownerSurveyCLI.printPropertyAddressInputMessage();
            propertyAddress = input.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyAddress;
    }

    public int getNumberOfBedroomsFromOwner() {
        int numberOfBedrooms = 0;
        try {
            ownerSurveyCLI.printNumberOfBedroomsInputMessage();
            numberOfBedrooms = input.nextInt();
            while (!(numberOfBedrooms >= ONE && numberOfBedrooms <= SIX)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfBedrooms = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfBedrooms;
    }

    public int getNumberOfVacanciesFromOwner() {
        int numberOfVacancies = 0;
        try {
            ownerSurveyCLI.printNumberOfVacanciesInputMessage();
            numberOfVacancies = input.nextInt();
            while (!(numberOfVacancies >= ONE && numberOfVacancies <= TWELVE)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfVacancies = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfVacancies;
    }

    public boolean getUtilitiesConfirmationFromOwner() {
        boolean utilitiesIncluded = false;
        int utilitiesIncludedInput;
        try {
            ownerSurveyCLI.printUtilitiesInputMessage();
            utilitiesIncludedInput = input.nextInt();
            while (utilitiesIncludedInput != ONE && utilitiesIncludedInput != TWO) {
                ownerSurveyCLI.printInvalidInputMessage();
                utilitiesIncludedInput = input.nextInt();
            }
            if (utilitiesIncludedInput == ONE) {
                utilitiesIncluded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilitiesIncluded;
    }

    public int getDalhousieUniversityDistanceInputFromOwner() {
        int dalhousieUniversityDistanceInput = 0;
        try {
            ownerSurveyCLI.printDalhousieUniversityDistanceInputMessage();
            dalhousieUniversityDistanceInput = input.nextInt();
            while (!(dalhousieUniversityDistanceInput >= ONE && dalhousieUniversityDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                dalhousieUniversityDistanceInput = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dalhousieUniversityDistanceInput;
    }

    public int getGroceryStoreDistanceInputFromOwner() {
        int groceryStoreDistanceInput = 0;
        try {
            ownerSurveyCLI.printGroceryStoreDistanceInputMessage();
            groceryStoreDistanceInput = input.nextInt();
            while (!(groceryStoreDistanceInput >= ONE && groceryStoreDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                groceryStoreDistanceInput = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groceryStoreDistanceInput;
    }

    public int getTheaterDistanceInputFromOwner() {
        int theaterDistanceInput = 0;
        try {
            ownerSurveyCLI.printTheaterDistanceInputMessage();
            theaterDistanceInput = input.nextInt();
            while (!(theaterDistanceInput >= ONE && theaterDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                theaterDistanceInput = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theaterDistanceInput;
    }

    public int getDowntownDistanceInputFromOwner() {
        int downtownDistanceInput = 0;
        try {
            ownerSurveyCLI.printDowntownDistanceInputMessage();
            downtownDistanceInput = input.nextInt();
            while (!(downtownDistanceInput >= ONE && downtownDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                downtownDistanceInput = input.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downtownDistanceInput;
    }
}