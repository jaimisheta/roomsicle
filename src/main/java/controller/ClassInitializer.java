package controller;

import commandline.IRoomsicleCLI;
import commandline.RoomsicleCLI;
import controller.bestfitroommates.BestFitRoommateController;
import controller.bestfitroommates.BestFitRoommatesDisplayController;
import controller.bestfitroommates.IBestFitRoommateController;
import controller.bestfitroommates.IBestFitRoommatesDisplayController;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.clicommentlist.MakeCLICommentListController;
import controller.filterroommates.*;
import controller.getloggedinuser.GetLoggedInUserController;
import controller.getloggedinuser.IGetLoggedInUserController;
import controller.ownerprofile.IOwnerProfile;
import controller.ownerprofile.OwnerProfile;
import controller.propertybidding.AvailableProperties;
import controller.propertybidding.BidProperty;
import controller.propertybidding.IAvailableProperties;
import controller.propertybidding.IBidProperty;
import controller.userprofile.IUserHomePageController;
import controller.welcomepage.IWelcomePageController;
import controller.userprofile.UserHomePageController;
import controller.welcomepage.WelcomePageController;
import controller.ownersurvey.*;
import controller.propertypricepredictor.*;
import controller.userlogin.*;
import controller.ownersurvey.*;
import controller.propertypricepredictor.PropertyPriceCalculator;
import controller.userlogin.CheckSurveyTaken;
import controller.userlogin.ICheckSurveyTaken;
import controller.userlogin.IUserLoginController;
import controller.userlogin.UserLoginController;
import controller.userprofile.IUserHomePageController;
import controller.userprofile.IUserProfile;
import controller.userprofile.UserHomePageController;
import controller.userprofile.UserProfile;
import controller.userregistration.IUserRegistrationController;
import controller.userregistration.UserRegistrationController;
import controller.usersurvey.*;
import controller.verifications.*;
import controller.welcomepage.IWelcomePageController;
import controller.welcomepage.WelcomePageController;
import database.*;
import database.expensesettleupdao.ExpenseSettleUpDAO;
import database.expensesettleupdao.IExpenseSettleUpDAO;
import database.fitroommatesdao.IUserPreferencesDAO;
import database.UserDetailsDAO;
import database.fitroommatesdao.UserPreferencesDAO;
import database.ownerdetailsdao.IOwnersDetailsDAO;
import database.ownerdetailsdao.OwnersDetailsDAO;
import database.ownerpropertydetailsdao.IOwnerPropertyDetailsDAO;
import database.ownerpropertydetailsdao.OwnerPropertyDetailsDAO;
import database.IUserDetailsDAO;
import database.propertybiddingdao.*;
import database.propertybiddingdao.PropertyDetailsDAO;
import database.surveytakendao.ISurveyTakenDAO;
import database.surveytakendao.SurveyTakenDAO;
import database.userlogindao.IUserLoginDAO;
import database.userlogindao.UserLoginDAO;
import database.userregistrationdao.IUserRegistrationDAO;
import database.userregistrationdao.UserRegistrationDAO;
import models.*;
import models.expensesettleup.ExpenseSettleUpModel;
import models.expensesettleup.IExpenseSettleUpModel;
import models.OwnerSurveyModel;
import models.PropertyPriceCalculatorModel;
import models.SystemGeneratedPropertiesModel;
import models.UserSurveyModel;
import models.biddingmodels.*;
import models.fitroommatemodels.IUserDetailsModel;
import models.fitroommatemodels.IUserPreferenceModel;
import models.fitroommatemodels.UserPreferencesModel;
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
    IUserPreferencesDAO userPreferencesDAO;
    IGetLoggedInUserController getLoggedInUserController;
    IFilterRoommates filterRoommates;
    IFilterRoommatesInput filterRoommatesInput;
    IFilterRoommatesDisplayController filterRoommatesDisplayController;
    IAvailableProperties availableProperties;
    IBidProperty bidProperty;
    IBiddingDAO biddingDAO;
    IBiddingDetailsModel biddingDetailsModel;
    IPropertyDetailsModel propertyDetailsModel;
    IPropertyBidderDAO propertyBidderDAO;
    IPropertyDetailsDAO propertyDetailsDAO;
    IPropertyOwnersDAO propertyOwnersDAO;
    IUserDetailsModel userDetailsModel;
    IUserPreferenceModel userPreferenceModel;
    IPropertyOwnerDetails propertyOwnerDetails;
    IBestFitRoommateController bestFitRoommateController;
    IBestFitRoommatesDisplayController bestFitRoommatesDisplayController;
    PropertyPriceCalculatorModel propertyPriceCalculatorModel;
    IPropertyPricePredictorDAO propertyPricePredictorDAO;
    IDistanceBasedPriceCalculator distanceBasedDalhousiePrice;
    IDistanceBasedPriceCalculator distanceBasedGroceryStorePrice;
    IDistanceBasedPriceCalculator distanceBasedDowntownPrice;
    IDistanceBasedPriceCalculator distanceBasedTheaterPrice;
    LocationBasedPriceFactory locationBasedPriceFactory;
    LocationBasedPrice dalhousieDistancePrice;
    LocationBasedPrice groceryStoreDistancePrice;
    LocationBasedPrice downtownDistancePrice;
    LocationBasedPrice theaterDistancePrice;
    ICalculateIndividualFeaturePrice distanceBasedTotalPrice;
    ICalculateIndividualFeaturePrice propertyBasePrice;
    ICalculateIndividualFeaturePrice utilitiesBasedPrice;
    ISystemGeneratedPropertiesDAO systemGeneratedPropertiesDAO;
    SystemGeneratedPropertiesModel systemGeneratedPropertiesModel;
    IExpenseAdditionDAO expenseAdditionDAO;
    IExpenseAdditionModel expenseAdditionModel;
    IExpenseSettleUpDAO expenseSettleUpDAO;
    IExpenseSettleUpModel expenseSettleUpModel;

    private ClassInitializer() {
        roomsicleCLI = new RoomsicleCLI();
        makeCLICommentListController = new MakeCLICommentListController();
        userHomePageController = new UserHomePageController();
        userRegistrationDAO = new UserRegistrationDAO();
        emailFormatVerfier = new EmailFormatVerifierController();
        userLoginDAO = new UserLoginDAO();
        usersModel = new UsersModel();
        emailVerfierController = new EmailVerfierController();
        passwordVerifierController = new PasswordVerifierController();
        phoneNumberVerifierController = new PhoneNumberVerifierController();
        userRegistrationController = new UserRegistrationController();
        userLoginController = new UserLoginController();
        welcomePageController = new WelcomePageController();
        checkSurveyTaken = new CheckSurveyTaken();
        userDetailsDAO = new UserDetailsDAO();
        userProfile = new UserProfile();
        ownersDetailsDAO = new OwnersDetailsDAO();
        ownerProfile = new OwnerProfile();
        ownerDetailsModel = new OwnerDetailsModel();
        ownerPropertyDetailsModel = new OwnerPropertyDetailsModel();
        ownerPropertyDetailsDAO = new OwnerPropertyDetailsDAO();
        checkCredentials = new CheckCredentials();
        afterCheckingCredintials = new AfterCheckingCredintials();
        giveCredintials = new GiveCredintials();
        passwordValidity = new PasswordValidity();
        surveyTakenDAO = new SurveyTakenDAO();
        userIdValidation = new UserIdValidation();
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
        userPreferencesDAO = new UserPreferencesDAO();
        userDetailsDAO = new UserDetailsDAO();
        getLoggedInUserController = new GetLoggedInUserController();
        filterRoommates = new FilterRoommates();
        filterRoommatesInput = new FilterRoommatesInput();
        filterRoommatesDisplayController = new FilterRoommatesDisplayController();
        availableProperties = new AvailableProperties();
        bidProperty = new BidProperty();
        biddingDAO = new BiddingDAO();
        biddingDetailsModel = new BiddingDetailsModel();
        propertyBidderDAO = new PropertyBidderDAO();
        propertyDetailsModel = new PropertyDetailsModel();
        propertyOwnersDAO = new PropertyOwnersDAO();
        propertyDetailsDAO = new PropertyDetailsDAO();
        userDetailsDAO = new UserDetailsDAO();
        userPreferencesDAO = new UserPreferencesDAO();
        propertyOwnerDetails = new PropertyOwnerModel();
        userPreferenceModel = new UserPreferencesModel();
        bestFitRoommateController = new BestFitRoommateController();
        bestFitRoommatesDisplayController = new BestFitRoommatesDisplayController();
        propertyPriceCalculatorModel = new PropertyPriceCalculatorModel();
        propertyPricePredictorDAO = new PropertyPricePredictorDAO();
        distanceBasedDalhousiePrice = new DistanceBasedDalhousiePrice();
        distanceBasedGroceryStorePrice = new DistanceBasedGroceryStorePrice();
        distanceBasedDowntownPrice = new DistanceBasedDowntownPrice();
        distanceBasedTheaterPrice = new DistanceBasedTheaterPrice();
        locationBasedPriceFactory = new LocationBasedPriceFactory();
        dalhousieDistancePrice = new DalhousieDistancePrice();
        groceryStoreDistancePrice = new GroceryStoreDistancePrice();
        downtownDistancePrice = new DowntownDistancePrice();
        theaterDistancePrice = new TheaterDistancePrice();
        distanceBasedTotalPrice = new DistanceBasedTotalPrice();
        propertyBasePrice = new PropertyBasePrice();
        utilitiesBasedPrice = new UtilitiesBasedPrice();
        systemGeneratedPropertiesDAO = new SystemGeneratedPropertiesDAO();
        systemGeneratedPropertiesModel = new SystemGeneratedPropertiesModel();
        expenseAdditionDAO = new ExpenseAdditionDAO();
        expenseAdditionModel = new ExpenseAdditionModel();
        expenseSettleUpDAO = new ExpenseSettleUpDAO();
        expenseSettleUpModel = new ExpenseSettleUpModel();
    }

    public static ClassInitializer initializer() {
        if (initializer == null) {
            initializer = new ClassInitializer();
        }
        return initializer;
    }

    public IUserIdValidation getIUserIdValidation() {
        return userIdValidation;
    }

    public ISurveyTakenDAO getISurveyTakenDAO() {
        return surveyTakenDAO;
    }

    public IPasswordValidity getIPasswordValidity() {
        return passwordValidity;
    }

    public IGiveCredintials getIGiveCredintials() {
        return giveCredintials;
    }

    public IAfterCheckingCredintials getIAfterCheckingCredintials() {
        return afterCheckingCredintials;
    }

    public ICheckCredentials getICheckCredentials() {
        return checkCredentials;
    }

    public IOwnerPropertyDetailsDAO getIOwnerPropertyDetailsDAO() {
        return ownerPropertyDetailsDAO;
    }

    public IOwnerPropertyDetailsModel getIOwnerPropertyDetailsModel() {
        return ownerPropertyDetailsModel;
    }

    public IOwnerDetailsModel getIOwnerDetailsModel() {
        return ownerDetailsModel;
    }

    public IOwnersDetailsDAO getIOwnersDetailsDAO() {
        return ownersDetailsDAO;
    }

    public IUserDetailsDAO getIUserDetailsDAO() {
        return userDetailsDAO;
    }

    public IRoomsicleCLI getRoomsicleCLI() {
        return roomsicleCLI;
    }

    public IMakeCLICommentListController getIMakeCLICommentListController() {
        return makeCLICommentListController;
    }

    public IUserHomePageController getIUserHomePageController() {
        return userHomePageController;
    }

    public IUserRegistrationDAO getIUserRegistrationDAO() {
        return userRegistrationDAO;
    }

    public IEmailFormatVerfier getIEmailFormatVerfier() {
        return emailFormatVerfier;
    }

    public IUserLoginDAO getIUserLoginDAO() {
        return userLoginDAO;
    }

    public IUsersModel getIUsersModel() {
        return usersModel;
    }

    public IEmailVerifierController getIEmailVerifierController() {
        return emailVerfierController;
    }

    public IPasswordVerifierController getIPasswordVerifierController() {
        return passwordVerifierController;
    }

    public IPhoneNumberVerifierController getIPhoneNumberVerifierController() {
        return phoneNumberVerifierController;
    }

    public IUserRegistrationController getIUserRegistrationController() {
        return userRegistrationController;
    }

    public IUserLoginController getUserLoginController() {
        return userLoginController;
    }

    public IWelcomePageController getIWelcomePageController() {
        return welcomePageController;
    }

    public ICheckSurveyTaken getICheckSurveyTaken() {
        return checkSurveyTaken;
    }

    public IUserProfile getUserProfile() {
        return userProfile;
    }

    public IOwnerProfile getOwnerProfile() {
        return ownerProfile;
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

    public IUserPreferencesDAO getUserPreferenceDAO() {
        return userPreferencesDAO;
    }

    public IUserDetailsDAO getUserDetailsDAO(){
        return userDetailsDAO;
    }

    public IGetLoggedInUserController getLoggedInUserController(){
        return getLoggedInUserController;
    }

    public IFilterRoommates getFilterRoommates(){
        return filterRoommates;
    }

    public IFilterRoommatesInput getFilterRoommatesInput(){
        return filterRoommatesInput;
    }

    public IFilterRoommatesDisplayController getFilterRoommatesDisplayController(){
        return filterRoommatesDisplayController;
    }

    public IAvailableProperties getAvailableProperties(){
        return availableProperties;
    }

    public IBidProperty getBidProperty(){
        return bidProperty;
    }

    public IBiddingDAO getBiddingDAO(){
        return biddingDAO;
    }

    public IPropertyBidderDAO getPropertyBidderDAO(){
        return propertyBidderDAO;
    }

    public IPropertyOwnersDAO getPropertyOwnersDAO(){
        return propertyOwnersDAO;
    }

    public IPropertyDetailsDAO getPropertyDetailsDAO(){
        return propertyDetailsDAO;
    }

    public IBiddingDetailsModel getBiddingDetailsModel(){
        return biddingDetailsModel;
    }

    public IPropertyOwnerDetails getPropertyOwnerDetails(){
        return propertyOwnerDetails;
    }

    public IPropertyDetailsModel propertyDetailsModel(){
        return propertyDetailsModel;
    }

    public IUserDetailsModel getUserDetailsModel(){
        return userDetailsModel;
    }

    public IUserPreferenceModel getUserPreferenceModel(){
        return userPreferenceModel;
    }

    public IBestFitRoommateController getBestFitRoommateController(){
        return bestFitRoommateController;
    }

    public IBestFitRoommatesDisplayController getBestFitRoommatesDisplayController(){
        return bestFitRoommatesDisplayController;
    }


    public PropertyPriceCalculatorModel getPropertyPriceCalculatorModel() {
        return propertyPriceCalculatorModel;
    }

    public IPropertyPricePredictorDAO getPropertyPricePredictorDAO() {
        return propertyPricePredictorDAO;
    }

    public IDistanceBasedPriceCalculator getDistanceBasedDalhousiePrice() {
        return distanceBasedDalhousiePrice;
    }

    public IDistanceBasedPriceCalculator getDistanceBasedGroceryStorePrice() {
        return distanceBasedGroceryStorePrice;
    }

    public IDistanceBasedPriceCalculator getDistanceBasedDowntownPrice() {
        return distanceBasedDowntownPrice;
    }

    public IDistanceBasedPriceCalculator getDistanceBasedTheaterPrice() {
        return distanceBasedTheaterPrice;
    }

    public LocationBasedPriceFactory getLocationBasedPriceFactory() {
        return locationBasedPriceFactory;
    }

    public LocationBasedPrice getDalhousieDistancePrice() {
        return dalhousieDistancePrice;
    }

    public LocationBasedPrice getGroceryStoreDistancePrice() {
        return groceryStoreDistancePrice;
    }

    public LocationBasedPrice getDowntownDistancePrice() {
        return downtownDistancePrice;
    }

    public LocationBasedPrice getTheaterDistancePrice() {
        return theaterDistancePrice;
    }

    public ICalculateIndividualFeaturePrice getDistanceBasedTotalPrice() {
        return distanceBasedTotalPrice;
    }

    public ICalculateIndividualFeaturePrice getPropertyBasePrice() {
        return propertyBasePrice;
    }

    public ICalculateIndividualFeaturePrice getUtilitiesBasedPrice() {
        return utilitiesBasedPrice;
    }

    public ISystemGeneratedPropertiesDAO getSystemGeneratedPropertiesDAO() {
        return systemGeneratedPropertiesDAO;
    }

    public SystemGeneratedPropertiesModel getSystemGeneratedPropertiesModel() {
        return systemGeneratedPropertiesModel;
    }

    public IExpenseAdditionDAO getIExpenseAdditionDAO() {
        return expenseAdditionDAO;
    }

    public IExpenseAdditionModel getIExpenseAdditionModel() {
        return expenseAdditionModel;
    }

    public IExpenseSettleUpDAO getIExpenseSettleUpDAO() {
        return expenseSettleUpDAO;
    }

    public IExpenseSettleUpModel getIExpenseSettleUpModel() {
        return expenseSettleUpModel;
    }
}
