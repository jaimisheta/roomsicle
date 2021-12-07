package controller;

import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.clicommentlist.MakeCLICommentListController;
import controller.ownerprofile.IOwnerProfile;
import controller.ownerprofile.OwnerProfile;
import controller.ownersurvey.*;
import controller.propertypricepredictor.PropertyPriceCalculator;
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
import controller.usersurvey.*;
import controller.verifications.*;
import database.*;
import models.*;

public class ClassInitializer {
    private static ClassInitializer initializer = null;
    IRoomsicleCLI iroomsicleCLI;
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
    IOwnersDetailsDAO iOwnersDetailsDAO;
    IOwnerProfile iOwnerProfile;
    IOwnerDetailsModel iOwnerDetailsModel;
    IOwnerPropertyDetailsModel iOwnerPropertyDetailsModel;
    IOwnerPropertyDetailsDAO iOwnerPropertyDetailsDAO;
    IUserSurvey userAlcoholHabits;
    IUserSurvey userBudget;
    IUserSurvey userFoodHabits;
    IUserSurvey userGender;
    IUserSurvey userRoommateAlcoholHabitsPreference;
    IUserSurvey userRoommateFoodHabitsPreference;
    IUserSurvey userRoommateGenderPreference;
    IUserSurvey userRoommateSmokingHabitsPreference;
    IUserSurvey userSmokingHabits;
    IUserSurvey userUniversityDistancePreference;
    UserSurveyModel userSurveyModel;
    UserSurveyMain userSurveyMain;
    IUserSurveyDAO userSurveyDAO;
    IOwnerSurvey bedroomCount;
    IOwnerSurvey dalhousieDistance;
    IOwnerSurvey downtownDistance;
    IOwnerSurvey groceryStoreDistance;
    IOwnerSurvey propertyAddress;
    IOwnerSurvey theaterDistance;
    IOwnerSurvey utilities;
    OwnerSurveyModel ownerSurveyModel;
    IOwnerSurveyDAO ownerSurveyDAO;
    OwnerSurveyMain ownerSurveyMain;
    PropertyPriceCalculator propertyPriceCalculator;

    private ClassInitializer() {
        iroomsicleCLI = new RoomsicleCLI();
        iMakeCLICommentListController = new MakeCLICommentListController();
        iuserHomePageController = new UserHomePageController();
        iUserRegistrationDAO = new UserRegistrationDAO();
        iEmailFormatVerfier = new EmailFormatVerifierController();
        iUserLoginDAO = new UserLoginDAO();
        iUsersModel = new UsersModel();
        iEmailVerfierController = new EmailVerfierController();
        iPasswordVerifierController = new PasswordVerifierController();
        iPhoneNumberVerifierController = new PhoneNumberVerifierController();
        iuserRegistrationController = new UserRegistrationController();
        iuserLoginController = new UserLoginController();
        iWelcomePageController = new WelcomePageController();
        iCheckSurveyTaken = new CheckSurveyTaken();
        iUserDetailsDAO = new UserDetailsDAO();
        iUserProfile = new UserProfile();
        iOwnersDetailsDAO = new OwnersDetailsDAO();
        iOwnerProfile = new OwnerProfile();
        iOwnerDetailsModel = new OwnerDetailsModel();
        iOwnerPropertyDetailsModel = new OwnerPropertyDetailsModel();
        iOwnerPropertyDetailsDAO = new OwnerPropertyDetailsDAO();
        userAlcoholHabits = new UserAlcoholHabits();
        userBudget = new UserBudget();
        userFoodHabits = new UserFoodHabits();
        userGender = new UserGender();
        userRoommateAlcoholHabitsPreference = new UserRoommateAlcoholHabitsPreference();
        userRoommateFoodHabitsPreference = new UserRoommateFoodHabitsPreference();
        userRoommateGenderPreference = new UserRoommateGenderPreference();
        userRoommateSmokingHabitsPreference = new UserRoommateSmokingHabitsPreference();
        userSmokingHabits = new UserSmokingHabits();
        userUniversityDistancePreference = new UserUniversityDistancePreference();
        userSurveyModel = new UserSurveyModel();
        userSurveyMain = new UserSurveyMain();
        userSurveyDAO = new UserSurveyDAO();
        bedroomCount = new BedroomCount();
        dalhousieDistance = new DalhousieDistance();
        downtownDistance = new DowntownDistance();
        groceryStoreDistance = new GroceryStoreDistance();
        propertyAddress = new PropertyAddress();
        theaterDistance = new TheaterDistance();
        utilities = new Utilities();
        ownerSurveyModel = new OwnerSurveyModel();
        ownerSurveyDAO = new OwnerSurveyDAO();
        ownerSurveyMain = new OwnerSurveyMain();
        propertyPriceCalculator = new PropertyPriceCalculator();
    }

