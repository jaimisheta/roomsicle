package controller.verifications;

import Exception.EmailException;
import commandline.CommandLineInputProperties;
import controller.ClassInitializer;
import database.IUserLoginDAO;

public class EmailVerfierController implements IEmailVerifierController {


    public void UserEmailAlreadyRegistered(String emailId, String userData)  throws EmailException {
        IUserLoginDAO iUserLoginDAO= ClassInitializer.initializer().getIUserLoginDAO();
        for(String Email:iUserLoginDAO.getUserLoginAndPassword(userData).keySet()){
           if (Email.equals(emailId)){
               throw new EmailException(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.email.exists.message"));
           }
             }
    }
    public void EmailDoesnotExists(String emailId,String userData) throws EmailException {
        IUserLoginDAO iUserLoginDAO= ClassInitializer.initializer().getIUserLoginDAO();
        if (iUserLoginDAO.getUserLoginAndPassword(userData).containsKey(emailId)){
                CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.correct.email.id.message");
                 }
            else{
                throw new EmailException(CommandLineInputProperties.getCommandLineInputPropertyValue("login.fail.message"));
            }
        }

    public String ValidateEmailExists(String emailId,String userData){
        IUserLoginDAO iUserLoginDAO= ClassInitializer.initializer().getIUserLoginDAO();
        String emailMessage;
        if (iUserLoginDAO.getUserLoginAndPassword(userData).containsKey(emailId)){
            emailMessage=CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.correct.email.id.message");
        }else {
            emailMessage= CommandLineInputProperties.getCommandLineInputPropertyValue("login.fail.message");
        }
        return emailMessage;
    }
}

