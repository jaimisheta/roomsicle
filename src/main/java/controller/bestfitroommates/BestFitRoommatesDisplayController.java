package controller.bestfitroommates;

import java.util.ArrayList;
import java.util.HashMap;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.ControllerProperties;
import controller.getloggedinuser.GetLoggedInUserController;
import controller.getloggedinuser.IGetLoggedInUserController;
import database.DatabaseQueryProperties;
import database.UserDetailsDAO;
import models.UserDetailsModel;

public class BestFitRoommatesDisplayController implements IBestFitRoommatesDisplayController {

	//Method to display results of best fit roommates
	public void getBestFits(IBestFitRoommateController bestFitRoommate) {

		String loggedInUserId;
		IGetLoggedInUserController loggedInUser;
		HashMap<String, Integer> usersMatchScoreMap;
		UserDetailsDAO userDetails;
		ArrayList<UserDetailsModel> listOfUserDetails;
		loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		loggedInUser = new GetLoggedInUserController();
		usersMatchScoreMap = bestFitRoommate.findBestFit(loggedInUser);
		userDetails = new UserDetailsDAO();
		listOfUserDetails = userDetails.getUserDetails();
		
		//Object is created to print on the Command Line Interface(CLI)
		RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
		roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.page.opening"));

		for(UserDetailsModel usersDetails : listOfUserDetails) {
			if(usersDetails.getEmailId().equals(loggedInUserId)) {
				continue;
			}
			else {
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.firstname")+usersDetails.getFirstName());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.lastname")+usersDetails.getLastName());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.contactnumber")+usersDetails.getContactNumber());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.emailid")+usersDetails.getEmailId());
				roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.matched.preferences")+usersMatchScoreMap.get(usersDetails.getEmailId()));
			}
		}

	}



}
