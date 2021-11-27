package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;

public class UserHomePageController {
    public void showUserHomePageController(){
        RoomsicleCLI roomsicleCLI=new RoomsicleCLI();
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.main.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.my.profile.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.my.best.git.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.filter.roommate.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.system.suggested.properties.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.system.checkout.properties.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.expense.management.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("user.home.page.logout.option.message"));
    }
}

