package controller.propertypricepredictor;

public class DalhousieDistancePrice extends LocationBasedPrice {

    @Override
    IDistanceBasedPriceCalculator getLocation() {
        return new DistanceBasedDalhousiePrice();
    }
}