    public static ClassInitializer initializer() {
        if (initializer == null) {
            initializer = new ClassInitializer();
        }
        return initializer;
    }

    public IOwnerPropertyDetailsDAO getIOwnerPropertyDetailsDAO() {
        return iOwnerPropertyDetailsDAO;
    }

    public IOwnerPropertyDetailsModel getIOwnerPropertyDetailsModel() {
        return iOwnerPropertyDetailsModel;
    }

    public IOwnerDetailsModel getIOwnerDetailsModel() {
        return iOwnerDetailsModel;
    }

    public IOwnersDetailsDAO getIOwnersDetailsDAO() {
        return iOwnersDetailsDAO;
    }

    public IUserDetailsDAO getIUserDetailsDAO() {
        return iUserDetailsDAO;
    }

    public IRoomsicleCLI getIroomsicleCLI() {
        return iroomsicleCLI;
    }

    public IMakeCLICommentListController getIMakeCLICommentListController() {
        return iMakeCLICommentListController;
    }

    public IUserHomePageController getIUserHomePageController() {
        return iuserHomePageController;
    }

    public IUserRegistrationDAO getIUserRegistrationDAO() {
        return iUserRegistrationDAO;
    }

    public IEmailFormatVerfier getIEmailFormatVerfier() {
        return iEmailFormatVerfier;
    }

    public IUserLoginDAO getIUserLoginDAO() {
        return iUserLoginDAO;
    }

    public IUsersModel getIUsersModel() {
        return iUsersModel;
    }

    public IEmailVerifierController getIEmailVerifierController() {
        return iEmailVerfierController;
    }

    public IPasswordVerifierController getIPasswordVerifierController() {
        return iPasswordVerifierController;
    }

    public IPhoneNumberVerifierController getIPhoneNumberVerifierController() {
        return iPhoneNumberVerifierController;
    }

    public IUserRegistrationController getIUserRegistrationController() {
        return iuserRegistrationController;
    }

    public IUserLoginController getUserLoginController() {
        return iuserLoginController;
    }

    public IWelcomePageController getIWelcomePageController() {
        return iWelcomePageController;
    }

    public ICheckSurveyTaken getICheckSurveyTaken() {
        return iCheckSurveyTaken;
    }

    public IUserProfile getiUserProfile() {
        return iUserProfile;
    }

    public IOwnerProfile getiOwnerProfile() {
        return iOwnerProfile;
    }

    public IUserSurvey getUserAlcoholHabits() {
        return userAlcoholHabits;
    }

    public IUserSurvey getUserBudget() {
        return userBudget;
    }

    public IUserSurvey getUserSmokingHabits() {
        return userSmokingHabits;
    }

    public IUserSurvey getUserFoodHabits() {
        return userFoodHabits;
    }

    public IUserSurvey getUserGender() {
        return userGender;
    }

    public IUserSurvey getUserRoommateAlcoholHabitsPreference() {
        return userRoommateAlcoholHabitsPreference;
    }

    public IUserSurvey getUserRoommateFoodHabitsPreference() {
        return userRoommateFoodHabitsPreference;
    }

    public IUserSurvey getUserRoommateGenderPreference() {
        return userRoommateGenderPreference;
    }

    public IUserSurvey getUserRoommateSmokingHabitsPreference() {
        return userRoommateSmokingHabitsPreference;
    }

    public IUserSurvey getUserUniversityDistancePreference() {
        return userUniversityDistancePreference;
    }

    public UserSurveyModel getUserSurveyModel() {
        return userSurveyModel;
    }

    public UserSurveyMain getUserSurveyMain() {
        return userSurveyMain;
    }

    public IUserSurveyDAO getUserSurveyDAO() {
        return userSurveyDAO;
    }

    public IOwnerSurvey getBedroomCount() {
        return bedroomCount;
    }

    public IOwnerSurvey getDalhousieDistance() {
        return dalhousieDistance;
    }

    public IOwnerSurvey getDowntownDistance() {
        return downtownDistance;
    }

    public IOwnerSurvey getGroceryStoreDistance() {
        return groceryStoreDistance;
    }

    public IOwnerSurvey getPropertyAddress() {
        return propertyAddress;
    }

    public IOwnerSurvey getTheaterDistance() {
        return theaterDistance;
    }

    public IOwnerSurvey getUtilities() {
        return utilities;
    }

    public OwnerSurveyModel getOwnerSurveyModel() {
        return ownerSurveyModel;
    }

    public IOwnerSurveyDAO getOwnerSurveyDAO() {
        return ownerSurveyDAO;
    }

    public OwnerSurveyMain getOwnerSurveyMain() {
        return ownerSurveyMain;
    }

    public PropertyPriceCalculator getPropertyPriceCalculator() {
        return propertyPriceCalculator;
    }
}
