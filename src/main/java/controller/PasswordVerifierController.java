package controller;

import Exception.*;
import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;


public class PasswordVerifierController {
    RoomsicleCLI roomsicleCLI=new RoomsicleCLI();
    public void PasswordVerifierController( String password,String confirmPassword) throws PasswordNotMatchException {
       if (password.equals(confirmPassword)){
           roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.password.match.message"));
       }else {
           throw new PasswordNotMatchException(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.password.do.not.match.message"));
       }
    }
}
