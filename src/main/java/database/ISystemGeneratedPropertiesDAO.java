package database;

import models.SystemGeneratedPropertiesModel;
import models.UserSurveyModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface ISystemGeneratedPropertiesDAO {

    HashMap<String, Integer> getUserBudgetAndDistancePreference();

    ArrayList<SystemGeneratedPropertiesModel> getSystemGeneratedPropertyDetails(HashMap<String, Integer> userDetails);
}
