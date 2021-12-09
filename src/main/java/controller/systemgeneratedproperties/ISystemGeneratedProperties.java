package controller.systemgeneratedproperties;

import models.systemgeneratedpropertiesmodel.SystemGeneratedPropertiesModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface ISystemGeneratedProperties {

    HashMap<String, Integer> getUserBudgetAndDistanceValues();

    ArrayList<SystemGeneratedPropertiesModel> getSystemGeneratedProperties();

    void printSystemGeneratedProperties(ArrayList<SystemGeneratedPropertiesModel> systemGeneratedPropertiesModels);
}
