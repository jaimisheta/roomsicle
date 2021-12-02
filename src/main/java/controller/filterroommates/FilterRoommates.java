package controller.filterroommates;

import java.util.ArrayList;
import java.util.HashMap;

import controller.ControllerProperties;
import database.UserPreferencesDAO;
import models.UserPreferencesModel;

public class FilterRoommates implements IFilterRoommates{
	
	IFilterRoommatesInput preferences;

	public HashMap<String, Integer> filterRoommates(IFilterRoommatesInput preferences) {
		
		//Set user inputs of preferences
		String[] preferencesList = preferences.setPreferences();

		//Stored Logged-In user-id into the string
		String loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		
		//Made Object of DAO class to get list of all users' preferences
		UserPreferencesDAO userPreferences = new UserPreferencesDAO();
		ArrayList<UserPreferencesModel> listOfUserPreferences = userPreferences.getUserPreferences();
		
		//Initiated counter variable for matching manual user's preferences with other user's preferences
		int matchScore;
		
		//Matched Preferences will be stored in the HashMap
		HashMap<String, Integer> matchScoresMap = new HashMap<String, Integer>();
		
		//Comparing logged-in user preferences with other user's preferences 
		for(UserPreferencesModel userPreferenceObject : listOfUserPreferences) {
			matchScore = 0;
			if(userPreferenceObject.getUserId().equals(loggedInUserId)) {
				continue;
			}
			else {
				//Comparing food habits of users in the database
				if(preferencesList[0].equals(userPreferenceObject.getRoommateFoodHabits())) {
					matchScore++;
				}
				//Comparing smoking habits of users in the database
				if(preferencesList[1].equals(userPreferenceObject.getRoommateSmoke()) 
						|| preferencesList[1].equals(ControllerProperties.getControllerPropertyValue("user.selected.preference.anypreference"))) {
					matchScore++;
				}
				//Comparing drinking habits of users in the database
				if(preferencesList[2].equals(userPreferenceObject.getRoommateAlcohol())
						|| preferencesList[2].equals(ControllerProperties.getControllerPropertyValue("user.selected.preference.anypreference"))) {
					matchScore++;
				}
				matchScoresMap.put(userPreferenceObject.getUserId(), matchScore);
			}
		}
		return matchScoresMap;
	}
}