package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

import java.util.InputMismatchException;

import static controller.ownersurvey.OwnerSurveyConstants.ONE;
import static controller.ownersurvey.OwnerSurveyConstants.TWO;

public class Utilities implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    boolean utilitiesIncluded;
    int utilitiesInput;

    public Utilities(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public Utilities(OwnerSurveyModel ownerSurveyModel, int utilitiesInput) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.utilitiesInput = utilitiesInput;
    }

    @Override
    public void getValue() {
        DalhousieDistance dalhousieDistance = new DalhousieDistance(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.utilities.message"));
            utilitiesInput = roomsicleCLI.getNumberResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    dalhousieDistance.getValue();
                    break;
                } else {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.utilities.message"));
                    utilitiesInput = roomsicleCLI.getNumberResponse();
                }
            }
        } catch (InputMismatchException e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateValue() {
        boolean utilitiesResponse = false;
        try {
            if (utilitiesInput == ONE) {
                utilitiesResponse = true;
                utilitiesIncluded = true;
                setValue();
            } else if (utilitiesInput == TWO) {
                utilitiesResponse = true;
                utilitiesIncluded = false;
                setValue();
            } else {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.utilities.message"));
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.utilities.message"));
        }
        return utilitiesResponse;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setUtilitiesProvided(utilitiesIncluded);
    }
}
