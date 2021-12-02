package controller.propertypricepredictor;

public class GroceryStoreDistancePrice extends LocationBasedPrice {

    @Override
    IDistanceBasedPriceCalculator getLocation() {
        return new DistanceBasedGroceryStorePrice();
    }
}
