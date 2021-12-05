package controller;

import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.clicommentlist.MakeCLICommentListController;
import controller.userhomepage.IUserHomePageController;
import controller.userhomepage.IWelcomePageController;
import controller.userhomepage.UserHomePageController;
import controller.userhomepage.WelcomePageController;
import controller.userlogin.CheckSurveyTaken;
import controller.userlogin.ICheckSurveyTaken;
import controller.userlogin.IUserLoginController;
import controller.userlogin.UserLoginController;
import controller.userregistration.IUserRegistrationController;
import controller.userregistration.UserRegistrationController;
import controller.verifications.EmailVerfierController;
import controller.verifications.*;
import controller.verifications.PasswordVerifierController;
import database.IUserLoginDAO;
import database.IUserRegistrationDAO;
import database.UserLoginDAO;
import database.UserRegistrationDAO;
import models.IUsersModel;
import models.UsersModel;

public class ClassInitializer {
    private static ClassInitializer initializer = null;
    IRoomsicleCLI iroomsicleCLI ;
    IMakeCLICommentListController iMakeCLICommentListController;
    IUserHomePageController iuserHomePageController;
    IUserRegistrationDAO iUserRegistrationDAO;
    IEmailFormatVerfier iEmailFormatVerfier;
    IUserLoginDAO iUserLoginDAO;
    IUsersModel iUsersModel;
    IEmailVerifierController iEmailVerfierController;
    IPasswordVerifierController iPasswordVerifierController;
    IPhoneNumberVerifierController iPhoneNumberVerifierController;
    IUserRegistrationController iuserRegistrationController;
    IUserLoginController iuserLoginController;
    IWelcomePageController iWelcomePageController;
    ICheckSurveyTaken iCheckSurveyTaken;
   private ClassInitializer()

    {
        iroomsicleCLI = new RoomsicleCLI();
        iMakeCLICommentListController=new MakeCLICommentListController();
        iuserHomePageController=new UserHomePageController();
        iUserRegistrationDAO=new UserRegistrationDAO();
        iEmailFormatVerfier=new EmailFormatVerifierController();
        iUserLoginDAO=new UserLoginDAO();
        iUsersModel=new UsersModel();
        iEmailVerfierController=new EmailVerfierController();
        iPasswordVerifierController=new PasswordVerifierController();
        iPhoneNumberVerifierController=new PhoneNumberVerifierController();
        iuserRegistrationController=new UserRegistrationController();
        iuserLoginController =new UserLoginController();
        iWelcomePageController=new WelcomePageController();
        iCheckSurveyTaken=new CheckSurveyTaken();
       }

    public static ClassInitializer initializer() {
        if (initializer == null) {
            initializer = new ClassInitializer();
        }

        return initializer;
    }

    public IRoomsicleCLI getIroomsicleCLI(){
       return iroomsicleCLI;
    }

    public IMakeCLICommentListController getIMakeCLICommentListController(){
        return iMakeCLICommentListController;
    }

    public IUserHomePageController getIUserHomePageController(){
        return iuserHomePageController;
    }

    public IUserRegistrationDAO getIUserRegistrationDAO(){
        return iUserRegistrationDAO;
    }

    public IEmailFormatVerfier getIEmailFormatVerfier(){
        return iEmailFormatVerfier;
    }

    public IUserLoginDAO getIUserLoginDAO(){
        return iUserLoginDAO;
    }

    public IUsersModel getIUsersModel(){
        return iUsersModel;
    }

    public IEmailVerifierController getIEmailVerifierController(){
        return iEmailVerfierController;
    }

    public IPasswordVerifierController getIPasswordVerifierController(){
        return iPasswordVerifierController;
    }

    public IPhoneNumberVerifierController getIPhoneNumberVerifierController(){
        return iPhoneNumberVerifierController;
    }

    public IUserRegistrationController getIUserRegistrationController(){
        return iuserRegistrationController;
    }

    public IUserLoginController getUserLoginController(){
        return iuserLoginController;
    }

    public IWelcomePageController getIWelcomePageController(){
        return iWelcomePageController;
    }

    public ICheckSurveyTaken getICheckSurveyTaken(){
        return iCheckSurveyTaken;
    }

}
