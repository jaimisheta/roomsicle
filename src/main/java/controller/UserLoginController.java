package controller;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;
import Exception.*;
import database.UserLoginDAO;
import models.UsersModel;

public class UserLoginController {
	public static String emailId;
	EmailVerfierController emailVerfierController=new EmailVerfierController();
	UsersModel usersModel=new UsersModel();
	UserLoginDAO userLoginDAO=new UserLoginDAO();
	RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
	String email;
	String password;
	public UserLoginController() {

		try {

			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("login.main.message"));
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("welcomepage.add.message"));
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("login.email.id.message"));
			email = roomsicleCLI.getStringResponse();
			emailId=email;
			usersModel.setEmailId(email);
			emailVerfierController.EmailVerfier(email);
			roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("login.password.message"));
			password = roomsicleCLI.getStringResponse();
			usersModel.setPassword(password);
			String emailValue = userLoginDAO.getUserLoginAndPassword().get(usersModel.getEmailId());
			if (emailValue != null) {
				if(userLoginDAO.getUserLoginAndPassword().get(usersModel.getEmailId()).equals(usersModel.getPassword()) ) {
					roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("login.successfull.message"));
				}
				else {
					throw new PasswordNotMatchException(CommandLineInputProperties.getCommandLineInputPropertyValue("login.email.password.verify.wrong"));

				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
