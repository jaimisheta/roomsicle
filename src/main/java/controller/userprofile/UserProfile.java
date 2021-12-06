package controller.userprofile;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.ClassInitializer;
import controller.ControllerProperties;
import controller.userlogin.IUserLoginController;
import database.IUserDetailsDAO;
import models.UserDetailsModel;

import java.util.ArrayList;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;

public class UserProfile implements IUserProfile{
    public void userProfile(){
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IUserLoginController iUserLoginController=ClassInitializer.initializer().getUserLoginController();
        String loggedInUserId;
        loggedInUserId=ControllerProperties.getControllerPropertyValue("user.logged.in.email.id");
        IUserDetailsDAO iUserDetailsDAO=ClassInitializer.initializer().getIUserDetailsDAO();
        ArrayList<UserDetailsModel> listOfUserDetails = new ArrayList<>();
        if (iUserLoginController.getUserID()==ONE) {
            listOfUserDetails = iUserDetailsDAO.getUserDetails();
        }
        else if(iUserLoginController.getUserID()==TWO){
            listOfUserDetails = iUserDetailsDAO.getOwnersDetails();
        }
        for(UserDetailsModel UserDetailsObject : listOfUserDetails) {
            if(UserDetailsObject.getEmailId().equals(loggedInUserId) ){
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.firstname")+UserDetailsObject.getFirstName());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.lastname")+UserDetailsObject.getLastName());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.contactnumber")+UserDetailsObject.getContactNumber());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.emailid")+UserDetailsObject.getEmailId());
            }
        }
    }
}
