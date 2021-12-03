package controller.filterroommates;

import java.util.ArrayList;
import java.util.HashMap;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.ControllerProperties;
import database.UserDetailsDAO;
import models.UserDetailsModel;

public class FilterRoommatesDisplayController implements IFilterRoommatesDisplayController {

	//Method to display results of filtered roommates
	public void getFilteredFits(IFilterRoommates filteredPreferences) {
	//public static void main(String args[]) {
		//IFilterRoommates filteredPreferences = new FilterRoommates();
		
		filteredPreferences = new FilterRoommates();
		
		String loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		IFilterRoommatesInput preferences = new FilterRoommatesInput();
		HashMap<String, Integer> usersMatchScoreMap = filteredPreferences.filterRoommates(preferences);
		UserDetailsDAO userDetails = new UserDetailsDAO();
		ArrayList<UserDetailsModel> listOfUserDetails = userDetails.getUserDetails();
		
		//Object is created to print on the Command Line Interface(CLI)
		RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
		roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.page.opening"));

		for(UserDetailsModel usersDetails : listOfUserDetails) {
			if(usersDetails.getEmailId().equals(loggedInUserId)) {
				continue;
			}
			else {
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.user.firstname")+usersDetails.getFirstName());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.user.lastname")+usersDetails.getLastName());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.user.contactnumber")+usersDetails.getContactNumber());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.user.emailid")+usersDetails.getEmailId());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.display.matched.preferences")+usersMatchScoreMap.get(usersDetails.getEmailId()));
			}
		}

	}



}
