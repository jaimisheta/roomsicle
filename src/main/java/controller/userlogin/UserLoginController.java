package controller.userlogin;

import Exception.EmailException;
import Exception.PasswordNotMatchException;
import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.ControllerProperties;
import controller.verifications.IEmailFormatVerfier;
import controller.verifications.IEmailVerifierController;
import database.DatabaseQueryProperties;
import database.IUserLoginDAO;

import static controller.userhomepage.WelcomePageController.userId;
import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;


public class UserLoginController implements IUserLoginController {

	public static String emailId;
	String email;
	String password;
	String emailValue;
	String getUserData;

	public void  UserLoginController() throws  EmailException, PasswordNotMatchException {
		try {
			giveCreds();
		}catch (Exception e){
			e.printStackTrace();
			giveCreds();
		}
	}

	public  int getUserID(){
		return userId;
	}

	public String CheckCreds()  {
		if (getUserID()==ONE) {
			getUserData = DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.login.email.password.query");
		}else if (getUserID()==TWO){
			getUserData = DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.login.email.password.query");
		}
		return getUserData;
		}

	public String AfterChecking(){
		IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
		iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message"
				, "login.main.message", "welcomepage.add.message"
				,"login.email.id.message");
		return CommandLineInputProperties.getCommandLineInputPropertyValue("login.successfull.message");

	}
	public void giveCreds() throws EmailException, PasswordNotMatchException {
		IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
		IEmailFormatVerfier iEmailFormatVerfier=ClassInitializer.initializer().getIEmailFormatVerfier();
		IEmailVerifierController iEmailVerifierController=ClassInitializer.initializer().getIEmailVerifierController();
		IMakeCLICommentListController iMakeCLICommentListController=ClassInitializer.initializer().getIMakeCLICommentListController();
		IUserLoginDAO iUserLoginDAO=ClassInitializer.initializer().getIUserLoginDAO();

		AfterChecking();
		email = iRoomsicleCLI.getStringResponse();
		iEmailFormatVerfier.EmailFormatVerifier(email);
		iEmailVerifierController.EmailDoesnotExists(email,CheckCreds());
		ControllerProperties.setControllerPropertyValue("user.logged.in.email.id",email);
		emailId=email;
		iMakeCLICommentListController.MakeCLICommentListController("login.password.message");
		password = iRoomsicleCLI.getStringResponse();
		emailValue= iUserLoginDAO.getUserLoginAndPassword(CheckCreds()).get(email);
		Login();
	}

	public String ValidatecheckCreds(String email){
		this.email=emailId;
		return email;
	}
	public void Login() throws PasswordNotMatchException {
		ICheckSurveyTaken iCheckSurveyTaken=ClassInitializer.initializer().getICheckSurveyTaken();
		IMakeCLICommentListController iMakeCLICommentListController=ClassInitializer.initializer().getIMakeCLICommentListController();
		IUserLoginDAO iUserLoginDAO=ClassInitializer.initializer().getIUserLoginDAO();
			if (emailValue == null) {
			throw new PasswordNotMatchException(CommandLineInputProperties.getCommandLineInputPropertyValue("login.fail.email.id.null.message"));
		}
		else{
			if(iUserLoginDAO.getUserLoginAndPassword(CheckCreds()).get(email).equals(password) ) {
				iMakeCLICommentListController.MakeCLICommentListController("login.successfull.message");
				iCheckSurveyTaken.CheckSurveyTaken(email);
			}
			else {
				throw new PasswordNotMatchException(CommandLineInputProperties.getCommandLineInputPropertyValue("login.email.password.verify.wrong"));
			}
		}
	}
}
