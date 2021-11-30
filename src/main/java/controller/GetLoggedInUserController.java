package controller;

import java.util.ArrayList;
import database.UserPreferencesDAO;
import models.UserPreferencesModel;

public class GetLoggedInUserController implements IGetLoggedInUserController{

	public UserPreferencesModel getLoggedInUser() {

		String loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		UserPreferencesModel loggedInUser = new UserPreferencesModel();
		UserPreferencesDAO userPreferences = new UserPreferencesDAO();
		ArrayList<UserPreferencesModel> listOfUserPreferences = userPreferences.getUserPreferences();

		for(UserPreferencesModel userPreferenceObject : listOfUserPreferences) {
			if((userPreferenceObject.getUserId()).equals(loggedInUserId)) {
				loggedInUser.setUserId(loggedInUserId);
				loggedInUser.setRoommateFoodHabits(userPreferenceObject.getRoommateFoodHabits());
				loggedInUser.setRoommateAlcohol(userPreferenceObject.getRoommateAlcohol());
				loggedInUser.setRoommateSmoke(userPreferenceObject.getRoommateSmoke());
				loggedInUser.setRoommateGender(userPreferenceObject.getRoommateGender());
			}
		}
		
		return loggedInUser;
		
	}

}
