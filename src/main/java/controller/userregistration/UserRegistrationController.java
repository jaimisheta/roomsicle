package controller.userregistration;

import Exception.InvalidInputException;
import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.verifications.IEmailFormatVerfier;
import controller.verifications.IEmailVerifierController;
import controller.verifications.IPasswordVerifierController;
import controller.verifications.IPhoneNumberVerifierController;
import database.DatabaseQueryProperties;
import database.IUserRegistrationDAO;
import models.IUsersModel;

import static controller.userhomepage.WelcomePageController.userId;
import static controller.userregistration.UserRegistrationConstants.OWNER;
import static controller.userregistration.UserRegistrationConstants.USER;


public class UserRegistrationController implements IUserRegistrationController {
    public static String emailId;
    String firstName;
    String lastName;
    long contact;
    String email;
    String password;
    String confirmPassword;
    String userData;
    String setType;


    public void UserRegistrationController()  {
        try{
            UserRegistrationCheck();
        }
        catch (Exception e){
            e.printStackTrace();
            UserRegistrationCheck();
        }
    }

    public void UserRegistrationCheck(){
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IUserRegistrationDAO iUserRegistrationDAO=ClassInitializer.initializer().getIUserRegistrationDAO();
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
        iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message","registration.main.message","welcomepage.add.message");
        setType();
        setFirstName();
        setLastName();
        setContact();
        setEmail();
        setPassword();
        iUserRegistrationDAO.userRegistration(iUsersModel);
        iMakeCLICommentListController.MakeCLICommentListController("registration.successful.message");
        getToTheSurvey();
    }
    public void setType() {
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
        try {
            if (userId==1){
                setType=USER;
            }
            else if(userId==2){
                setType=OWNER;
            }
            else{
                throw new InvalidInputException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            }
            iUsersModel.setType(setType);
        }catch (Exception e) {
            e.printStackTrace();
            setType();
        }
    }

    public void setFirstName() {
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();

        try {
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.first.name.message");
            firstName = iRoomsicleCLI.getStringResponse();
            iUsersModel.setFirstName(firstName);
    }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLastName() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        try {
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.last.name.message");
            lastName = iRoomsicleCLI.getStringResponse();
            iUsersModel.setLastName(lastName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setContact() {
        try {
            IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
            IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
            IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
            IPhoneNumberVerifierController iPhoneNumberVerifierController=ClassInitializer.initializer().getIPhoneNumberVerifierController();
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.contact.number.message");
            contact = iRoomsicleCLI.getLongNumberResponse();
            iPhoneNumberVerifierController.PhoneNumberVerifierController(contact);
            iUsersModel.setContactNumber(contact);
        }
        catch (Exception e) {
            e.printStackTrace();
            setContact();
        }
    }
    public void setEmail() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
        IEmailVerifierController iEmailVerifierController=ClassInitializer.initializer().getIEmailVerifierController();
        IEmailFormatVerfier iEmailFormatVerfier=ClassInitializer.initializer().getIEmailFormatVerfier();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        try {
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.email.id.message");
            email = iRoomsicleCLI.getStringResponse();
            if (userId==1) {
                userData= DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.login.email.password.query");
            }
            else if (userId==2) {
                userData= DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.login.email.password.query");
            }
            iEmailVerifierController.UserEmailAlreadyRegistered(email,userData);
            iEmailFormatVerfier.EmailFormatVerifier(email);
            emailId=email;
            iUsersModel.setEmailId(email);
        }
        catch (Exception e) {
            e.printStackTrace();
            setEmail();
        }
    }
    public void setPassword() {
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IUsersModel iUsersModel=ClassInitializer.initializer().getIUsersModel();
        IPasswordVerifierController iPasswordVerifierController=ClassInitializer.initializer().getIPasswordVerifierController();
        try {
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.password.message");
            password = iRoomsicleCLI.getStringResponse();
            iUsersModel.setPassword(password);
            iMakeCLICommentListController.MakeCLICommentListController("registration.identify.your.password.confirm.message");
            confirmPassword = iRoomsicleCLI.getStringResponse();
            iPasswordVerifierController.PasswordVerifierController(password, confirmPassword);
        }
        catch (Exception e) {
            e.printStackTrace();
            setPassword();
        }

    }

    public void getToTheSurvey(){
//        try {
//            if (userId==1){
//                iUserSurveyController.takeSurvey(emailId);
//            }
//            else if(userId==2){
//                ownerSurveyController.takeSurvey(emailId);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
