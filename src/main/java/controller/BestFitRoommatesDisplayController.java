package controller;

import java.util.ArrayList;
import java.util.HashMap;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.UserDetailsDAO;
import models.UserDetailsModel;

public class BestFitRoommatesDisplayController  {

	//Method to display results of best fit roommates
	public void getBestFits() {	
		
		/* Created object for BestFitRoommateController keeping in mind
		 * Dependency Inversion Principle by making the reference of Interface */
		IBestFitRoommateController bestFitRoommateController = new BestFitRoommateController();
		HashMap<String, Integer> usersMatchScoreMap = bestFitRoommateController.findBestFit();
		UserDetailsDAO userDetails = new UserDetailsDAO();
		ArrayList<UserDetailsModel> listOfUserDetails = userDetails.getUserDetails();
		//Object is created to print on the Command Line Interface(CLI)
		RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

		for(UserDetailsModel usersDetails : listOfUserDetails) {
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.page.opening"));
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.firstname")+usersDetails.getFirstName());
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.lastname")+usersDetails.getLastName());
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.contactnumber")+usersDetails.getContactNumber());
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.emailid")+usersDetails.getEmailId());
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.matched.preferences")+usersMatchScoreMap.get(usersDetails.getEmailId()));
		}

	}



}
