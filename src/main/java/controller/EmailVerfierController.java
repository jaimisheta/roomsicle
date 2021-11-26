package controller;

import commandline.CommandLineInputProperties;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Exception.*;
import database.UserLoginDAO;


public class EmailVerfierController {
    UserLoginDAO userLoginDAO=new UserLoginDAO();
    public void EmailVerfier(String email) throws EmailException {
        WelcomePageController welcomePageController=new WelcomePageController();
        Pattern pattern;
        Matcher matcher;
        String regex = CommandLineInputProperties.getCommandLineInputPropertyValue("login.email.id.verify");
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(email);

        if (matcher.matches() == false) {
            throw new EmailException(CommandLineInputProperties.getCommandLineInputPropertyValue("login.email.verify.wrong"));
        }

    }
    public void EmailAlreadyRegistered(String emailId) throws SQLException, EmailException {
        for(String Email:userLoginDAO.getUserLoginAndPassword().keySet()){

           if (Email.equals(emailId)){
               throw new EmailException(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.email.exists.message"));

           }
             }


    }

}