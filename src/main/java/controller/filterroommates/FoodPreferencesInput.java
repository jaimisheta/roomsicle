package controller.filterroommates;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import controller.ControllerProperties;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;
import static controller.filterroommates.FilterRoommatesInputConstants.THREE;

public class FoodPreferencesInput {

    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    public String getFoodPreferences() {
        int foodPreferenceSelect;
        String foodPreference;
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("filter.roommate.food.habits.message"));
        foodPreference = null;
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
        return foodPreference;
    }
}
