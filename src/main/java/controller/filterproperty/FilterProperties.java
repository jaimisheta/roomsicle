package controller.filterproperty;

import controller.ControllerProperties;
import database.PropertyDetailsDAO;
import models.OwnerSurveyModel;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterProperties implements IFilterProperties {
	
//	IFilterPropertiesInput preferences;

	public HashMap<Integer, Integer> filterProperties(IFilterPropertiesInput preferences) {
		
		//Set user inputs of preferences
		String[] preferencesList = preferences.setPreferences();

		//Stored Logged-In user-id into the string
		String loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		
		//Made Object of DAO class to get list of all users' preferences
		PropertyDetailsDAO propertyPreferences = new PropertyDetailsDAO();
		ArrayList<OwnerSurveyModel> listOfPropertyPreferences = propertyPreferences.getPropertyDetails();
		
		//Initiated counter variable for matching manual user's preferences with other user's preferences
		int matchScore;
		
		//Matched Preferences will be stored in the HashMap
		HashMap<Integer, Integer> matchScoresMap = new HashMap<Integer, Integer>();
		
		//Comparing logged-in user preferences with other user's preferences 
		for(OwnerSurveyModel propertyPreferenceObject : listOfPropertyPreferences) {
			matchScore = 0;

			//Comparing smoking habits of users in the database
			if(propertyPreferenceObject.getPropertyPrice() <= Integer.parseInt(preferencesList[0])) {

				matchScore++;
			}
			//Comparing food habits of users in the database
			if(Integer.parseInt(preferencesList[1]) == 1 && propertyPreferenceObject.getDalhousieDistance() <= 1) {
				matchScore++;
			}
			if(Integer.parseInt(preferencesList[1]) == 2 && (propertyPreferenceObject.getDalhousieDistance() > 1 && propertyPreferenceObject.getDalhousieDistance() <=2)) {
				matchScore++;
			}
			if(Integer.parseInt(preferencesList[1]) == 3 && (propertyPreferenceObject.getDalhousieDistance() > 2 && propertyPreferenceObject.getDalhousieDistance() <=5)) {
				matchScore++;
			}
			if(Integer.parseInt(preferencesList[1]) == 4 && propertyPreferenceObject.getDalhousieDistance() > 5) {
				matchScore++;
			}
			matchScoresMap.put(propertyPreferenceObject.getPropertyID(), matchScore);
		}
		return matchScoresMap;
	}
}