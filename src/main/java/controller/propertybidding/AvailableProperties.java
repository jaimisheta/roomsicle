package controller.propertybidding;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import database.PropertyDetailsDAO;
import database.PropertyOwnersDAO;
import models.PropertyDetailsModel;
import models.PropertyOwnerModel;

import java.util.ArrayList;

public class AvailableProperties {

    //public static void main(String args[]) {
    public void displayProperties(){
        IRoomsicleCLI roomsicleCLI = new RoomsicleCLI();
        PropertyOwnersDAO propertiesOwners = new PropertyOwnersDAO();
        ArrayList<PropertyOwnerModel> listOfPropertyOwners = propertiesOwners.getPropertyOwnerDetails();
        System.out.println(propertiesOwners.getPropertyOwnerDetails().get(2).getEmailId());

        PropertyDetailsDAO propertiesDetails = new PropertyDetailsDAO();
        ArrayList<PropertyDetailsModel> listOfPropertyDetails = propertiesDetails.getPropertyDetails();

        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("properties.display.page.opening"));
        for(PropertyDetailsModel propertyDetailsObject : listOfPropertyDetails) {
            for(PropertyOwnerModel propertyOwnerObject : listOfPropertyOwners){
                if(propertyOwnerObject.getEmailId().equals(propertyDetailsObject.getOwnerId())){
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.owner.display.firstname")+propertyOwnerObject.getFirstName());
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.owner.display.contactnumber")+propertyOwnerObject.getContactNumber());
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.owner.display.emailid")+propertyOwnerObject.getEmailId());
                    break;
                }
            }
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.details.display.propertyid")+propertyDetailsObject.getPropertyId());
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.details.display.propertyrent")+(propertyDetailsObject.getPropertyPrice()/4));
        }

    }
}
