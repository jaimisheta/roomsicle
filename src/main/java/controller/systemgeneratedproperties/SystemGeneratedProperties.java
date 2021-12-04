package controller.systemgeneratedproperties;

import commandline.RoomsicleCLI;
import controller.ControllerConstant;
import controller.ControllerProperties;
import database.OwnerSurveyDAO;
import database.SystemGeneratedPropertiesDAO;
import models.SystemGeneratedPropertiesModel;
import models.UserSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemGeneratedProperties {

    SystemGeneratedPropertiesDAO systemGeneratedPropertiesDAO = new SystemGeneratedPropertiesDAO();
    static final Logger logger = LogManager.getLogger(OwnerSurveyDAO.class);

    UserSurveyModel userSurveyModel;
    HashMap<String, Integer> userDetails = new HashMap<>();
    ArrayList<SystemGeneratedPropertiesModel> models = new ArrayList<>();
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    public SystemGeneratedProperties(UserSurveyModel userSurveyModel) {
        this.userSurveyModel = userSurveyModel;
    }

    //get property details based on user preferences
    public void getUserPreferenceBasedProperties() {

        int ownerCount = ControllerConstant.OWNER_COUNT;
        logger.info("Getting user budget and distance from dalhousie preference");
        userDetails = systemGeneratedPropertiesDAO.getUserBudgetAndDistancePreference(userSurveyModel);
        logger.info("Getting system generated property details based on user preference");
        models = systemGeneratedPropertiesDAO.getSystemGeneratedPropertyDetails(userDetails);

        logger.info("Display properties matching user preferences");
        for (SystemGeneratedPropertiesModel model : models) {
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.owner.name")
                    .replace("ownerCount", String.valueOf(ownerCount))
                    .replace("firstName", model.getFirstName())
                    .replace("lastName", String.valueOf(model.getLastName())));
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.property.address")
                    .replace("propertyAddress", model.getAddress()));
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.owner.email.id")
                    .replace("ownerEmailId", model.getOwnerEmailId()));
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.owner.contact.number")
                    .replace("contactNumber", String.valueOf(model.getContactNumber())));
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.property.rent")
                    .replace("propertyRent", String.valueOf(model.getRent())));
            roomsicleCLI.printMessage(ControllerProperties.getControllerPropertyValue("system.generated.properties.display.dalhousie.distance")
                    .replace("dalhousieDistance", String.valueOf(model.getDalhousieDistance())));
            roomsicleCLI.printMessage("");
            ownerCount++;
        }
    }
}
