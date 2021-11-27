package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import Exception.*;

import java.sql.SQLException;

public class WelcomePageController {
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    int userSelection;
    public void showWelcomePage() throws EmailException, SQLException, PasswordNotMatchException {
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.welcome.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.welcome.select.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.welcome.select.choice.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.welcome.select.user.choice.message"));
        userSelection = roomsicleCLI.getNumberResponse();
        if (userSelection==1){
            UserLoginController userLoginController =new UserLoginController();
        }
        else if (userSelection==2){
           UserRegistrationController userRegistrationController=new UserRegistrationController();
        }
        else{
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
        }
    }
    }
