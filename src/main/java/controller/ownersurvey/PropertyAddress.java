package controller.ownersurvey;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyAddress implements IOwnerSurvey {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

    OwnerSurveyModel ownerSurveyModel;
    boolean hasValidValue = false;
    String propertyAddress;

    public PropertyAddress(OwnerSurveyModel ownerSurveyModel) {
        this.ownerSurveyModel = ownerSurveyModel;
    }

    public PropertyAddress(OwnerSurveyModel ownerSurveyModel, String propertyAddress) {
        this.ownerSurveyModel = ownerSurveyModel;
        this.propertyAddress = propertyAddress;
    }

    //get property address input from owner
    @Override
    public void getValue() {
        BedroomCount bedroomCount = new BedroomCount(ownerSurveyModel);
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.take.survey.message"));
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.property.address.message"));
            propertyAddress = roomsicleCLI.getStringResponse();
            logger.info("property address input from owner: " + propertyAddress);
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

    //validate property address input from owner
    @Override
    public boolean validateValue() {
        boolean propertyAddressValue = false;
        try {
            logger.info("validate property address input from owner: " + propertyAddress);
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

    //set property address input
    @Override
    public void setValue() {
        ownerSurveyModel.setAddress(propertyAddress);
        logger.info("property address is set to: " + propertyAddress);
    }
}
