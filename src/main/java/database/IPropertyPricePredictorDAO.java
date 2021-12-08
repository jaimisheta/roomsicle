package database;

import models.OwnerSurveyModel;
import models.PropertyPriceCalculatorModel;

public interface IPropertyPricePredictorDAO {

    void insertPropertyPrice(OwnerSurveyModel ownerSurveyModel, PropertyPriceCalculatorModel propertyPriceCalculatorModel);

}
