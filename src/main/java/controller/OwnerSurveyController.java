package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.OwnerSurveyConstants.ZERO;
import static controller.OwnerSurveyConstants.ONE;
import static controller.OwnerSurveyConstants.TWO;
import static controller.OwnerSurveyConstants.THREE;
import static controller.OwnerSurveyConstants.FOUR;
import static controller.OwnerSurveyConstants.FIVE;
import static controller.OwnerSurveyConstants.SEVEN;
import static controller.OwnerSurveyConstants.THIRTEEN;
import static controller.OwnerSurveyConstants.ZERO_KM;
import static controller.OwnerSurveyConstants.ONE_KM;
import static controller.OwnerSurveyConstants.TWO_KM;
import static controller.OwnerSurveyConstants.FIVE_KM;
import static controller.OwnerSurveyConstants.FIFTY_KM;

public class OwnerSurveyController {

    OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
    OwnerSurveyDAO ownerSurveyDAO = new OwnerSurveyDAO();
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    int[] distanceRange = new int[2];

    public void takeSurvey(String emailId) {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.take.survey.message"));
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
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.profile.creation.message"));
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
                distanceMinMax[0] = ONE_KM;
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
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.property.address.message"));
            propertyAddress = roomsicleCLI.getStringResponse();
            ownerSurveyModel.setAddress(propertyAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNumberOfBedrooms() {
        int numberOfBedrooms;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.bedrooms.message"));
            numberOfBedrooms = roomsicleCLI.getNumberResponse();
            while (numberOfBedrooms <= ZERO || numberOfBedrooms >= SEVEN) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.bedrooms.message"));
                numberOfBedrooms = roomsicleCLI.getNumberResponse();
            }
            ownerSurveyModel.setNumberOfBedrooms(numberOfBedrooms);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setNumberOfBedrooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNumberOfVacancies() {
        int numberOfVacancies;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.vacancies.message"));
            numberOfVacancies = roomsicleCLI.getNumberResponse();
            while (numberOfVacancies <= ZERO || numberOfVacancies >= THIRTEEN) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.number.of.vacancies.message"));
                numberOfVacancies = roomsicleCLI.getNumberResponse();
            }
            ownerSurveyModel.setNumberOfVacancies(numberOfVacancies);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setNumberOfVacancies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUtilitiesConfirmation() {
        boolean utilitiesIncluded = false;
        int utilitiesIncludedInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.utilities.message"));
            utilitiesIncludedInput = roomsicleCLI.getNumberResponse();
            while (utilitiesIncludedInput <= ZERO || utilitiesIncludedInput >= THREE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.utilities.message"));
                utilitiesIncludedInput = roomsicleCLI.getNumberResponse();
            }
            if (utilitiesIncludedInput == ONE) {
                utilitiesIncluded = true;
            }
            ownerSurveyModel.setUtilitiesProvided(utilitiesIncluded);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setUtilitiesConfirmation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDalhousieUniversityDistance() {
        int dalhousieUniversityDistanceInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.dalhousie.university.distance.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
            dalhousieUniversityDistanceInput = roomsicleCLI.getNumberResponse();
            while (dalhousieUniversityDistanceInput <= ZERO || dalhousieUniversityDistanceInput >= FIVE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.dalhousie.university.distance.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
                dalhousieUniversityDistanceInput = roomsicleCLI.getNumberResponse();
            }
            distanceRange = getDistanceRange(dalhousieUniversityDistanceInput);
            ownerSurveyModel.setDalDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDalDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setDalhousieUniversityDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGroceryStoreDistance() {
        int groceryStoreDistanceInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.grocery.store.distance.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
            groceryStoreDistanceInput = roomsicleCLI.getNumberResponse();
            while (groceryStoreDistanceInput <= ZERO || groceryStoreDistanceInput >= FIVE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.grocery.store.distance.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
                groceryStoreDistanceInput = roomsicleCLI.getNumberResponse();
            }
            distanceRange = getDistanceRange(groceryStoreDistanceInput);
            ownerSurveyModel.setGroceryStoreDistanceMin(distanceRange[0]);
            ownerSurveyModel.setGroceryStoreDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setGroceryStoreDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTheaterDistance() {
        int theaterDistanceInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
            theaterDistanceInput = roomsicleCLI.getNumberResponse();
            while (theaterDistanceInput <= ZERO || theaterDistanceInput >= FIVE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.theater.distance.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
                theaterDistanceInput = roomsicleCLI.getNumberResponse();
            }
            distanceRange = getDistanceRange(theaterDistanceInput);
            ownerSurveyModel.setTheaterDistanceMin(distanceRange[0]);
            ownerSurveyModel.setTheaterDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setTheaterDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDowntownDistance() {
        int downtownDistanceInput;
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.downtown.distance.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
            downtownDistanceInput = roomsicleCLI.getNumberResponse();
            while (downtownDistanceInput <= ZERO || downtownDistanceInput >= FIVE) {
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.downtown.distance.message"));
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.distance.options.message"));
                downtownDistanceInput = roomsicleCLI.getNumberResponse();
            }
            distanceRange = getDistanceRange(downtownDistanceInput);
            ownerSurveyModel.setDowntownDistanceMin(distanceRange[0]);
            ownerSurveyModel.setDowntownDistanceMax(distanceRange[1]);
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            setDowntownDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}