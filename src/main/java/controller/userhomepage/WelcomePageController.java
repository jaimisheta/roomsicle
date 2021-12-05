package controller.userhomepage;

import Exception.EmailException;
import Exception.InvalidInputException;
import Exception.PasswordNotMatchException;
import commandline.CommandLineInputProperties;
import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.userlogin.IUserLoginController;
import controller.userregistration.IUserRegistrationController;
import static controller.filterroommates.FilterRoommatesInputConstants.*;
import static controller.usersurvey.UserSurveyConstants.ZERO;

public class WelcomePageController implements IWelcomePageController {

    int userSelection;
    int setTypeInput;
    public static int userId;

    public void  showWelcomePage() {
        try {
            IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
           IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
            iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message","welcomepage.welcome.message",
                    "welcomepage.add.message","registration.identify.yourself.message","registration.identify.profile.message",
                    "welcomepage.welcome.select.user.choice.message");
            setTypeInput = iRoomsicleCLI.getNumberResponse();
            userId = setTypeInput;
            if (setTypeInput>=THREE || setTypeInput<=ZERO){
                throw new InvalidInputException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
            }

        UserSelection();
        }catch (Exception e){
            e.printStackTrace();
            showWelcomePage();
        }
    }
    public void UserSelection() throws InvalidInputException, EmailException, PasswordNotMatchException {
        IMakeCLICommentListController iMakeCLICommentListController=ClassInitializer.initializer().getIMakeCLICommentListController();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IUserLoginController iUserLoginController=ClassInitializer.initializer().getUserLoginController();
        IUserRegistrationController iUserRegistrationController=ClassInitializer.initializer().getIUserRegistrationController();
        iMakeCLICommentListController.MakeCLICommentListController("welcomepage.welcome.select.option.message","welcomepage.welcome.select.choice.message",
                "welcomepage.welcome.select.user.choice.message");
    userSelection = iRoomsicleCLI.getNumberResponse();
    if (userSelection==ONE){
        iUserLoginController.UserLoginController();
    }
        else if (userSelection==TWO){
        iUserRegistrationController.UserRegistrationController();
    }
        else{
        throw new InvalidInputException(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
    }
    }
}
