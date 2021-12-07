package controller;

import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.clicommentlist.MakeCLICommentListController;
import controller.ownerprofile.IOwnerProfile;
import controller.ownerprofile.OwnerProfile;
import controller.userprofile.IUserHomePageController;
import controller.welcomepage.IWelcomePageController;
import controller.userprofile.UserHomePageController;
import controller.welcomepage.WelcomePageController;
import controller.userlogin.*;
import controller.userprofile.IUserProfile;
import controller.userprofile.UserProfile;
import controller.userregistration.IUserRegistrationController;
import controller.userregistration.UserRegistrationController;
import controller.verifications.EmailVerfierController;
import controller.verifications.*;
import controller.verifications.PasswordVerifierController;
import database.*;
import database.ownerdetailsdao.IOwnersDetailsDAO;
import database.ownerdetailsdao.OwnersDetailsDAO;
import database.ownerpropertydetailsdao.IOwnerPropertyDetailsDAO;
import database.ownerpropertydetailsdao.OwnerPropertyDetailsDAO;
import database.IUserDetailsDAO;
import database.surveytakendao.ISurveyTakenDAO;
import database.surveytakendao.SurveyTakenDAO;
import database.userlogindao.IUserLoginDAO;
import database.userlogindao.UserLoginDAO;
import database.userregistrationdao.IUserRegistrationDAO;
import database.userregistrationdao.UserRegistrationDAO;
import models.ownerdetailsmodel.IOwnerDetailsModel;
import models.ownerdetailsmodel.OwnerDetailsModel;
import models.ownerpropertydetailsmodel.IOwnerPropertyDetailsModel;
import models.ownerpropertydetailsmodel.OwnerPropertyDetailsModel;
import models.usermodel.IUsersModel;
import models.usermodel.UsersModel;

public class ClassInitializer {
    private static ClassInitializer initializer = null;
    IRoomsicleCLI roomsicleCLI;
    IMakeCLICommentListController makeCLICommentListController;
    IUserHomePageController userHomePageController;
    IUserRegistrationDAO userRegistrationDAO;
    IEmailFormatVerfier emailFormatVerfier;
    IUserLoginDAO userLoginDAO;
    IUsersModel usersModel;
    IEmailVerifierController emailVerfierController;
    IPasswordVerifierController passwordVerifierController;
    IPhoneNumberVerifierController phoneNumberVerifierController;
    IUserRegistrationController userRegistrationController;
    IUserLoginController userLoginController;
    IWelcomePageController welcomePageController;
    ICheckSurveyTaken checkSurveyTaken;
    IUserDetailsDAO userDetailsDAO;
    IUserProfile userProfile;
    IOwnersDetailsDAO ownersDetailsDAO;
    IOwnerProfile ownerProfile;
    IOwnerDetailsModel ownerDetailsModel;
    IOwnerPropertyDetailsModel ownerPropertyDetailsModel;
    IOwnerPropertyDetailsDAO ownerPropertyDetailsDAO;
    ICheckCredentials checkCredentials;
    IAfterCheckingCredintials afterCheckingCredintials;
    IGiveCredintials giveCredintials;
    IPasswordValidity passwordValidity;
    ISurveyTakenDAO surveyTakenDAO;
    IUserIdValidation userIdValidation;

   private ClassInitializer()

    {
        roomsicleCLI = new RoomsicleCLI();
        makeCLICommentListController =new MakeCLICommentListController();
        userHomePageController =new UserHomePageController();
        userRegistrationDAO =new UserRegistrationDAO();
        emailFormatVerfier =new EmailFormatVerifierController();
        userLoginDAO =new UserLoginDAO();
        usersModel =new UsersModel();
        emailVerfierController =new EmailVerfierController();
        passwordVerifierController =new PasswordVerifierController();
        phoneNumberVerifierController =new PhoneNumberVerifierController();
        userRegistrationController =new UserRegistrationController();
        userLoginController =new UserLoginController();
        welcomePageController =new WelcomePageController();
        checkSurveyTaken =new CheckSurveyTaken();
        userDetailsDAO =new UserDetailsDAO();
        userProfile =new UserProfile();
        ownersDetailsDAO =new OwnersDetailsDAO();
        ownerProfile =new OwnerProfile();
        ownerDetailsModel =new OwnerDetailsModel();
        ownerPropertyDetailsModel =new OwnerPropertyDetailsModel();
        ownerPropertyDetailsDAO =new OwnerPropertyDetailsDAO();
        checkCredentials=new CheckCredentials();
        afterCheckingCredintials=new AfterCheckingCredintials();
        giveCredintials=new GiveCredintials();
        passwordValidity=new PasswordValidity();
        surveyTakenDAO=new SurveyTakenDAO();
        userIdValidation=new UserIdValidation();
       }

    public static ClassInitializer initializer() {
        if (initializer == null) {
            initializer = new ClassInitializer();
        }

        return initializer;
    }

    public IUserIdValidation getIUserIdValidation(){return userIdValidation; }

    public ISurveyTakenDAO getISurveyTakenDAO(){return surveyTakenDAO; }

    public IPasswordValidity getIPasswordValidity(){return passwordValidity; }

    public IGiveCredintials getIGiveCredintials(){return giveCredintials; }

    public IAfterCheckingCredintials getIAfterCheckingCredintials(){return afterCheckingCredintials; }

    public ICheckCredentials getICheckCredentials(){return checkCredentials; }

    public IOwnerPropertyDetailsDAO getIOwnerPropertyDetailsDAO(){return ownerPropertyDetailsDAO; }

    public IOwnerPropertyDetailsModel getIOwnerPropertyDetailsModel(){return ownerPropertyDetailsModel;}

    public IOwnerDetailsModel getIOwnerDetailsModel(){
        return ownerDetailsModel;
    }

    public IOwnersDetailsDAO getIOwnersDetailsDAO(){
        return ownersDetailsDAO;
    }

    public IUserDetailsDAO getIUserDetailsDAO(){
        return userDetailsDAO;
    }

    public IRoomsicleCLI getRoomsicleCLI(){
       return roomsicleCLI;
    }

    public IMakeCLICommentListController getIMakeCLICommentListController(){
        return makeCLICommentListController;
    }

    public IUserHomePageController getIUserHomePageController(){
        return userHomePageController;
    }

    public IUserRegistrationDAO getIUserRegistrationDAO(){
        return userRegistrationDAO;
    }

    public IEmailFormatVerfier getIEmailFormatVerfier(){
        return emailFormatVerfier;
    }

    public IUserLoginDAO getIUserLoginDAO(){
        return userLoginDAO;
    }

    public IUsersModel getIUsersModel(){
        return usersModel;
    }

    public IEmailVerifierController getIEmailVerifierController(){
        return emailVerfierController;
    }

    public IPasswordVerifierController getIPasswordVerifierController(){
        return passwordVerifierController;
    }

    public IPhoneNumberVerifierController getIPhoneNumberVerifierController(){
        return phoneNumberVerifierController;
    }

    public IUserRegistrationController getIUserRegistrationController(){
        return userRegistrationController;
    }

    public IUserLoginController getUserLoginController(){
        return userLoginController;
    }

    public IWelcomePageController getIWelcomePageController(){
        return welcomePageController;
    }

    public ICheckSurveyTaken getICheckSurveyTaken(){
        return checkSurveyTaken;
    }

    public IUserProfile getUserProfile(){
       return userProfile;
    }

    public IOwnerProfile getOwnerProfile(){
        return ownerProfile;
    }

}
