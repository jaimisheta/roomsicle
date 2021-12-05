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
import controller.userprofile.IUserProfile;
import controller.userprofile.UserProfile;
import controller.userregistration.IUserRegistrationController;
import controller.userregistration.UserRegistrationController;
import controller.verifications.EmailVerfierController;
import controller.verifications.*;
import controller.verifications.PasswordVerifierController;
import database.*;
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
    IUserDetailsDAO iUserDetailsDAO;
    IUserProfile iUserProfile;

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
        iUserDetailsDAO=new UserDetailsDAO();
        iUserProfile=new UserProfile();
       }

    public static ClassInitializer initializer() {
        if (initializer == null) {
            initializer = new ClassInitializer();
        }

        return initializer;
    }

    public IUserDetailsDAO getIUserDetailsDAO(){
        return iUserDetailsDAO;
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

    public IUserProfile getiUserProfile(){
       return iUserProfile;
    }

}
