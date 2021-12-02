package controller.propertypricepredictor;

public class TheaterDistancePrice extends LocationBasedPrice {

    @Override
    IDistanceBasedPriceCalculator getLocation() {
        return new DistanceBasedTheaterPrice();
    }
}
