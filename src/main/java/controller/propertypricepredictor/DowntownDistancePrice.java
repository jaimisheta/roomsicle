package controller.propertypricepredictor;

public class DowntownDistancePrice extends LocationBasedPrice {

    @Override
    IDistanceBasedPriceCalculator getLocation() {
        return new DistanceBasedDowntownPrice();
    }
}
