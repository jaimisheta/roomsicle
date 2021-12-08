package controller.userprofile;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.ClassInitializer;
import controller.ControllerProperties;
import database.IUserDetailsDAO;
import models.UserDetailsModel;

import java.util.ArrayList;


public class UserProfile implements IUserProfile{
    public void userProfile(){
        IRoomsicleCLI roomsicleCLI=ClassInitializer.initializer().getRoomsicleCLI();
        String loggedInUserId;
        loggedInUserId=ControllerProperties.getControllerPropertyValue("user.logged.in.email.id");
        IUserDetailsDAO userDetailsDAO=ClassInitializer.initializer().getIUserDetailsDAO();
        ArrayList<UserDetailsModel> listOfUserDetails;
        listOfUserDetails = userDetailsDAO.getUserDetails();
        for(UserDetailsModel userDetailsObject : listOfUserDetails) {
            if(userDetailsObject.getEmailId().equals(loggedInUserId) ){
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.firstname")+userDetailsObject.getFirstName());
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.lastname")+userDetailsObject.getLastName());
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.contactnumber")+userDetailsObject.getContactNumber());
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.emailid")+userDetailsObject.getEmailId());
            }
        }
    }
}
