package controller.propertybidding;

import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import controller.ControllerProperties;
import database.BiddingDAO;
import database.PropertyBidderDAO;
import database.PropertyDetailsDAO;
import models.BiddingDetailsModel;
import models.PropertyDetailsModel;

import java.util.ArrayList;

public class BidProperty {

    public static void main(String args[]){
    //public void bidProperty(){
        IRoomsicleCLI roomsicleCLI = new RoomsicleCLI();

        PropertyDetailsDAO propertiesDetails = new PropertyDetailsDAO();
        ArrayList<PropertyDetailsModel> listOfPropertyDetails = propertiesDetails.getPropertyDetails();

        AvailableProperties availableProperties = new AvailableProperties();
        availableProperties.displayProperties();

        PropertyBidderDAO propertyBidderDAO = new PropertyBidderDAO();
        ArrayList<BiddingDetailsModel> listOfPropertyBidders = propertyBidderDAO.getPropertyBidDetails();

        BiddingDAO biddingDAO = new BiddingDAO();

        System.out.println("Enter property ID you want to bid:");
        int propertyIdSelected = roomsicleCLI.getNumberResponse();

        BiddingDetailsModel bidObject = new BiddingDetailsModel();
        int propertyBidded = 0;
        int currentBid = 0;
        BiddingDetailsModel selectedPropertyForBid = new BiddingDetailsModel();

        for(PropertyDetailsModel propertyDetailsObject : listOfPropertyDetails) {

            if(propertyDetailsObject.getPropertyId().equals(String.valueOf(Integer.valueOf(propertyIdSelected)))){
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.details.display.propertyid")+propertyDetailsObject.getPropertyId());
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("property.details.display.individualrent")+(propertyDetailsObject.getPropertyPrice()/4));

                for(BiddingDetailsModel biddingDetailsObject : listOfPropertyBidders){
                    if(biddingDetailsObject.getPropertyId().equals(propertyDetailsObject.getPropertyId())){
                        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bid.price")+biddingDetailsObject.getBid());
                        propertyBidded = 1;
//                        currentBid = biddingDetailsObject.getBid();
                        selectedPropertyForBid.setBid(biddingDetailsObject.getBid());
                        selectedPropertyForBid.setPropertyId(String.valueOf(Integer.valueOf(propertyIdSelected)));
                        selectedPropertyForBid.setUserEmailId(ControllerProperties.getControllerPropertyValue("loggedInUser"));
                    }
                }
                if(propertyBidded==0) {
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bid.price.nobids"));
                }
            }
        }
        System.out.println("Enter your bid:");
        //System.out.println("Current highest bid on this property:"+);
        bidObject.setBid(roomsicleCLI.getNumberResponse());
        if(propertyBidded==0 || (propertyBidded==1 && bidObject.getBid()>selectedPropertyForBid.getBid())){
            for(PropertyDetailsModel propertyDetailsObject : listOfPropertyDetails) {
                if (propertyDetailsObject.getPropertyId().equals(String.valueOf(Integer.valueOf(propertyIdSelected)))) {
                    bidObject.setPropertyId(propertyDetailsObject.getPropertyId());
                    bidObject.setUserEmailId(ControllerProperties.getControllerPropertyValue("loggedInUser"));
                    biddingDAO.enterBid(bidObject);
                    roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bid.placed"));
                    break;
                }
            }
        }
        else{
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("bid.error.message"));
        }
    }

}
