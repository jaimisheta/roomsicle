package controller;

import commandline.OwnerSurveyCLI;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;
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
            setPropertyAddress();
            setNumberOfBedrooms();
            setNumberOfVacancies();
            setUtilitiesConfirmation();
            setDalhousieUniversityDistance();
            setGroceryStoreDistance();
            setTheaterDistance();
            setDowntownDistance();
            ownerSurveyDAO.insertOwnerSurveyDetails(ownerSurveyModel);
            ownerSurveyCLI.printOwnerSurveyCompletionMessage();
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

    public void setPropertyAddress() {
        String propertyAddress;
        try {
            ownerSurveyCLI.printPropertyAddressInputMessage();
            propertyAddress = input.nextLine();
            ownerSurveyModel.setAddress(propertyAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNumberOfBedrooms() {
        int numberOfBedrooms;
        try {
            ownerSurveyCLI.printNumberOfBedroomsInputMessage();
            numberOfBedrooms = input.nextInt();
            while (!(numberOfBedrooms >= ONE && numberOfBedrooms <= SIX)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfBedrooms = input.nextInt();
            }
            ownerSurveyModel.setNumberOfBedrooms(numberOfBedrooms);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setNumberOfBedrooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNumberOfVacancies() {
        int numberOfVacancies;
        try {
            ownerSurveyCLI.printNumberOfVacanciesInputMessage();
            numberOfVacancies = input.nextInt();
            while (!(numberOfVacancies >= ONE && numberOfVacancies <= TWELVE)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfVacancies = input.nextInt();
            }
            ownerSurveyModel.setNumberOfVacancies(numberOfVacancies);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setNumberOfVacancies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUtilitiesConfirmation() {
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
            ownerSurveyModel.setUtilitiesProvided(utilitiesIncluded);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setUtilitiesConfirmation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDalhousieUniversityDistance() {
        int dalhousieUniversityDistanceInput;
        try {
            ownerSurveyCLI.printDalhousieUniversityDistanceInputMessage();
            dalhousieUniversityDistanceInput = input.nextInt();
            while (!(dalhousieUniversityDistanceInput >= ONE && dalhousieUniversityDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                dalhousieUniversityDistanceInput = input.nextInt();
            }
            distanceRange=getDistanceRange(dalhousieUniversityDistanceInput);
            ownerSurveyModel.setDalDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDalDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setDalhousieUniversityDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGroceryStoreDistance() {
        int groceryStoreDistanceInput;
        try {
            ownerSurveyCLI.printGroceryStoreDistanceInputMessage();
            groceryStoreDistanceInput = input.nextInt();
            while (!(groceryStoreDistanceInput >= ONE && groceryStoreDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                groceryStoreDistanceInput = input.nextInt();
            }
            distanceRange=getDistanceRange(groceryStoreDistanceInput);
            ownerSurveyModel.setGroceryStoreDistanceMin(distanceRange[0]);
            ownerSurveyModel.setGroceryStoreDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setGroceryStoreDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTheaterDistance() {
        int theaterDistanceInput;
        try {
            ownerSurveyCLI.printTheaterDistanceInputMessage();
            theaterDistanceInput = input.nextInt();
            while (!(theaterDistanceInput >= ONE && theaterDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                theaterDistanceInput = input.nextInt();
            }
            distanceRange=getDistanceRange(theaterDistanceInput);
            ownerSurveyModel.setTheaterDistanceMin(distanceRange[0]);
            ownerSurveyModel.setTheaterDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setTheaterDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDowntownDistance() {
        int downtownDistanceInput;
        try {
            ownerSurveyCLI.printDowntownDistanceInputMessage();
            downtownDistanceInput = input.nextInt();
            while (!(downtownDistanceInput >= ONE && downtownDistanceInput <= FOUR)) {
                ownerSurveyCLI.printInvalidInputMessage();
                downtownDistanceInput = input.nextInt();
            }
            distanceRange=getDistanceRange(downtownDistanceInput);
            ownerSurveyModel.setDowntownDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDowntownDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            ownerSurveyCLI.printInvalidInputMessage();
            input.nextLine();
            setDowntownDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}