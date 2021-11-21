package controller;

import commandline.OwnerSurveyCLI;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;

import java.util.Scanner;

public class OwnerSurveyController {
    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    OwnerSurveyDAO ownerSurveyDAO = new OwnerSurveyDAO();
    OwnerSurveyCLI ownerSurveyCLI = new OwnerSurveyCLI();
    Scanner input = new Scanner(System.in);
    int[] distanceRange = new int[2];

    public void takeSurvey(String emailId) {
        try{
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
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private int[] getDistanceRange(int input) {
        int[] distanceMinMax = new int[2];
        try{
            if (input == 1) {
                distanceMinMax[0] = 0;
                distanceMinMax[1] = 1;
            } else if (input == 2) {
                distanceMinMax[0] = 1;
                distanceMinMax[1] = 2;
            } else if (input == 3) {
                distanceMinMax[0] = 2;
                distanceMinMax[1] = 5;
            } else if (input == 4) {
                distanceMinMax[0] = 5;
                distanceMinMax[1] = 50;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return distanceMinMax;
    }

    public String getPropertyAddressFromOwner() {
        String propertyAddress = null;
        try{
            ownerSurveyCLI.printPropertyAddressInputMessage();
            propertyAddress = input.nextLine();
        } catch(Exception e){
            e.printStackTrace();
        }
        return propertyAddress;
    }

    public int getNumberOfBedroomsFromOwner() {
        int numberOfBedrooms = 0;
        try{
            ownerSurveyCLI.printNumberOfBedroomsInputMessage();
            numberOfBedrooms = input.nextInt();
            while (!(numberOfBedrooms >= 1 && numberOfBedrooms <= 6)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfBedrooms = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return numberOfBedrooms;
    }

    public int getNumberOfVacanciesFromOwner() {
        int numberOfVacancies = 0;
        try{
            ownerSurveyCLI.printNumberOfVacanciesInputMessage();
            numberOfVacancies = input.nextInt();
            while (!(numberOfVacancies >= 1 && numberOfVacancies <= 12)) {
                ownerSurveyCLI.printInvalidInputMessage();
                numberOfVacancies = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return numberOfVacancies;
    }

    public boolean getUtilitiesConfirmationFromOwner() {
        boolean utilitiesIncluded = false;
        int utilitiesIncludedInput;
        try{
            ownerSurveyCLI.printUtilitiesInputMessage();
            utilitiesIncludedInput = input.nextInt();
            while (utilitiesIncludedInput != 1 && utilitiesIncludedInput != 2) {
                ownerSurveyCLI.printInvalidInputMessage();
                utilitiesIncludedInput = input.nextInt();
            }
            if (utilitiesIncludedInput == 1) {
                utilitiesIncluded = true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return utilitiesIncluded;
    }

    public int getDalhousieUniversityDistanceInputFromOwner() {
        int dalhousieUniversityDistanceInput = 0;
        try{
            ownerSurveyCLI.printDalhousieUniversityDistanceInputMessage();
            dalhousieUniversityDistanceInput = input.nextInt();
            while (!(dalhousieUniversityDistanceInput >= 1 && dalhousieUniversityDistanceInput <= 4)) {
                ownerSurveyCLI.printInvalidInputMessage();
                dalhousieUniversityDistanceInput = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return dalhousieUniversityDistanceInput;
    }

    public int getGroceryStoreDistanceInputFromOwner() {
        int groceryStoreDistanceInput = 0;
        try{
            ownerSurveyCLI.printGroceryStoreDistanceInputMessage();
            groceryStoreDistanceInput = input.nextInt();
            while (!(groceryStoreDistanceInput >= 1 && groceryStoreDistanceInput <= 4)) {
                ownerSurveyCLI.printInvalidInputMessage();
                groceryStoreDistanceInput = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return groceryStoreDistanceInput;
    }

    public int getTheaterDistanceInputFromOwner() {
        int theaterDistanceInput = 0;
        try{
            ownerSurveyCLI.printTheaterDistanceInputMessage();
            theaterDistanceInput = input.nextInt();
            while (!(theaterDistanceInput >= 1 && theaterDistanceInput <= 4)) {
                ownerSurveyCLI.printInvalidInputMessage();
                theaterDistanceInput = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return theaterDistanceInput;
    }

    public int getDowntownDistanceInputFromOwner() {
        int downtownDistanceInput = 0;
        try{
            ownerSurveyCLI.printDowntownDistanceInputMessage();
            downtownDistanceInput = input.nextInt();
            while (!(downtownDistanceInput >= 1 && downtownDistanceInput <= 4)) {
                ownerSurveyCLI.printInvalidInputMessage();
                downtownDistanceInput = input.nextInt();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return downtownDistanceInput;
    }
}