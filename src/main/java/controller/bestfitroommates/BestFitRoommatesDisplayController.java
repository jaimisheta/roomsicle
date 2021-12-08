package controller.bestfitroommates;

import java.util.ArrayList;
import java.util.HashMap;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.ClassInitializer;
import controller.ControllerProperties;
import controller.getloggedinuser.GetLoggedInUserController;
import controller.getloggedinuser.IGetLoggedInUserController;
import database.IUserDetailsDAO;
import models.fitroommatemodels.UserDetailsModel;

public class BestFitRoommatesDisplayController implements IBestFitRoommatesDisplayController {

	//Method to display results of best fit roommates
	public void getBestFits(IBestFitRoommateController bestFitRoommate) {

		String loggedInUserId;
		IGetLoggedInUserController loggedInUser;
		HashMap<String, Integer> usersMatchScoreMap;
		IUserDetailsDAO userDetails;
		ArrayList<UserDetailsModel> listOfUserDetails;
		IRoomsicleCLI roomsicleCLI;

		loggedInUserId = ControllerProperties.getControllerPropertyValue("loggedInUser");
		loggedInUser = ClassInitializer.initializer().getLoggedInUserController();
		usersMatchScoreMap = bestFitRoommate.findBestFit(loggedInUser);
		userDetails = ClassInitializer.initializer().getIUserDetailsDAO();
		listOfUserDetails = userDetails.getUserDetails();
		
		//Object is created to print on the Command Line Interface(CLI)
		roomsicleCLI = ClassInitializer.initializer().getRoomsicleCLI();
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
