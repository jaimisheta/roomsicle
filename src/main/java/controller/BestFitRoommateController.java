package controller;

import java.util.ArrayList;
import java.util.HashMap;
import database.UserPreferencesDAO;
import models.UserPreferencesModel;

public class BestFitRoommateController implements IBestFitRoommateController{

	public HashMap<String, Integer> findBestFit() {

		//Stored Logged-In user-id into the string
		String loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		
		//Made Object of DAO class to get list of all users' preferences
		UserPreferencesDAO userPreferences = new UserPreferencesDAO();
		ArrayList<UserPreferencesModel> listOfUserPreferences = userPreferences.getUserPreferences();
		/*
		 * Created object for logged-in user to compare his preferences further with other users keeping in mind
		 * Dependency Inversion Principle by making the reference of Interface 
		*/
		IGetLoggedInUserController getLoggedInUserObject = new GetLoggedInUserController();
		
		//Get the logged-in user with getLoggedInUser() method of object made above 
		UserPreferencesModel loggedInUser = getLoggedInUserObject.getLoggedInUser();
		
		//Initiated counter variable for matching logged-in user's preferences with other user's preferences
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
				if(loggedInUser.getRoommateFoodHabits().equals(userPreferenceObject.getRoommateFoodHabits())) {
					matchScore++;
				}
				//Comparing smoking habits of users in the database
				if(loggedInUser.getRoommateSmoke().equals(userPreferenceObject.getRoommateSmoke()) 
						|| loggedInUser.getRoommateSmoke().equals(ControllerProperties.getControllerPropertyValue("user.selected.preference.anypreference"))) {
					matchScore++;
				}
				//Comparing drinking habits of users in the database
				if(loggedInUser.getRoommateAlcohol().equals(userPreferenceObject.getRoommateAlcohol())
						|| loggedInUser.getRoommateAlcohol().equals(ControllerProperties.getControllerPropertyValue("user.selected.preference.anypreference"))) {
					matchScore++;
				}
				matchScoresMap.put(userPreferenceObject.getUserId(), matchScore);
			}
		}
		return matchScoresMap;
	}
}