package controller.filterroommates;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;
import static controller.filterroommates.FilterRoommatesInputConstants.THREE;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.ControllerProperties;

import java.util.HashMap;

public class FilterRoommatesInput implements IFilterRoommatesInput{

	int foodPreferenceSelect;
    int smokePreferenceSelect;
    int alcoholPreferenceSelect;
    String foodPreference;
    String smokePreference;
    String alcoholPreference;
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    HashMap<Integer,String> foodPreferenceMap = new HashMap<Integer,String>(){{
        foodPreferenceMap.put(ONE, ControllerProperties.getControllerPropertyValue("food.one"));
        foodPreferenceMap.put(TWO, ControllerProperties.getControllerPropertyValue("food.two"));
        foodPreferenceMap.put(THREE, ControllerProperties.getControllerPropertyValue("food.three"));
    }};
    HashMap<Integer,String> smokingPreferenceMap = new HashMap<Integer,String>(){{
        smokingPreferenceMap.put(ONE, ControllerProperties.getControllerPropertyValue("smoke.one"));
        smokingPreferenceMap.put(TWO, ControllerProperties.getControllerPropertyValue("smoke.two"));
        smokingPreferenceMap.put(THREE, ControllerProperties.getControllerPropertyValue("smoke.three"));
    }};
    HashMap<Integer,String> alcoholPreferenceMap = new HashMap<Integer,String>(){{
        alcoholPreferenceMap.put(ONE, ControllerProperties.getControllerPropertyValue("alcohol.one"));
        alcoholPreferenceMap.put(TWO, ControllerProperties.getControllerPropertyValue("alcohol.two"));
        alcoholPreferenceMap.put(THREE, ControllerProperties.getControllerPropertyValue("alcohol.three"));
    }};

    public String[] setPreferences() {
        try {
        	roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.preference.details.message"));
        	roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.food.habits.message"));
            foodPreferenceSelect = roomsicleCLI.getNumberResponse();

            if (foodPreferenceSelect == ONE) {
                foodPreference = ControllerProperties.getControllerPropertyValue("food.one");
            }
            if (foodPreferenceSelect == TWO) {
                foodPreference = ControllerProperties.getControllerPropertyValue("food.two");
            }
            if (foodPreferenceSelect == THREE) {
                foodPreference = ControllerProperties.getControllerPropertyValue("food.three");
            }

        	roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.smoking.habits.message"));
        	smokePreferenceSelect = roomsicleCLI.getNumberResponse();
        	if (smokePreferenceSelect == ONE){
        		smokePreference=ControllerProperties.getControllerPropertyValue("smoke.one");
            }
            if (smokePreferenceSelect == TWO){
                smokePreference=ControllerProperties.getControllerPropertyValue("smoke.two");
            }
            if (smokePreferenceSelect == THREE){
                smokePreference=ControllerProperties.getControllerPropertyValue("smoke.three");
            }
            
        	roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.alcohol.habits.message"));
            alcoholPreferenceSelect = roomsicleCLI.getNumberResponse();
            if (alcoholPreferenceSelect == ONE){
            	alcoholPreference=ControllerProperties.getControllerPropertyValue("alcohol.one");
            }
            if (alcoholPreferenceSelect == TWO){
            	alcoholPreference=ControllerProperties.getControllerPropertyValue("alcohol.two");
            }
            if (alcoholPreferenceSelect == THREE){
            	alcoholPreference=ControllerProperties.getControllerPropertyValue("alcohol.three");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        String preferencesList[] = {foodPreference, smokePreference, alcoholPreference};
        return preferencesList;
    }

}