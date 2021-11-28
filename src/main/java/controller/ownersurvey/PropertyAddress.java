package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import models.OwnerSurveyModel;

public class PropertyAddress implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    OwnerSurveyModel ownerSurveyModel;

    boolean hasValidValue = false;
    String propertyAddress;

    public PropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public PropertyAddress(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    @Override
    public void getValue() {
        BedroomCount bedroomCount = new BedroomCount(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.take.survey.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.property.address.message"));
            propertyAddress = roomsicleCLI.getStringResponse();
            while (hasValidValue == false) {
                if (validateValue()) {
                    hasValidValue = true;
                    bedroomCount.getValue();
                    break;
                } else {
                    getValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateValue() {
        boolean propertyAddressValue = false;
        try {
            if (propertyAddress == null || propertyAddress.isEmpty() || propertyAddress.isBlank()) {
                throw new IllegalArgumentException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.property.address.message"));
            } else {
                propertyAddressValue = true;
                setValue();
            }
        } catch (Exception e) {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.illegal.argument.exception.property.address.message"));
        }
        return propertyAddressValue;
    }

    @Override
    public void setValue() {
        ownerSurveyModel.setAddress(propertyAddress);
    }
}
