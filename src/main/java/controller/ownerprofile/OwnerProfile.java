package controller.ownerprofile;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.ClassInitializer;
import controller.ControllerProperties;
import database.IOwnersDetailsDAO;
import models.OwnerDetailsModel;

import java.util.ArrayList;

public class OwnerProfile implements IOwnerProfile {
    public void ownerProfile(){
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        String loggedInUserId;
        loggedInUserId=ControllerProperties.getControllerPropertyValue("user.logged.in.email.id");
        IOwnersDetailsDAO iOwnersDetailsDAO=ClassInitializer.initializer().getIOwnersDetailsDAO();
        ArrayList<OwnerDetailsModel> listOfOwnerDetails;
        listOfOwnerDetails = iOwnersDetailsDAO.getOwnersDetails();

        for(OwnerDetailsModel ownerDetailsObject : listOfOwnerDetails) {
            if(ownerDetailsObject.getEmailId().equals(loggedInUserId) ){
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.firstname")+ownerDetailsObject.getFirstName());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.lastname")+ownerDetailsObject.getLastName());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.contactnumber")+ownerDetailsObject.getContactNumber());
                iRoomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bestfit.roommate.display.user.emailid")+ownerDetailsObject.getEmailId());
            }
        }
    }
}
