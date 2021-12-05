package controller.getloggedinuser;

import java.util.ArrayList;

import controller.ControllerProperties;
import database.UserPreferencesDAO;
import models.UserPreferencesModel;

public class GetLoggedInUserController implements IGetLoggedInUserController{

	public UserPreferencesModel getLoggedInUser() {

		String loggedInUserId;
		UserPreferencesModel loggedInUser;
		UserPreferencesDAO userPreferences;
		ArrayList<UserPreferencesModel> listOfUserPreferences;
		loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		loggedInUser = new UserPreferencesModel();
		userPreferences = new UserPreferencesDAO();
		listOfUserPreferences = userPreferences.getUserPreferences();

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
