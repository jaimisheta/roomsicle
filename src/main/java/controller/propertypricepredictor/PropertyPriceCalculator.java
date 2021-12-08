package controller.propertypricepredictor;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.usersurvey.UserAlcoholHabits;
import database.PropertyPricePredictorDAO;
import models.OwnerSurveyModel;
import models.PropertyPriceCalculatorModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyPriceCalculator {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    PropertyPriceCalculatorModel propertyPriceCalculatorModel = new PropertyPriceCalculatorModel();
    PropertyPricePredictorDAO propertyPricePredictorDAO = new PropertyPricePredictorDAO();
    static final Logger logger = LogManager.getLogger(UserAlcoholHabits.class);

    public void propertyPrice(OwnerSurveyModel ownerSurveyModel) {
        int propertyPrice;
        int basePrice;
        int distanceBasedPrice;
        int utilitiesPrice;

        try {
            ICalculateIndividualFeaturePrice distanceIndividualPrice = new DistanceBasedTotalPrice();
            ICalculateIndividualFeaturePrice propertyBasePrice = new PropertyBasePrice();
            ICalculateIndividualFeaturePrice utilitiesBasedPrice = new UtilitiesBasedPrice();

            distanceBasedPrice = distanceIndividualPrice.calculatePrice(ownerSurveyModel);
            logger.info("distanceBasedPrice: " + distanceBasedPrice);
            basePrice = propertyBasePrice.calculatePrice(ownerSurveyModel);
            logger.info("basePrice: " + basePrice);
            utilitiesPrice = utilitiesBasedPrice.calculatePrice(ownerSurveyModel);
            logger.info("utilitiesPrice: " + utilitiesPrice);
            propertyPrice = distanceBasedPrice + basePrice + utilitiesPrice;
            logger.info("propertyPrice: " + propertyPrice);
            propertyPriceCalculatorModel.setPropertyPrice(propertyPrice);
            logger.info("inserting property price into owner survey table");
            propertyPricePredictorDAO.insertPropertyPrice(ownerSurveyModel, propertyPriceCalculatorModel);
            roomsicleCLI.printMessage(CommandLineInputProperties
                    .getCommandLineInputPropertyValue("property.price.predictor.display.property.price.message")
                    .replace("propertyPrice", String.valueOf(propertyPrice)) + "\n");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
