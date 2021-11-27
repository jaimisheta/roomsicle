package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import database.UserRegistrationDAO;
import models.UsersModel;
import static controller.UserRegistrationConstants.user;
import static controller.UserRegistrationConstants.owner;


public class UserRegistrationController {
    public static String emailId;
    public static Integer userIdentity;
    RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
    String firstName;
    String lastName;
    String contact;
    String email;
    String password;
    String confirmPassword;
    Integer surveyTaken;
    Integer setTypeInput;
    String setType;
    UsersModel usersModel=new UsersModel();
    UserRegistrationDAO userRegistrationDAO=new UserRegistrationDAO();
    EmailVerfierController emailVerfierController=new EmailVerfierController();
    PasswordVerifierController passwordVerifierController=new PasswordVerifierController();
    UserSurveyController userSurveyController=new UserSurveyController();
    OwnerSurveyController ownerSurveyController=new OwnerSurveyController();
    public  UserRegistrationController()  {
        try{
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.main.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.yourself.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.profile.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.welcome.select.user.choice.message"));
        setType();
        setFirstName();
        setLastName();
        setContact();
        setEmail();
        setPassword();
        setSurveyTaken();
        userRegistrationDAO.userRegistration(usersModel);
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.successful.message"));
        getToTheSurvey();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setType() {
        try {
            setTypeInput = roomsicleCLI.getNumberResponse();
            userIdentity=setTypeInput;
            if (setTypeInput.equals(1)){
                setType=user;
            }
            else if(setTypeInput.equals(2)){
                setType=owner;
            }
            else{
                roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
                System.exit(1);
            }
            usersModel.setType(setType);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setFirstName() {
        try {
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.first.name.message"));
        firstName = roomsicleCLI.getStringResponse();
        usersModel.setFirstName(firstName);
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setLastName() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.last.name.message"));
            lastName = roomsicleCLI.getStringResponse();
            usersModel.setLastName(lastName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setContact() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.contact.number.message"));
            contact = roomsicleCLI.getStringResponse();
            usersModel.setContactNumber(contact);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setEmail() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.email.id.message"));
            email = roomsicleCLI.getStringResponse();
            emailVerfierController.EmailVerfier(email);//Verify if email id format is not correct
            emailVerfierController.EmailAlreadyRegistered(email);//Verify if email id is already exists.
            emailVerfierController.EmailAlreadyRegistered(email);
            emailId=email;
            usersModel.setEmailId(email);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void setPassword() {
        try {
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.password.message"));
            password = roomsicleCLI.getStringResponse();
            usersModel.setPassword(password);
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.password.confirm.message"));
            confirmPassword = roomsicleCLI.getStringResponse();
            passwordVerifierController.PasswordVerifierController(password, confirmPassword);//It checks if password matches with confirm password
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void setSurveyTaken(){
        try{
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.identify.your.survey.taken.message"));
        surveyTaken = roomsicleCLI.getNumberResponse();
        usersModel.setSurveyTaken(surveyTaken);

    }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getToTheSurvey(){
        try {
            if (userIdentity.equals(1)){
                userSurveyController.takeSurvey(emailId);
            }
            else if(userIdentity.equals(2)){
                ownerSurveyController.takeSurvey(emailId);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}