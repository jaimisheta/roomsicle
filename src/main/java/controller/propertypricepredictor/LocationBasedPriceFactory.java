package controller.propertypricepredictor;

import controller.ControllerProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationBasedPriceFactory {

    static final Logger logger = LogManager.getLogger(LocationBasedPriceFactory.class);

    public LocationBasedPrice getLocationBasedPrice(String location) {
        logger.info("location: " + location);
        if (location.equalsIgnoreCase(ControllerProperties.getControllerPropertyValue("property.price.predictor.location.dalhousie"))) {
            return new DalhousieDistancePrice();
        } else if (location.equalsIgnoreCase(ControllerProperties.getControllerPropertyValue("property.price.predictor.location.grocery.store"))) {
            return new GroceryStoreDistancePrice();
        } else if (location.equalsIgnoreCase(ControllerProperties.getControllerPropertyValue("property.price.predictor.location.downtown"))) {
            return new DowntownDistancePrice();
        } else if (location.equalsIgnoreCase(ControllerProperties.getControllerPropertyValue("property.price.predictor.location.theater"))) {
            return new TheaterDistancePrice();
        } else {
            throw new IllegalArgumentException("invalid argument");
        }
    }
}
